package ru.pdn.sfedu.operationshistory

import ru.pdn.sfedu.operationshistory.dto.DtoOperation
import ru.pdn.sfedu.operationshistory.model.Operation

fun Operation.toDtoOperation(): DtoOperation{
    return DtoOperation(
            fromAccount = this.fromAccount,
            toAccount = this.toAccount,
            amount = this.amount,
            currency = this.currency,
            date =  this.date
    )
}