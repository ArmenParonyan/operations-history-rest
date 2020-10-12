package ru.pdn.sfedu.operationshistory

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.xml.transform.StringResult
import org.springframework.xml.transform.StringSource
import ru.pdn.sfedu.operationshistory.model.Operations
import java.io.File

@SpringBootTest
class OperationsHistoryApplicationTests {
    @Autowired
    lateinit var operationsMarshaller: Jaxb2Marshaller

    @Test
    fun contextLoads() {
        val str = File("c:/operations/operations.xml").readText()

        val obj = operationsMarshaller.unmarshal(StringSource(str))

        val res = StringResult()
        operationsMarshaller.marshal(obj, res)
        val operationsString = res.toString()

        println(operationsString)
    }
}
