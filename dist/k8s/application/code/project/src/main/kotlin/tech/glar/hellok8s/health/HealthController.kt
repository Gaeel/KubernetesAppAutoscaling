package tech.glar.hellok8s.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthController {

    @GetMapping("/health")
    fun health(): HealthData {
        return HealthData("up")
    }
}


