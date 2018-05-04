package main.kotlin.lab1

class Grammar(private val rules: List<String>,
              private val terminals: List<String>,
              private val nonTerminals: List<String>,
              private val firstGrammarSymbol: String) {

    fun printConditions() {
        println("Правила (${rules.count()}):")
        rules.listIterator().forEach { println("  $it") }
        println("Терминалы (${terminals.count()}):")
        terminals.listIterator().forEach { println("  $it") }
        println("Нетерминалы (${nonTerminals.count()}):")
        nonTerminals.listIterator().forEach { println("  $it") }
        println("Первый элемент: $firstGrammarSymbol")
    }
}