public class CleaningTaskCommandController {
    private final CleaningTaskRepository cleaningTaskRepository;
    private final CleaningTaskPublisher cleaningTaskPublisher;

    public CleaningTaskCommandController(CleaningTaskRepository cleaningTaskRepository, CleaningTaskPublisher cleaningTaskPublisher) {
        this.cleaningTaskRepository = cleaningTaskRepository;
        this.cleaningTaskPublisher = cleaningTaskPublisher;
    }

    public void createCleaningTask(String taskName, String taskDescription, long roomId, long userId) {
        Room room = roomRepository.getRoomById(roomId);
        User user = userRepository.getUserById(userId);
        CleaningTask cleaningTask = new CleaningTask(UUID.randomUUID(), taskName, taskDescription, room, user, new Date(), CleaningTaskStatus.TO_DO);
        cleaningTaskRepository.addCleaningTask(cleaningTask);
        cleaningTaskPublisher.publishTaskCreated(cleaningTask);
    }

    public void updateCleaningTask(UUID taskId, String taskName, String taskDescription, long roomId, long userId) {
        CleaningTask cleaningTask = cleaningTaskRepository.getCleaningTaskById(taskId);
        if (cleaningTask == null) {
            throw new CleaningTaskNotFoundException(taskId);
        }
        Room room = roomRepository.getRoomById(roomId);
        User user = userRepository.getUserById(userId);
        cleaningTask.setName(taskName);
        cleaningTask.setDescription(taskDescription);
        cleaningTask.setRoom(room);
        cleaningTask.setExecutor(user);
        cleaningTaskRepository.updateCleaningTask(cleaningTask);
        cleaningTaskPublisher.publishTaskUpdated(cleaningTask);
    }
}
