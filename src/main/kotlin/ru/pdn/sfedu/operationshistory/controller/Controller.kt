package ru.pdn.sfedu.operationshistory.controller

import org.springframework.web.bind.annotation.*
import ru.pdn.sfedu.operationshistory.model.OperationsRepo

@RestController
class Controller(
        private val operationsRepo: OperationsRepo
) {

    @GetMapping("/getAll={fromAccount}")
    fun getAll(@PathVariable fromAccount: String) = operationsRepo.findByFromAccount(fromAccount)

    @PostMapping("/getAcc")
    fun getByFromAccount(@RequestBody fromAccount: String) = operationsRepo.findByFromAccount(fromAccount)
}