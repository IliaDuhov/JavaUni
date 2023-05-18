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
