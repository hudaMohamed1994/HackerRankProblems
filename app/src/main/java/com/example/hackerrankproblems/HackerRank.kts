class HackerRaank {


    fun sortString(str: String): String {
        return str.toCharArray().sorted().joinToString("")
    }


    fun isAnagram(str1: String, str2: String): Boolean {
        // If the lengths of the strings are different, they cannot be anagrams
        if (str1.length != str2.length) {
            return false
        }

        // Create mutable maps to store character frequencies for both strings
        val charFreqMap1 = mutableMapOf<Char, Int>()
        val charFreqMap2 = mutableMapOf<Char, Int>()

        for (char in str1) {
            charFreqMap1[char] = charFreqMap1.getOrDefault(char, 0) + 1
        }

        // Update character frequencies for the second string
        for (char in str2) {
            charFreqMap2[char] = charFreqMap2.getOrDefault(char, 0) + 1
        }

        // Check if both maps are equal
        return charFreqMap1 == charFreqMap2
    }
    fun stringAnagram(dictionary: Array<String>, query: Array<String>): Array<Int> {
        val anagramCountMap = HashMap<String, Int>()

        val sortedDictMap = dictionary.groupBy { sortString(it) }

        // Count anagrams for each query
        for (queryStr in query) {
            val sortedQuery = sortString(queryStr)
            val count = sortedDictMap[sortedQuery]?.size ?: 0
            anagramCountMap[queryStr] = count
        }

        return query.map { anagramCountMap[it] ?: 0 }.toTypedArray()
    }

    fun main(args: Array<String>) {
        val dictionaryCount = readLine()!!.trim().toInt()

        val dictionary = Array<String>(dictionaryCount, { "" })
        for (i in 0 until dictionaryCount) {
            val dictionaryItem = readLine()!!
            dictionary[i] = dictionaryItem
        }

        val queryCount = readLine()!!.trim().toInt()

        val query = Array<String>(queryCount, { "" })
        for (i in 0 until queryCount) {
            val queryItem = readLine()!!
            query[i] = queryItem
        }

        val result = stringAnagram(dictionary, query)

        println(result.joinToString("\n"))
    }
}

