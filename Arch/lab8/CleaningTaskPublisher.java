public interface CleaningTaskPublisher {
    void publishTaskCreated(CleaningTask task);
    void publishTaskUpdated(CleaningTask task);
}
