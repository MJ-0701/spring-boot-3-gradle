package com.example.springboot3.domain.user

import com.example.springboot3.domain.team.Team
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private val memberId : Long,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id", insertable = false, updatable = false, foreignKey = ForeignKey(name = "FK_TEAM_TO_MEMBER"))
    private val team : Team
)