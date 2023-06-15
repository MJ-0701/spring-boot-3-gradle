package com.example.springboot3.utils

import com.querydsl.core.types.dsl.PathBuilderFactory
import com.querydsl.jpa.JPQLQuery
import com.querydsl.jpa.impl.JPAQuery
import jakarta.persistence.EntityManager
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.support.Querydsl

open class QuerydslPageAndSortRepository(
    private val entityManager: EntityManager,
    private val clazz: Class<*>
) {

    private fun getQuerydsl(): Querydsl {
        val builder = PathBuilderFactory().create(clazz)
        return Querydsl(entityManager, builder)
    }

    fun <T> getPageImpl(pageable: Pageable, query: JPQLQuery<T>): PageImpl<T> {
        val totalCount = query.fetchCount()
        val results = getQuerydsl()
            .applyPagination(pageable, query)
            .fetch()

        return PageImpl(results, pageable, totalCount)
    }

    fun <T> getRandomPageImpl(pageable: Pageable, query: JPQLQuery<T>): PageImpl<T> {
        val totalCount = query.fetchCount()
        val results = getQuerydsl()
            .applyPagination(pageable, query)
            .fetch().shuffled().shuffled()

        return PageImpl(results, pageable, totalCount)
    }

    // 코틀린 익스텐션으로 JPAQuery 에 페이징 기능 추가
    fun <T> JPAQuery<T>.withPageable(pageable: Pageable): JPAQuery<T> {
        return this.limit(pageable.pageSize.toLong())
            .offset(pageable.offset)
    }
}

