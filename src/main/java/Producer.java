import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {

    public void producerMethod(){
        //Create Properties for Producer
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Create Producer
        final KafkaProducer<String,String> kafkaProducer = new KafkaProducer<>(properties);

        //Create Producer Record
        ProducerRecord<String, String> producerRecord= new ProducerRecord<>("Tolulope", "key","You can consume messages from this topic");

        //Send data asynchronously
        kafkaProducer.send(producerRecord);

        //flush producer
        kafkaProducer.flush();

        //close producer
        kafkaProducer.close();
    }
}
