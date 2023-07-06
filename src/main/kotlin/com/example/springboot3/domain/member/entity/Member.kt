package com.example.springboot3.domain.member.entity

import com.example.springboot3.domain.team.entity.Team
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

    @Column(name = "member_name")
    private val memberName : String,

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id", insertable = false, updatable = false, foreignKey = ForeignKey(name = "FK_TEAM_TO_MEMBER")) // insertable,updatable = false -> 백엔드에서 DB에 직접적인 영향을 주지 않기 위함.
    @JoinColumn(name = "team_id", updatable = false, foreignKey = ForeignKey(name = "FK_TEAM_TO_MEMBER"))
    private val team : Team
)