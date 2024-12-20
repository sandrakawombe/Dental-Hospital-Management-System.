package snakayima.miu.edu.dentalhospitalmgmtsystem.SystemConfigurations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
public class AppointmentSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value(value = "${springjms.cs544Queue}")
    private String queueName;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queueName, message);
        System.out.println("Message sent to queue " + queueName);
    }
}
