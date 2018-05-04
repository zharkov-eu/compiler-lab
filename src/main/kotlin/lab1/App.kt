package main.kotlin.lab1

import java.io.File

val sep: String = File.separator
val DEFAULT_INPUT_PATH = ".${sep}data${sep}lab1_input.txt"
val DEFAULT_OUTPUT_PATH = ".${sep}data${sep}output.txt"

fun main(args: Array<String>) {
    val inputPath = if (args.isNotEmpty()) args[0] else DEFAULT_INPUT_PATH
    val outputPath = if (args.size > 1) args[1] else DEFAULT_OUTPUT_PATH

    val inputFile = File(inputPath)
    val bufferedReader = inputFile.bufferedReader()
    val inputLines: List<String> = bufferedReader.readLines()

    val rules: MutableList<String> = ArrayList()
    val terminals: MutableList<String> = ArrayList()
    val nonTerminals: MutableList<String> = ArrayList()
    var firstGrammarSymbol = "";

    var rulesLastIndex = 0
    var terminalsLastIndex = 0
    var nonTerminalsLastIndex = 0

    for ((idx, line) in inputLines.withIndex()) {
        when (idx) {
            0 -> nonTerminalsLastIndex = line.toInt()
            in 1 .. nonTerminalsLastIndex -> nonTerminals.add(line)
            nonTerminalsLastIndex + 1 -> terminalsLastIndex = idx + line.toInt()
            in nonTerminalsLastIndex + 2 .. terminalsLastIndex -> terminals.add(line)
            terminalsLastIndex + 1 -> rulesLastIndex = idx + line.toInt()
            in terminalsLastIndex + 2 .. rulesLastIndex -> rules.add(line)
            rulesLastIndex + 1 -> firstGrammarSymbol = line
        }
    }

    val grammar = Grammar(rules, terminals, nonTerminals, firstGrammarSymbol);
    grammar.printConditions();
}
