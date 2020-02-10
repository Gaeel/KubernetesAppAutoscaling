package tech.glar.hellok8s.logs

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*


@Entity
data class LogData (

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long = 0,

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private val timestamp: Date = Date(),

    @Column(nullable = false)
    private val endpoint: String,

    @Column(nullable = false)
    private val code: Int,

    @Column(nullable = false)
    private val respTime: Long

)