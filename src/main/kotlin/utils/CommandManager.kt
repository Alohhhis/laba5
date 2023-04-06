package utils

import exceptions.CommandException
import commands.*


//TODO подключить koin (да и ваще с ним разобраться)
/**
 * Класс содержит карту (map) всех доступных команд, где ключом является название команды в виде строки, а значением является объект класса-команды.
 */
//при добавлении элемента "help" to Help() в commands, мы создаем запись в Map, где "help" - это ключ, а Help() - это значение.
// При обращении к commands["help"] мы получим объект класса Help(), который представляет соответствующую команду.
class CommandManager() /*: KoinComponent*/ {
    val commands = mapOf<String, Command>(//хранит команды, которые существуют и вызывает их
        "help" to Help(),
        "info" to Info(),
        "add" to Add(),
        "add_if_max" to AddIfMax(),
        "clear" to Clear(),
        "execute_script" to ExecuteScript(),
        "exit" to Exit(),
        "filter_greater_than_engine_power" to FilterGreaterThanEnginePower(),
        "group_couting_by_fuel_type" to GroupCountingByFuelType(),
        "print_uniqueuel_type" to PrintUniqueuelType(),
        "remove_by_id" to RemoveById(),
        "remove_greater" to RemoveGreater(),
        "remove_head" to RemoveHead(),
        "save" to Save(),
        "show" to Show(),
        "update" to Update()
    )

    /**
     * принимает на вход строковое название команды и возвращает объект соответствующей команды.
     * Если команда не существует в заранее определенном списке,
     * метод выбрасывает исключение CommandException с сообщением "Данной команды не существует".
     */
    fun getCommand(name: String): Command {
        return commands[name] ?: throw CommandException("Данной команды не существует")
    }
}