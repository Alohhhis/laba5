import org.koin.core.context.startKoin
import org.koin.dsl.module
import utils.Validator
import utils.VehicleCollection
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

}