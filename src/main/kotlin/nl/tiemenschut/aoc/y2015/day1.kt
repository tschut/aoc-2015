package nl.tiemenschut.aoc.y2015

import nl.tiemenschut.aoc.lib.dsl.aoc
import nl.tiemenschut.aoc.lib.dsl.day
import nl.tiemenschut.aoc.lib.dsl.parser.AsCharSequence

fun main() {
    aoc(AsCharSequence) {
        puzzle { 2015 day 1 }

        part1 { input ->
            input.fold(0) { acc, c -> if (c == '(') acc + 1 else acc - 1 }
        }

        part2 { input ->
            var floor = 0
            input.forEachIndexed { index, c ->
                when (c) {
                    '(' -> floor++
                    else -> floor--
                }
                if (floor < 0) return@part2 "${index + 1}"
            }
            throw Exception()
        }
    }
}


