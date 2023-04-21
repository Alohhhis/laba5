package commands

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import utils.VehicleCollection
import javax.xml.validation.Validator

/**
 * Абстрактный класс, определяющий команды.
 */
//TODO IMPORT KOIN, для KoinComponent,
// который позволяет использовать инъекцию зависимостей с помощью библиотеки Koin.
abstract class Command: KoinComponent {
    val validator: Validator by inject()
    val VehicleCollection: VehicleCollection by inject()

    /**
     * Запускает выполнение команды
     * и возвращает объект CommandResult
     * с именем команды и данными или исключением, возращенными выполнением команды.
     */

    abstract fun execute(args: List<Any>): String
    /**
     * определение типов аргументов, передаваемых в функцию,
     * чтобы обеспечить корректное их использование
     * и обработку внутри функции
     */
    abstract fun readArguments(input: () -> String): List<Any>
}