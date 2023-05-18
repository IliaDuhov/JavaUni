public class SlidingWindowLog {
    private int[] log;
    private int currentIndex;

    public SlidingWindowLog(int size) {
        log = new int[size];
        currentIndex = 0;
    }

    public synchronized void addEvent(int event) {
        log[currentIndex] = event;
        currentIndex = (currentIndex + 1) % log.length;
    }

    public synchronized int[] getEvents() {
        int[] events = new int[log.length];
        for (int i = 0; i < log.length; i++) {
            events[i] = log[(currentIndex + i) % log.length];
        }
        return events;
    }
}



public class EventLogger {
    private SlidingWindowLog slidingWindowLog;

    public EventLogger() {
        slidingWindowLog = new SlidingWindowLog(10); // размер журнала - 10
    }

    public void logEvent(int event) {
        slidingWindowLog.addEvent(event);
        int[] events = slidingWindowLog.getEvents();
        // анализируем последние события
        for (int i = 0; i < events.length; i++) {
            // обрабатываем событие
        }
    }
}
