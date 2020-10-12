package ru.pdn.sfedu.operationshistory

import java.text.SimpleDateFormat
import java.util.*
import javax.xml.bind.annotation.adapters.XmlAdapter

class DateAdapter: XmlAdapter<String?, Date?>() {
    private val dtFormat = "dd.MM.yyyy"

    override fun unmarshal(value: String?): Date? {
        if (value == null)
            return null
        return SimpleDateFormat(dtFormat).parse(value)
    }

    override fun marshal(value: Date?): String? {
        if (value == null)
            return null
        return SimpleDateFormat(dtFormat).format(value)
    }
}