package dev.jayhan.querydsltest

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.TestPropertySource

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(locations= ["classpath:application.yml"])
class QueryDslTest {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Test
    fun test1() {
        val user = User().apply {
            this.name = "Jay"
            this.mobiles = listOf("01031808148", "01033292048")
        }
        userRepository.saveAndFlush(user)
        println("saved user.id = " + user.id)

        assertNotNull(userRepository.findByIdOrNull(1))

        val user1 = userRepository.findByPhone(listOf("01033292048"))
        assertNotNull(user1)
        assertTrue(user1!!.mobiles.contains("01033292048"))
    }
}