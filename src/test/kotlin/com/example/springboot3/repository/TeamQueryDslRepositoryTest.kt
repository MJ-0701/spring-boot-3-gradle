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
import org.springframework.transaction.annotation.Transactional

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
        val teamAList : MutableList<Member> = mutableListOf()
        val teamBList : MutableList<Member> = mutableListOf()

        val teamA = Team(1,"teamA")
        val teamB = Team(2,"teamB")

        val member1 = Member(1, "멤버1", teamA)
        val member2 = Member(2, "멤버2", teamA)
        val member3 = Member(3, "멤버3", teamB)
        val member4 = Member(4, "멤버4", teamB)
        val member5 = Member(5, "멤버5", teamA)

        teamAList.add(member1)
        teamAList.add(member2)
        teamAList.add(member5)

        teamBList.add(member3)
        teamBList.add(member4)


        teamRepository.save(teamA)
        teamRepository.save(teamB)

        memberRepository.save(member1)
        memberRepository.save(member2)
        memberRepository.save(member3)
        memberRepository.save(member4)
        memberRepository.save(member5)

        println("시작")
        println("teamA : $teamA")
        println("teamB : $teamB")
        println("mbmer1 : $member1")

    }

//    @Transactional // 붙여주면 테스트일 경우 자동으로 insert 데이터를 roll-back 해줌
    @Test
    fun `기본_테스트`() {
        println("테스트")
        println("멤버 List : ${memberQueryDslRepository.getAllMemberList()}")
        println("멤버 List2 : ${memberQueryDslRepository.getMemberTeamList(1L)}")
        println("멤버 조인 테스트 : ${memberQueryDslRepository.memberTeamFetchJoin(1L)}")
        println("팀 List : ${teamQueryDslRepository.test()}")
    }

}