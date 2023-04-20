package commands

import com.sun.jdi.connect.Connector.Argument
import utils.ArgumentType
import utils.CommandResulter
import javax.xml.validation.Validator

/**
 * Абстрактный класс, определяющий команды.
 */
//TODO IMPORT KOIN, для KoinComponent,
// который позволяет использовать инъекцию зависимостей с помощью библиотеки Koin.
abstract class Command: KoinComponent {
    /**
     * Возвращает описание команды.
     */
    val validator: Validator by inject()
    val VehicleCollection: VehicleCollection by inject()

    /**
     * Запускает выполнение команды
     * и возвращает объект CommandResult
     * с именем команды и данными или исключением, возращенными выполнением команды.
     */
    //TODO Класс результата выполнения комманды(успешное/ошибка)
    abstract fun execute(args: List<Any>): String
    /**
     * определение типов аргументов, передаваемых в функцию,
     * чтобы обеспечить корректное их использование
     * и обработку внутри функции
     */
    abstract fun readArguments(input: () -> String): List<Any>
}