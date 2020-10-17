package ru.pdn.sfedu.operationshistory.config

import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val OPERATION = "operation"

@Configuration
class AmqpConfig {

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory) = RabbitTemplate(connectionFactory).apply {
        messageConverter = Jackson2JsonMessageConverter()
    }

    @Bean
    fun operationQueue() = Queue(OPERATION)

    @Bean
    fun operationExchange() = DirectExchange("operation.direct")

    @Bean
    fun operationBinding() = BindingBuilder
            .bind(operationExchange())
            .to(operationExchange())
            .with(OPERATION)

}