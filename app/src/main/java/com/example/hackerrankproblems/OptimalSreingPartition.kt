package com.example.hackerrankproblems
class OptimalSreingPartition {
        fun partitionString(s: String): Int {
            val seen = HashSet<Char>()
            var partitions = 0

            // Iterate through each character in the string
            for (char in s) {
                // If the character is already seen, start a new partition
                if (seen.contains(char)) {
                    seen.clear() // Clear the set for a new partition
                    partitions++ // Increment the count of partitions
                }

                // Add the current character to the set
                seen.add(char)
            }

            // Increment the count of partitions for the last set of unique characters
            if (seen.isNotEmpty()) {
                partitions++
            }

            return partitions
        }
    }