package com.example.springboot3.domain.team

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id



@Entity
data class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long
)
