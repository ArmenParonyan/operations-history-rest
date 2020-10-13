package ru.pdn.sfedu.operationshistory.model

import javax.persistence.*

@Entity
@Table(name = "client")
class Client (
        @Column(name = "name")
        val name: String? = null,
        @Column(name = "secondName")
        val secondName: String? = null,
        @Column(name = "age")
        val age: Int? = null,
        @OneToMany(mappedBy = "client", cascade = arrayOf(CascadeType.ALL))
        val operations: List<Operation> = arrayListOf()
): Domain()