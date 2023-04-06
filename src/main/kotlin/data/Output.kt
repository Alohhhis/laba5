package data

/**
 *объект-синглтон. Внутри этого объекта определены константы, которые могут быть использованы в других частях приложения.
 * содержаться строки(содержание) ошибок и сообщений
 */

object Output {
    const val Enter_x = "Please, enter coordinates [x] (only INTEGER):"
    const val Enter_y = "Please, enter coordinates [y] (only LONG, !>297):"
    const val Invalid_coordinates = "Invalid value. Please enter valid value for coordinates"

}