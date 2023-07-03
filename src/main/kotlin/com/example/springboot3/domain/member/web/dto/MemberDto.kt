package com.example.springboot3.domain.member.web.dto

import com.example.springboot3.domain.team.entity.Team
import com.querydsl.core.annotations.QueryProjection

object MemberDto {

    data class MemberDtoResponse @QueryProjection constructor(
        val memberId : Long,
        val memberName : String,
        val team : Team?
    )

}