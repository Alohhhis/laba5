package exceptions

//Вызыввается если команда не обнаружена
class CommandException(message: String?) : Throwable(message)