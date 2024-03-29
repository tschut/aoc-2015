package nl.tiemenschut.aoc.y2015

import nl.tiemenschut.aoc.lib.dsl.aoc
import nl.tiemenschut.aoc.lib.dsl.day
import nl.tiemenschut.aoc.lib.dsl.parser.AsListOfStrings

fun main() {
    aoc(AsListOfStrings) {
        puzzle { 2015 day 5 }

        val vowels = listOf('a', 'e', 'o', 'i', 'u')
        val illegals = listOf("ab", "cd", "pq", "xy")
        fun Char.isVowel() = this in vowels

        part1 { input ->
            fun String.isNice(): Boolean {
                var vowelCount = 0
                var hasRepeatingPattern = false

                this.windowedSequence(2, 1, partialWindows = true).forEach { window ->
                    if (window in illegals) return false
                    if (!hasRepeatingPattern && window.length == 2 && window[0] == window[1]) hasRepeatingPattern = true
                    if (window.first().isVowel()) vowelCount++
                }

                return vowelCount >= 3 && hasRepeatingPattern
            }

            input.count { it.isNice() }
        }

        part2 { input ->
            fun String.isNice(): Boolean {
                var condition1 = false
                for (i in 0 until this.length - 1) {
                    val pair = "${this[i]}${this[i+1]}"
                    if (pair in this.substring(i + 2)) {
                        condition1 = true
                        break
                    }
                }

                val condition2 = this.windowedSequence(3, 1).any { it[0] == it[2] }

                return condition1 && condition2
            }

            input.count { it.isNice() }
        }
    }
}