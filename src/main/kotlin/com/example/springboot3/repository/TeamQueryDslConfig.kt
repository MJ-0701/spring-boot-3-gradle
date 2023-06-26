package com.example.springboot3.repository

import com.example.springboot3.domain.team.QTeam
import com.example.springboot3.domain.team.QTeam.*
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class TeamQueryDslConfig (
    val queryFactory : JPAQueryFactory,
    em : EntityManager
) {

    fun test() {
        queryFactory.select(team).from(team).fetch()
    }
}