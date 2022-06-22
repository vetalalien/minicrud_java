package com.vetalalien.miniservice.repository.filter;


/**
 *   Перечисление, описывающее поле, по которому нужно фильтровать сущности.
 *   SAME_ENTITY - поле присутствует в данной сущности
 *   ONE_TO_ONE_ENTITY - поле отсутствует у данной сущности (делается JOIN)
 *   UNDEFINED неопределенное поле, будет пропущено
 */
public enum ConditionTarget {
    SAME_ENTITY,
    ONE_TO_ONE_ENTITY,
    ONE_TO_MANY_ELEMENT_COLLECTION_ENTITY,
    UNDEFINED
}

