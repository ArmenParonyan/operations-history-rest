package ru.pdn.sfedu.operationshistory.model

import ru.pdn.sfedu.operationshistory.DateAdapter
import java.math.BigDecimal
import java.util.*
import javax.persistence.*
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter

@XmlAccessorType(XmlAccessType.FIELD)
class Operation(
        @field:XmlElement(name = "fromAccount")
        val fromAccount: String? = null,
        @field:XmlElement(name = "toAccount")
        val toAccount: String? = null,
        @field:XmlElement(name = "amount")
        val amount: BigDecimal? = null,
        @field:XmlElement(name = "currency")
        val currency: String? = null,
        @field:XmlElement(name = "date")
        @field:XmlJavaTypeAdapter(value = DateAdapter::class)
        val date: Date? = null,
        @field:XmlElement(name = "id")
        val docId: Long? = null
) {
    override fun toString(): String {
        return "Operation(amount=$amount, date=$date)"
    }
}