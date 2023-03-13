package com.dkb.urlshortner.entity

import javax.persistence.*

@Entity(name = "url")
class URL(
    @Column(nullable = false, unique = true) val hash: String,
    @Column(nullable = false, unique = true) val longURL: String,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
)
