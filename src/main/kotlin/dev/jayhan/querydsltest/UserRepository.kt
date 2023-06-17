package dev.jayhan.querydsltest

import com.querydsl.core.types.dsl.Expressions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

interface UserRepository: JpaRepository<User, Long>, UserCustomRepository
interface UserCustomRepository {
    fun findByPhone(candidate: Collection<String>): User?
}

class UserRepositoryImpl : QuerydslRepositorySupport(User::class.java), UserCustomRepository {
    override fun findByPhone(candidate: Collection<String>): User? {
        val users = QUser.user
        return from(users)
            .where(
                Expressions.booleanTemplate("arrayoverlap({0}, {1}) = true", users.mobiles, candidate.toTypedArray())
            )
            .fetchOne()
    }
}