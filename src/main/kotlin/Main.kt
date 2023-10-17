import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Введите слова через пробел:")
    val input = scanner.nextLine()

    val words = input.split(" ").toTypedArray()

    val wordGroups = groupAnagrams(words)

    for (group in wordGroups) {
        println(group.joinToString(", "))
    }
}

fun groupAnagrams(words: Array<String>): List<List<String>> {
    val wordGroups = ArrayList<List<String>>()

    val groupedWords = HashMap<String, ArrayList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().toString()
        if (!groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord] = ArrayList()
        }
        groupedWords[sortedWord]?.add(word)
    }

    for (entry in groupedWords.entries) {
        wordGroups.add(entry.value)
    }

    return wordGroups
}