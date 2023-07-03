package com.example.springboot3.domain.member.service

import com.example.springboot3.repository.team.TeamQueryDslRepository
import org.springframework.stereotype.Service

@Service
class MemberService(
    private val teamQueryDslRepository: TeamQueryDslRepository,
) {
}