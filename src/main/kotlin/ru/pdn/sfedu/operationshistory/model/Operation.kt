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
@Entity
@Table(name = "operations")
class Operation (
        @field:XmlElement(name = "fromAccount")
        @Column(name = "from_account")
        val fromAccount: String? = null,
        @field:XmlElement(name = "toAccount")
        @Column(name = "to_account")
        val toAccount: String? = null,
        @field:XmlElement(name = "amount")
        @Column(name = "amount")
        val amount: BigDecimal? = null,
        @field:XmlElement(name = "currency")
        @Column(name = "currency")
        val currency: String? = null,
        @field:XmlElement(name = "date")
        @field:XmlJavaTypeAdapter(value = DateAdapter::class)
        @Column(name = "date")
        val date: Date? = null,
        @field:XmlElement(name = "id")
        @Column(name = "doc_id")
        val docId: Long? = null,
        @ManyToOne
        @JoinColumn(name = "clientId")
        val client: Client? = null
): Domain() {
        override fun toString(): String {
                return "Operation(amount=$amount, date=$date)"
        }
}