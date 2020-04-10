package com.example.behavioral.interpreter.sqldsl


class Context {
    private val matchAnyString: (String) -> Boolean = { str -> str.isNotEmpty() }
    private val matchAllColumns: (String) -> List<String> = { str -> str.split(" ") }

    var column: String = ""
        set(value) {
            field = value
            createColumnMapper(value)
        }

    lateinit var filter: (String) -> Boolean

    lateinit var table: String
    private var whereFilter: (String) -> Boolean = matchAnyString
    private var columnMapper: (String) -> List<String> = matchAllColumns

    companion object {
        private val tables = LinkedHashMap<String, List<Row>>()

        init {
            tables["people"] = listOf(
                Row("John", "Doe"),
                Row("Jan", "Kowalski"),
                Row("Dominic", "Doom")
            )
        }
    }


    fun search(): List<String> {
        val filter1 = tables
            .filter { (key, _) -> key.contentEquals(table) }
        val flatMap = filter1
            .flatMap { (_, value) -> value }
        val map = flatMap
            .map { row: Row -> row.toString() }
        val flatMap1 = map
            .flatMap(columnMapper)
        val filter2 = flatMap1
            .filter(whereFilter)
        val result = filter2
        clear()
        return result

    }

    fun clear() {
        column = ""
        columnMapper = matchAllColumns
        whereFilter = matchAnyString
    }

    private fun createColumnMapper(column: String) {

        val columnIndex = when (column) {
            "*" -> -1
            "name" -> 0
            "surname" -> 1
            else -> throw IllegalArgumentException()
        }

        if (columnIndex != -1) {
            columnMapper = { rowColumns -> listOf(rowColumns.split(" ")[columnIndex]) }
        }
    }

}