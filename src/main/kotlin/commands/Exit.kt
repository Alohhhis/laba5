package commands

import kotlin.system.exitProcess

class Exit : Command(){
    override fun execute(args: List<Any>): String {
        exitProcess(0)
    }

    override fun readArguments(input: () -> String): List<Any> {
        return emptyList()
    }
}