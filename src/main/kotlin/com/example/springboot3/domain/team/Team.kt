package com.example.springboot3.domain.team

import com.example.springboot3.domain.user.Member
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany


@Entity
data class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    val id : Long,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
    private val members : HashSet<Member>

)
