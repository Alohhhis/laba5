package utils

/**
 * Реализация принтера, выводящего вывод на консоль с префиксом "[CONSOLE]: ".
 *
 */
class ConsolePrinter : Printer {
    override fun print(message: String) {
        kotlin.io.print("[CONSOLE]: $message")
    }

    override fun println(message: String) {
        kotlin.io.println("[CONSOLE]: $message")
    }
}
