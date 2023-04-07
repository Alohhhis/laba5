package utils

import utils.ReaderWriter

/**
 * ConsoleManager реализует ReaderWriter,
 * который представляет писателя (Writer) и читателя (Reader) потоков данных.
 * предоставляет методы чтения и записи данных в консоль
 * При вызове метода getValidatedValue(message, validator) передается сообщение message,
 * которое выводится на консоль для запроса ввода от пользователя.
 */
class ConsoleManager : ReaderWriter {
    override fun readLine(): String = readLine()!!
    override fun writeLine(text: String) = println(text)
    override fun write(text: String) = print(text)

    override fun getValidatedValue(message: String, validator: (String) -> Boolean): String {
        write(message)
        while (true){
            val userInput = readLine()!!
            if (validator(userInput)){
                return userInput
            }

            write("Попробуйте ещё раз: ")
        }
    }
}