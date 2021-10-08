package ua.vehicle.registrations.vehicle.data.ingestion.service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.vehicle.registrations.vehicle.data.ingestion.service.dto.CsvVehicleRegistrationRecordDto;
import ua.vehicle.registrations.vehicle.data.ingestion.service.handlers.GeneralCsvRegistrationRecordHandler;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue.DlqMessageListenerListener;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue.OnMessageListener;
import ua.vehicle.registrations.vehicle.data.ingestion.service.services.queue.RegistrationReceiver;

@Configuration
public class QueuesConfig {
    public static final String DLQ = "dead-letter-queue";
    public static final String DLQ_EXCHANGE = "dead-letter-queue-exchange";
    public static final String DLQ_TOPIC = "dead.letter.queue.topic.#";

    @Bean("dlqQueue")
    public Queue queue() {
        return new Queue(DLQ, false);
    }

    @Bean("dlqExchange")
    public TopicExchange exchange() {
        return new TopicExchange(DLQ_EXCHANGE);
    }

    @Bean("dlqBinding")
    public Binding binding(@Qualifier("dlqQueue") Queue queue,
                           @Qualifier("dlqExchange") TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(DLQ_TOPIC);
    }

    @Bean("registrationListenerAdapter")
    public MessageListenerAdapter listenerAdapter(RegistrationReceiver receiver) {
        return new MessageListenerAdapter(receiver, "process");
    }

    @Bean("registrationContainer")
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, @Qualifier("registrationListenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(DLQ);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public OnMessageListener<CsvVehicleRegistrationRecordDto> onCsvVehicleRegistrationRecordMessageListener(GeneralCsvRegistrationRecordHandler generalCsvRegistrationRecordHandler) {
        return new DlqMessageListenerListener(generalCsvRegistrationRecordHandler);
    }

}
