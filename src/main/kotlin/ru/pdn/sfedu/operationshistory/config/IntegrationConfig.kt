package ru.pdn.sfedu.operationshistory.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.integration.annotation.InboundChannelAdapter
import org.springframework.integration.annotation.Poller
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.config.EnableIntegration
import org.springframework.integration.file.FileReadingMessageSource
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.xml.transform.StringSource
import ru.pdn.sfedu.operationshistory.model.Operations
import ru.pdn.sfedu.operationshistory.model.OperationsRepo
import java.io.File

@Configuration
@EnableIntegration
class IntegrationConfig(
        private val operationsMarshaller: Jaxb2Marshaller,
        private val operationsRepo: OperationsRepo,
        @Value("\${file.in}")
        private val fileInPath: String
) {
    @Bean
    @InboundChannelAdapter(value = "operationsFileChannel", poller = [Poller(fixedDelay = "5000")])
    fun fileSource() = FileReadingMessageSource().apply {
        setDirectory(File(fileInPath))
    }

    @ServiceActivator(inputChannel = "operationsFileChannel", outputChannel = "nullChannel")
    fun fileProcessor(file: File) {
        val operations = operationsMarshaller.unmarshal(StringSource(file.readText())) as Operations
        println(file.name)
        println(operations)
        operationsRepo.saveAll(operations.operations!!)

        val operationsFromDB = operationsRepo.findByFromAccountAndToAccount("40817810570000123456", "40817810570000000001")

        print(operationsFromDB)
    }
}