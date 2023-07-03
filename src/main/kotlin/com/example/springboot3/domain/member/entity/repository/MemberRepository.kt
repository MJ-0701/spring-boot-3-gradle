package com.example.springboot3.domain.member.entity.repository

import com.example.springboot3.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}