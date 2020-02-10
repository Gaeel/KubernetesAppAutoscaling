package tech.glar.hellok8s.logs

import java.util.*

interface LogService {

    fun saveOrUpdate(log: LogData)
    fun getRequestCount(timeStamp: Date): Long

}