public class LeakingBucket {
    private int currentVolume;
    private int maxVolume;
    private int leakRate;

    public LeakingBucket(int maxVolume, int leakRate) {
        this.maxVolume = maxVolume;
        this.leakRate = leakRate;
    }

    public synchronized void addTraffic(int volume) {
        currentVolume += volume;
        if (currentVolume > maxVolume) {
            currentVolume = maxVolume;
        }
    }

    public synchronized void leak() {
        currentVolume -= leakRate;
        if (currentVolume < 0) {
            currentVolume = 0;
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getLeakRate() {
        return leakRate;
    }
}


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
