package xyz.jagged.gomes.pretify

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by gustavogomes on 04/02/2017.
 */

open class DateTimePretifier(val locale : Locale = Locale.getDefault())
{
    enum class DateTimeFormats(val formatingString: String)
    {
        DAY_MONTH("dd MM"),
        DAY_MONTH_YEAR("dd MMM yyyy"),
        YEAR_MONTH_DAY_SLASHED("yyyy/MM/dd"),
        YEAR_MONTH_DAY_DASHED("yyyy-MM-dd"),
        YEAR_MONTH("yyyy MM"),
        YEAR_MONTH_SLASHED("yyyy/MM"),
        SHORT_WEEK_DAY2_MONTH("E dd MMM"),
        SHORT_WEEK_MONTH("E MMM")
    }

    fun PretifyDate(milliseconds: Long, dateFormat: DateTimeFormats, locale: Locale = this.locale) : String
    {
        val dateFromMillis = this.ConvertDateFromMillis(milliseconds)
        return this.PretrifyDate(dateFromMillis, dateFormat, locale)
    }

    fun PretrifyDate(date: Date, dateFormat: DateTimeFormats, locale: Locale = this.locale) : String
    {
        val formatter = SimpleDateFormat(dateFormat.formatingString, locale)
        return formatter.format(date)
    }

    /*
     * Method to convert the Milliseconds from the Epoch into a Date Object
     */
    fun ConvertDateFromMillis(milliseconds: Long) : Date
    {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliseconds
        return calendar.time
    }

    fun main(args: Array<String>)
    {
        println("Pretifier")

        val dateNow = Date() // Fetches the current date for testing purposes.
        println("Pretifier")
        println("DAY_MONTH_YEAR " +
                this.PretrifyDate(dateNow, xyz.jagged.gomes.pretify.DateTimePretifier.DateTimeFormats.DAY_MONTH_YEAR))
        println("YEAR_MONTH_DAY_SLASHED " +
            this.PretrifyDate(dateNow, xyz.jagged.gomes.pretify.DateTimePretifier.DateTimeFormats.YEAR_MONTH_DAY_SLASHED))

        println("SHORT_WEEK_DAY2_MONTH " +
            this.PretrifyDate(dateNow, xyz.jagged.gomes.pretify.DateTimePretifier.DateTimeFormats.SHORT_WEEK_DAY2_MONTH))
    }
}