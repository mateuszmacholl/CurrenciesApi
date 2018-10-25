package mateuszmacholl.currenciesApi.validation.correctDateFormat

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.FIELD, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CorrectDateFormatValidator::class])
annotation class CorrectDateFormat(
        val message: String = "Wrong format, should be yyyy-MM-dd",
        val groups: Array<KClass<*>> = [],
        val payload: Array<KClass<out Payload>> = []
)