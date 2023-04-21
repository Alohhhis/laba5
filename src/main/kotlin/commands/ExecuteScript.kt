package commands

import data.Output
import org.koin.core.component.inject
import utils.CommandParser
import utils.Printer
import java.io.File
import java.io.FileNotFoundException
import java.util.*

/**
 * Класс ExecuteScript читает и выполняет команды из указанного файла.
 *
 */

/**
 *
 */
class ExecuteScript(
    private val commandParser: CommandParser,
    private val printer: Printer,
    private val nestedLevel: Int = 0

) : Command() {
    private val stack: Stack<String> by inject()

    fun copy(nestedLevel: Int): ExecuteScript {
        return ExecuteScript(commandParser, printer, nestedLevel)
    }

    /**
     *
     */
    override fun execute(args: List<Any>): String {

        val fileName = args[0] as String
        val file = File(fileName)
        if(stack.contains(fileName)) return Output.Infinity_cycle
        return try {
            if (!file.exists()) {
                throw FileNotFoundException(Output.File_not_found + fileName)
            }
            stack.add(fileName)
            val lines = file.readLines().iterator()
            while (lines.hasNext()) {
                val line = lines.next().trim()
                if (line.isNotBlank()) {
                    val commandResult = commandParser.parseAndExecute(line, nestedLevel + 1, lines::next)
                    if (commandResult != null) {
                        printer.println(commandResult)
                    }
                }
            }
            stack.remove(fileName)
            Output.Success_script_execute
        } catch (e: FileNotFoundException) {
            "Error: ${e.message}"
        }
    }

    override fun readArguments(input: () -> String): List<Any> {
        val fileName = input()
        if (fileName.isBlank()) {
            throw FileNotFoundException("There is no file name")
        }
        val file = File(fileName)
        if (!file.exists()) {
            throw FileNotFoundException(Output.File_not_found + fileName)
        }

        val fileParts = fileName.split(" ", limit = 2)
        if (fileParts.size > 1) {
            throw IllegalArgumentException("Unexpected argument after the file name: '${fileParts[1]}'")
        }

        return listOf(fileName)
    }

}
