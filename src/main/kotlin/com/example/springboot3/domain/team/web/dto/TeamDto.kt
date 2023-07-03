package com.example.springboot3.domain.team.web.dto

import com.example.springboot3.domain.member.entity.Member
import com.querydsl.core.annotations.QueryProjection

object TeamDto {

    data class TeamDtoResponse @QueryProjection constructor(
        val teamId : Long,
        val teamName : String,
        val members : Set<Member>
    )
}