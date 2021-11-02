package ua.vehicle.registrations.vehicle.data.ingestion.service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
