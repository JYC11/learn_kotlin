import java.io.File
import java.io.InputStream

fun readInput(fileName: String): String {
    val inputStream: InputStream = File("src/data/$fileName.txt").inputStream()
    return inputStream.bufferedReader().use { it.readText() }
}
