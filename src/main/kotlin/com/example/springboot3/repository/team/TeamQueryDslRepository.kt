package com.example.springboot3.repository.team

import com.example.springboot3.domain.member.web.dto.MemberDto
import com.example.springboot3.domain.team.entity.QTeam.team
import com.example.springboot3.domain.team.entity.Team
import com.example.springboot3.domain.team.web.dto.TeamDto
import com.example.springboot3.utils.QuerydslPageAndSortRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class TeamQueryDslRepository (
    val queryFactory : JPAQueryFactory,
    em : EntityManager
) : QuerydslPageAndSortRepository(em, Team::class.java){

    fun teamDtoTest() : List<TeamDto.TeamDtoResponse>{
        return queryFactory.select(
            Projections.constructor(
                TeamDto.TeamDtoResponse::class.java,
                team.id,
                team.teamName,
                team.members
            )
        ).from().fetch()
    }

    fun test() {
        queryFactory.select(team).from(team).fetch()
    }
}