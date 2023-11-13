//Создать приложение, в котором пользователь вводит массив из различных слов.
//На выходе приложение должно показать слова сгруппированные по признаку
//"состоят из одинаковых букв". Например, на входе ["eat", "tea", "tan", "ate", "nat", "bat"].
// Получаем группы:
//"ate", "eat", "tea"
//"nat", "tan"
//"bat"

fun main() {
println("Введите слова, разделенные пробелами:")
val input = readLine()
val words = input?.split(" ")// разбитие строки на отдельные слова с пробелами
if (words != null) {
val wordGroups = groupWords(words)

for ((_, group) in wordGroups) { //_ -это пустое значение, т.к. ключ нам не нужен, нужно только значение
println(group.joinToString(", "))
}
}
}
fun groupWords(words: List): Map> {
val wordGroups = mutableMapOf>()
for (word in words) {
val key = word.toCharArray().sorted().joinToString("")
if (!wordGroups.containsKey(key)) {
wordGroups[key] = mutableListOf()
}
wordGroups[key]?.add(word)
}

return wordGroups
}
