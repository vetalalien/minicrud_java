package com.vetalalien.miniservice.repository.filter;


/**
 * Операции производимые лдя фильтрации сущностей
 * EQUAL - равно
 * GREATER_THAN - больше чем
 * NOT_EQUALS - не равно
 * LESS_THEN - меньше чем
 *
 * LIKE - сравнение по паттерну
 * IN - операция по множественным значением одного поля ( SELECT * FROM table WHERE field IN(*) )
 */
public enum ConditionOperation {
    EQUAL,
    NOT_EQUALS,
    LESS_THAN,
    LESS_THAN_OR_EQUAL,
    GREATER_THAN_OR_EQUAL,
    GREATER_THAN,
    SORT,
    GROUP_BY,
    LIKE,
    IN,
    DISTINCT,
    IS_NULL,
    NON_NULL
}

