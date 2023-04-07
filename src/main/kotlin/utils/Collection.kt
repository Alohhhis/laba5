package utils
import com.google.gson.Gson
import java.io.File
import java.nio.charset.Charset
import java.util.*
class Collection {

    // Класс для парсинга JSON-файла
    data class Item(val name: String, val value: Int)

    fun main() {
        val queue = PriorityQueue<Int>()

        val file = File("values.json")
        if (file.exists() && file.isFile) {
            val json = file.readText(Charset.defaultCharset())
            val items = Gson().fromJson(json, Array<Item>::class.java)

            items.forEach {
                queue.offer(it.value)
            }
        } else {
            println("Файл values.json не найден!")
        }

        println("Элементы PriorityQueue:")
        while (queue.isNotEmpty()) {
            println(queue.poll())
        }
    }
}