package ru.pdn.sfedu.operationshistory.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "operations")
@XmlAccessorType(XmlAccessType.FIELD)
class Operations (
        @field:XmlElement(name = "operation")
        val operations: List<Operation>? = null
) {
        override fun toString(): String {
                return "Operations(operations=$operations)"
        }
}