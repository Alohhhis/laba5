package utils

import commands.Command
import exeptions.CommandException


/**
 * Класс, отвечающий за разбор и выполнение команд.
 */
class CommandParser(private val commandExecutor: CommandExecutor) {

    fun parseAndExecute(commandLine: String, nestedLevel: Int = 0, input: (() -> String)? = null): String? {
        val commandParts = commandLine.split(" ", limit = 2)
        val commandName = commandParts[0]

        val command = commandExecutor.getCommand(commandName)
            ?: throw CommandException("Unknown command: $commandName")

        if (command is commands.ExecuteScript && commandParts.size == 1) {
            return "There is no file name"
        }

        val initialArg = commandParts.getOrElse(1) { "" }
        val args = readArguments(command, input, initialArg)
        return when {
            command is commands.ExecuteScript  -> {
                command.copy(nestedLevel = nestedLevel).execute(args)
            }
            commandLine.isNotBlank() -> {
                command.execute(args)
            }
            else -> null // Return null if the input is empty (ignores empty lines)
        }
    }

    private fun readArguments(command: Command, input: (() -> String)?, initialArg: String = ""): List<Any> {
        return when (command) {
            is commands.Add, is commands.AddIfMax, is commands.RemoveGreater -> {
                command.readArguments(input ?: { readlnOrNull() ?: "" })
            }
            is commands.Update, is commands.FilterGreaterThanEnginePower -> {
                command.readArguments { if (initialArg.isBlank()) input?.invoke() ?: "" else initialArg }
            }
            else -> {
                command.readArguments { if (initialArg.isBlank()) input?.invoke() ?: "" else initialArg }
            }
        }
    }


}
