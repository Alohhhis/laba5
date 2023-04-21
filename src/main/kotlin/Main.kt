import data.Output
import exeptions.CommandException
import org.koin.core.context.startKoin
import org.koin.dsl.module
import utils.*
import java.io.FileNotFoundException
import java.util.*

fun main() {
    val koinModule = module {
        single { Stack<String>() }
        single { Validator() }
        single {
            val scanner = Scanner(System.`in`)
            print("Enter the file name: ")
            val fileName = scanner.nextLine()
            VehicleCollection.fromFile(fileName)
        }
    }
    startKoin {
        modules(koinModule)
    }
    val printer = ConsolePrinter()
    val commandExecutor = CommandExecutor(printer)
    val commandParser = CommandParser(commandExecutor)

    printer.println(Output.Welcome)
//    printer.println(Output.File_Path)
//    val fileName = readln()
    printer.println(Output.Enter_help)
//    val fileName = readln() ?: "VehicleCollection.json"

    while (true) {
        printer.print("> ")
        val commandLine = readlnOrNull() ?: break

        try {
            val commandResult = commandParser.parseAndExecute(commandLine)
            commandResult?.let { printer.println(it) }
        } catch (e: CommandException) {
            e.message?.let { printer.println(it) }
        } catch (e: FileNotFoundException) {
            e.message?.let { printer.println(it) }
        } catch (e: IllegalArgumentException) {
            e.message?.let { printer.println(it) }
        }
    }

}