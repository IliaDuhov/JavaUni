public class TrafficController {
    private LeakingBucket leakingBucket;

    public TrafficController() {
        leakingBucket = new LeakingBucket(100, 10); // максимальный объем - 100, скорость вытекания - 10
    }

    public void handleTraffic(int volume) {
        leakingBucket.addTraffic(volume);
        while (leakingBucket.getCurrentVolume() > 0) {
            // обрабатываем трафик
            leakingBucket.leak();
        }
    }
}
