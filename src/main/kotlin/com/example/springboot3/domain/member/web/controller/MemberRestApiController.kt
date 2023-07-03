package com.example.springboot3.domain.member.web.controller

import com.example.springboot3.domain.member.service.MemberService
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberRestApiController(
    private val memberService: MemberService,
) {
}