import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

    private static final AtomicLong snowflake = new AtomicLong(0L);

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/uuid")
    public String generateUUID() {
        return java.util.UUID.randomUUID().toString();
    }

    @GetMapping("/snowflake/{datacenterId}/{workerId}")
    public long generateSnowflakeId(@PathVariable int datacenterId, @PathVariable int workerId) throws UnknownHostException, SocketException {
        long id = snowflake.getAndIncrement();

        long timestamp = System.currentTimeMillis();

        long workerIdBits = 5L;
        long datacenterIdBits = 5L;
        long maxWorkerId = ~(-1L << workerIdBits);
        long maxDatacenterId = ~(-1L << datacenterIdBits);
        long sequenceBits = 12L;
        long workerIdShift = sequenceBits;
        long datacenterIdShift = sequenceBits + workerIdBits;
        long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
        long sequenceMask = ~(-1L << sequenceBits);

        long twepoch = 1288834974657L;
        long datacenterIdBitsShift = datacenterIdShift + workerIdBits;
        long twepochShift = timestampLeftShift - twepoch;

        InetAddress inetAddress = getLocalHostLANAddress();

        long worker;

        byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();

        if (mac == null) {
            worker = 0;
        } else {
            worker = ((0x000000FF & (long) mac[mac.length / 2]) |
                    (0x0000FF00 & (((long) mac[(mac.length / 2) - 1]) << 8))) >> 6;
            worker = worker % (maxWorkerId + 1);
        }

        long datacenter = datacenterId % (maxDatacenterId + 1);

        long snowflakeId = ((timestamp - twepoch) << twepochShift) |
                (datacenter << datacenterIdBitsShift) |
                (worker << workerIdShift) |
                id;

        return snowflakeId;
    }

    private static InetAddress getLocalHostLANAddress() throws SocketException {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface curr = interfaces.nextElement();
                if (!curr.isUp() || curr.isLoopback() || curr.isVirtual()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = curr.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr.isSiteLocalAddress()) {
                        return addr;
                    }
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
