package com.example.springboot3.repository

import com.example.springboot3.domain.team.entity.Team
import com.example.springboot3.domain.member.entity.Member
import com.example.springboot3.domain.member.entity.repository.MemberRepository
import com.example.springboot3.domain.team.entity.repository.TeamRepository
import com.example.springboot3.repository.member.MemberQueryDslRepository
import com.example.springboot3.repository.team.TeamQueryDslRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("local")
class TeamQueryDslRepositoryTest(
    @Autowired private val teamQueryDslRepository: TeamQueryDslRepository,
    @Autowired private val memberQueryDslRepository: MemberQueryDslRepository,
    @Autowired private val memberRepository: MemberRepository,
    @Autowired private val teamRepository: TeamRepository,
) {

    @BeforeEach
    fun `시작전_세팅`() {
        val teamAMemberSet : MutableSet<Member?> = mutableSetOf(null)
        val teamBMemberSet : MutableSet<Member?> = mutableSetOf(null)

        val teamA = Team(1,"teamA", teamAMemberSet)
        val teamB = Team(2,"teamB", teamBMemberSet)

        val member1 = Member(1, "멤버1", teamA)
        val member2 = Member(2, "멤버2", teamA)
        val member3 = Member(3, "멤버3", teamB)
        val member4 = Member(4, "멤버4", teamB)
        val member5 = Member(5, "멤버5", teamA)

        teamAMemberSet.add(member1)
        teamAMemberSet.add(member2)
        teamAMemberSet.add(member5)

        teamBMemberSet.add(member3)
        teamBMemberSet.add(member4)


        teamRepository.save(teamA)
        teamRepository.save(teamB)

        memberRepository.save(member1)
        memberRepository.save(member2)
        memberRepository.save(member3)
        memberRepository.save(member4)
        memberRepository.save(member5)




        println("시작")

    }

    @Test
    fun `기본_테스트`() {
        println("테스트 : ${memberQueryDslRepository.memberTeamFetchJoin()}")

    }

}