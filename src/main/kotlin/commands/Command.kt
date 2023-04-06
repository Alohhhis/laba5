package commands

import com.sun.jdi.connect.Connector.Argument
import utils.ArgumentType
import utils.CommandResulter

/**
 * Абстрактный класс, опрежеляющий команды.
 */
//TODO IMPORT KOIN, для KoinComponent,
// который позволяет использовать инъекцию зависимостей с помощью библиотеки Koin.
abstract class Command {
    /**
     * Возвращает описание команды.
     */
    abstract fun getDescription(): String//далее оверрайдить метод для каждой команды

    /**
     * Запускает выполнение команды
     * и возвращает объект CommandResult
     * с именем команды и данными или исключением, возращенными выполнением команды.
     */
    //TODO Класс результата выполнения комманды(успешное/ошибка)
    abstract fun execute(args: ArrayList<Any>): CommandResulter

    /**
     * определение типов аргументов, передаваемых в функцию,
     * чтобы обеспечить корректное их использование
     * и обработку внутри функции
     */
    abstract fun getArgumentType(): Array<ArgumentType>
}