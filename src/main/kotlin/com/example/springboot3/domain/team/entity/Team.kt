package com.example.springboot3.domain.team.entity

import com.example.springboot3.domain.member.entity.Member
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany


@Entity
data class Team(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    val id : Long,

    @Column(name = "team_name")
    val teamName : String,

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
//    private val members : MutableSet<Member?>

) {
    @OneToMany(mappedBy = "team")
    lateinit var members : MutableList<Member>
}
