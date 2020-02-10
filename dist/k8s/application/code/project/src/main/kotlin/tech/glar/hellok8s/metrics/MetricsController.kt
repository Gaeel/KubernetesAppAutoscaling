package tech.glar.hellok8s.metrics

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.glar.hellok8s.logs.LogService
import java.util.Calendar


@RestController
class MetricsController {

    @Autowired
    lateinit var logService: LogService

    // default value is set, but declared value in application.properties is injected
    @Value("\${metrics.averagingperiod}")
    val averagingPeriod: Double = 60.0

    @GetMapping("/metrics", produces = ["text/plain"])
    fun metrics(): String {

        val calendar = Calendar.getInstance()
        calendar.add(Calendar.SECOND, - averagingPeriod.toInt() )
        val startTime = calendar.time

        val rate = logService.getRequestCount(startTime).div(averagingPeriod)
        return """#
            |request_per_second $rate
            |averaging_period $averagingPeriod
            |#
        """.trimMargin()
    }
}