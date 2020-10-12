package ru.pdn.sfedu.operationshistory.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import ru.pdn.sfedu.operationshistory.model.Operations

@Configuration
class CommonConfig {
    @Bean
    fun operationsMarshaller() = Jaxb2Marshaller().apply {
        setClassesToBeBound(Operations::class.java)
        setMarshallerProperties(mapOf("jaxb.formatted.output" to true))
    }
}