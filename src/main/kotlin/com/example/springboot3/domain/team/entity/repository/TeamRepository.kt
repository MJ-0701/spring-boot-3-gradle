package com.example.springboot3.domain.team.entity.repository

import com.example.springboot3.domain.team.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository :  JpaRepository<Team, Long> {
}