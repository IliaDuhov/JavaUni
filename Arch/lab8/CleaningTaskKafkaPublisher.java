public class CleaningTaskKafkaPublisher implements CleaningTaskPublisher {
    private final KafkaProducer<String, CleaningTask> kafkaProducer;

    public CleaningTaskKafkaPublisher(KafkaProducer<String, CleaningTask> kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void publishTaskCreated(CleaningTask task) {
        ProducerRecord<String, CleaningTask> record = new ProducerRecord<>("cleaning_task_created", task.getId().toString(), task);
        kafkaProducer.send(record);
    }

    @Override
    public void publishTaskUpdated(CleaningTask task) {
        ProducerRecord<String, CleaningTask> record = new ProducerRecord<>("cleaning_task_updated", task.getId().toString(), task);
        kafkaProducer.send(record);
    }
