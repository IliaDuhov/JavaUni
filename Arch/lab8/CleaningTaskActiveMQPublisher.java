public class CleaningTaskActiveMQPublisher implements CleaningTaskPublisher {
    private final JmsTemplate jmsTemplate;

    public CleaningTaskActiveMQPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void publishTaskCreated(CleaningTask task) {
        jmsTemplate.convertAndSend("cleaning_task_created", task);
    }

    @Override
    public void publishTaskUpdated(CleaningTask task) {
        jmsTemplate.convertAndSend("cleaning_task_updated", task);
    }
}
