package tech.glar.hellok8s.logs

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LogRepository : CrudRepository<LogData, Long> {

    fun countLogDataByTimestampAfter(timestamp: Date): Long

}
