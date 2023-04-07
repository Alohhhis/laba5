package utils

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.io.File
import java.nio.charset.StandardCharsets
import com.google.gson.Gson

/**

*/
class FileManager {


    // Записывает JSON-строку в файл на пути path
    fun writeJsonToFile(path: String, json: String) {
        val file = File(path)
        if (!file.exists()) {
            file.createNewFile()
        }
        file.writeText(json, StandardCharsets.UTF_8)
    }

    // Читает JSON-строку из файла на пути path и конвертирует ее в объект типа T
    fun readJsonFromFile(path: String): T {
        val file = File(path)
        if (!file.exists()) {
            throw FileException("Не получается открыть файл")
        }
        val json = file.readText(StandardCharsets.UTF_8)
        return Gson().fromJson(json, T::class.java)
    }
    /**
    path предоставляет путь к файлу
     */
    }