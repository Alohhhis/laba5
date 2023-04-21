package utils

import commands.*
import java.util.*

/**
 * Класс, отвечающий за управление и выполнение команд.
 */
class CommandExecutor(printer: Printer) {
    private val commandMap: MutableMap<String, Command> = mutableMapOf()

    init {
        commandMap["help"] = Help(this)
        commandMap["info"] = Info()
        commandMap["show"] = Show()
        commandMap["add"] = Add()
        commandMap["update"] = Update()
        commandMap["remove_by_id"] = RemoveById()
        commandMap["clear"] = Clear()
        commandMap["save"] = Save()
        commandMap["execute_script"] = ExecuteScript(CommandParser(this), printer)
        commandMap["exit"] = Exit()
        commandMap["remove_greater"] = RemoveGreater()
        commandMap["group_counting_by_fuel_type"] = GroupCountingByFuelType()
        commandMap["filter_greater_than_engine_power"] = FilterGreaterThanEnginePower()
        commandMap["remove_head"] = RemoveHead()
        commandMap["add_if_max"] = AddIfMax()
        commandMap["print_unique_type"] = PrintUniqueFuelType()
    }


    /**
     * Retrieves a command instance by its name.
     *
     * @param name The name of the command to retrieve.
     * @return The command instance if found, null otherwise.
     */
    fun getCommand(name: String): Command? {
        return commandMap[name.lowercase(Locale.getDefault())]
    }

    /**
     * Retrieves the available commands.
     *
     * @return A map of command names to their corresponding [Command] instances.
     */
    fun getAvailableCommands(): Map<String, Command> {
        return commandMap
    }
}
{
}