package ru.pdn.sfedu.operationshistory.dto

import java.math.BigDecimal
import java.util.*

class DtoOperation (
    val fromAccount: String? = null,
    val toAccount: String? = null,
    val amount: BigDecimal? = null,
    val currency: String? = null,
    val date: Date? = null
)