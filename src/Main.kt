import java.io.File
import java.nio.file.Files
import java.nio.file.Path


fun main() {
    val shift = 3
    val file = Files.readString(Path.of("file"))
    val file2 = Files.readString(Path.of("outfile"))

    val lines = file.lines()
    val lines2 = file2.lines()
    val shiftedList = mutableListOf<String>()

    while (true) {
        println("1. Encrypt" +
                "\n2. Decrypt" +
                "\n3. Exit")
        val option = readln().toInt();
        when (option) {
            1 -> {
                for (line in lines) {
                    var words = "";
                    for (char in line) {
                        val shiftedChar = (char + shift).toChar()
                        words += shiftedChar
                    }
                    shiftedList.add(words)
                    println(shiftedList)
                    println()
                }
                File("outfile").writeText(shiftedList.joinToString("\n"))
            }
            2 -> {
                for (line in lines2) {
                    var words = "";
                    for (char in line) {
                        val shiftedChar = (char - shift).toChar()
                        words += shiftedChar
                    }
                    shiftedList.add(words)
                }
                println(shiftedList)
                println()
            }
            else -> {
                println("Exiting...")
                return
            }
        }

        }
}