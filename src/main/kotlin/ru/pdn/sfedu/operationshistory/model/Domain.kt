package ru.pdn.sfedu.operationshistory.model

import javax.persistence.*

@MappedSuperclass
abstract class Domain(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        var id: Long? = null
)