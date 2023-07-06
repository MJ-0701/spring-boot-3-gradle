package com.example.springboot3.repository.member

import com.example.springboot3.domain.member.entity.Member
import com.example.springboot3.domain.member.entity.QMember.member
import com.example.springboot3.domain.member.web.dto.MemberDto
import com.example.springboot3.domain.team.entity.QTeam
import com.example.springboot3.domain.team.entity.QTeam.*
import com.example.springboot3.utils.QuerydslPageAndSortRepository
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.stereotype.Component

@Component
class MemberQueryDslRepository(
    val queryFactory: JPAQueryFactory,
    em: EntityManager
) : QuerydslPageAndSortRepository(em, Member::class.java) {

    fun getAllMemberList(): List<Member> {
        return queryFactory.select(
            member
        ).from(
            member
        ).fetch()
    }

    fun getMemberTeamList(teamId: Long): List<Member> {
        return queryFactory.select(
            member
        ).from(
            member
        ).where(
            member.team.id.eq(teamId)
        ).fetch()
    }

    fun memberTeamFetchJoin(teamId: Long): List<MemberDto.MemberDtoResponse> {
        return queryFactory.select(
            Projections.constructor(
                MemberDto.MemberDtoResponse::class.java,
                member.memberId,
                member.memberName,
                team.id,
                team.teamName
            )
        ).from(
            member
        ).leftJoin(team).on(
            member.team.eq(team)
        ).where(
            member.team.id.eq(teamId)
        ).fetch()

    }

}