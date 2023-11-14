//"eat", "tea", "tan", "ate", "nat", "bat"
//"ate", "eat", "tea"
//"nat", "tan"
//"bat"

fun main() {
    val input = readLine()!!.split(" ").toTypedArray()
    val groups = groupAnagrams(input)
    for (group in groups) {
        println(group.joinToString(", "))
    }
}

fun groupAnagrams(words: Array<String>): List<List<String>> {
    val groups = mutableListOf<List<String>>()
    val map = mutableMapOf<String, MutableList<String>>()
    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (map.containsKey(sortedWord)) {
            map[sortedWord]?.add(word)
        } else {
            map[sortedWord] = mutableListOf(word)
        }
    }
    for (entry in map) {
        groups.add(entry.value)
    }
    return groups
}
