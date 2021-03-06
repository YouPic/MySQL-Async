package com.rimmer.mysql.dsl

abstract class Expression {
    abstract fun format(builder: QueryBuilder)

    override fun equals(other: Any?) = (other as? Expression)?.toString() == toString()
    override fun hashCode() = toString().hashCode()

    override fun toString(): String {
        val b = QueryBuilder()
        format(b)
        return b.toString()
    }
}

class CustomExpression(val content: String) : Expression() {
    override fun format(builder: QueryBuilder) {
        builder.append(content)
    }
}

abstract class TypedExpression<T>(val type: Class<T>, val nullable: Boolean) : Expression()