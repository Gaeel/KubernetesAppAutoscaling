package tech.glar.hellok8s.info

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.glar.hellok8s.logs.LogData
import tech.glar.hellok8s.logs.LogService
import tech.glar.hellok8s.logs.LogServiceImpl
import java.net.InetAddress
import java.util.Random


@RestController
class InfoController {

    @Autowired
    lateinit var logService: LogService

    val address: InetAddress = InetAddress.getLocalHost()
    val random =  Random()

    @GetMapping("/info")
    fun info(): InfoData {

        val latency = (random.nextFloat() * 10).toLong()
        Thread.sleep(latency)

        val log = LogData(endpoint = "/info", code = 200, respTime = latency)
        logService.saveOrUpdate(log)

        return InfoData(address.hostName, latency)

    }

}