package dev.jayhan.querydsltest

import com.vladmihalcea.hibernate.type.array.ListArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
@TypeDef(
    name = "list-array",
    typeClass = ListArrayType::class
)
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    @Column
    var name: String = ""

    @Type(type = "list-array")
    @Column(columnDefinition = "text[]")
    var mobiles: List<String> = emptyList()
}
