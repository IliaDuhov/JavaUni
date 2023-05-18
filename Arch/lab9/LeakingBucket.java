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

//алгоритм управления трафиком, который используется для контроля над количеством трафика, поступающего на сервер. Алгоритм работает следующим образом: 

//1. Создать переменные для хранения текущего объема трафика (currentVolume), максимального объема трафика (maxVolume) и скорости вытекания трафика (leakRate).

//2. При поступлении нового пакета данных на сервер, добавить его объем к текущему объему трафика.

//3. Если текущий объем трафика превышает максимальный объем, отбросить лишний объем.

//4. Каждую секунду вычитать из текущего объема трафика скорость вытекания трафика (leakRate).

//5. Повторять шаги 2-4 до тех пор, пока поступает новый трафик.

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
