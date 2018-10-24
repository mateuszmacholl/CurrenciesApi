package mateuszmacholl.currenciesApi.validation

import java.text.SimpleDateFormat
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext




class CorrectDateFormatValidator : ConstraintValidator<CorrectDateFormat, String> {
    override fun initialize(constraint: CorrectDateFormat) {}

    override fun isValid(date: String, context: ConstraintValidatorContext): Boolean {
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        try {
            val formattedDate = formatter.parse(date)
            if (date != formatter.format(formattedDate)) {
                return false
            }
        } catch (ex: Exception) {
            return false
        }
        return true
    }

}
