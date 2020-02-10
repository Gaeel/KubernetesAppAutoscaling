package tech.glar.hellok8s.logs

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class LogServiceImpl : LogService{

    @Autowired
    lateinit var logRepository: LogRepository

    override fun saveOrUpdate(log: LogData){
        logRepository.save(log)
    }

    override fun getRequestCount(timeStamp: Date): Long{
        return logRepository.countLogDataByTimestampAfter(timeStamp)
    }

}