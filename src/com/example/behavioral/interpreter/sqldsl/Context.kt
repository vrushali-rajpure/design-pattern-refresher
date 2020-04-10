package com.example.behavioral.interpreter.sqldsl


class Context {
    private val matchAnyString: (String) -> Boolean = { it.isNotEmpty() }
    private val matchAllColumns: (String) -> List<String> = { listOf(it) }

    var column: String = ""
        set(value) {
            field = value
            createColumnMapper(value)
        }


    lateinit var table: String
    var filter: (String) -> Boolean = matchAnyString
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
        return tables
            .filter { it.key.contentEquals(table) }
            .flatMap { it.value }
            .map { it.toString() }
            .flatMap(columnMapper)
            .filter(filter)
    }

    fun clear() {
        column = ""
        columnMapper = matchAllColumns
        filter = matchAnyString
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