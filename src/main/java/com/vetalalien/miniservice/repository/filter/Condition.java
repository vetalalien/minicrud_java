package com.vetalalien.miniservice.repository.filter;


/**
 *  Условия, по которым делается выборка сущностей в фильтре
 *  type - тип данных
 *  operation - SQL операция
 *  value - значение поля
 *  field - название поля
 *  conditionTarget - тип поля (внутренний, внешний)
 *  conditionClass - класс, содержащий внешнее поле
 */
public class Condition {

    private Type type;

    private ConditionOperation operation;

    private String value;

    private String field;

    private ConditionTarget conditionTarget;

    private String conditionClass;

    private ConditionRelation conditionRelation;

    public Condition() {
    }

    public Condition(Type type, ConditionOperation operation, String value, String field,
                     ConditionTarget conditionTarget, String conditionClass) {
        this.type = type;
        this.operation = operation;
        this.value = value;
        this.field = field;
        this.conditionTarget = conditionTarget;
        this.conditionClass = conditionClass;
    }

    public Condition(ConditionOperation operation, String value, String field,
                     ConditionTarget conditionTarget, String conditionClass) {
        this.operation = operation;
        this.value = value;
        this.field = field;
        this.conditionTarget = conditionTarget;
        this.conditionClass = conditionClass;
    }

    public Condition(ConditionOperation operation, String value, String field,
                     ConditionTarget conditionTarget) {
        this.operation = operation;
        this.value = value;
        this.field = field;
        this.conditionTarget = conditionTarget;
    }

    public Condition(ConditionOperation operation, String field,
                     ConditionTarget conditionTarget, String conditionClass) {
        this.operation = operation;
        this.field = field;
        this.conditionTarget = conditionTarget;
        this.conditionClass = conditionClass;
    }

    public static class Builder {
        private Type type;
        private ConditionOperation operation;
        private String value;
        private String field;
        private ConditionTarget conditionTarget;
        private String conditionClass;
        private ConditionRelation conditionRelation;

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setOperation(ConditionOperation operation) {
            this.operation = operation;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setField(String field) {
            this.field = field;
            return this;
        }

        public Builder setConditionTarget(ConditionTarget conditionTarget){
            this.conditionTarget = conditionTarget;
            return this;
        }

        public Builder setConditionClass(String conditionClass) {
            this.conditionClass = conditionClass;
            return this;
        }

        public Builder setConditionRelation(ConditionRelation conditionRelation) {
            this.conditionRelation = conditionRelation;
            return this;
        }

        public Condition build() {
            return new Condition(type, operation, value, field, conditionTarget, conditionClass);
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ConditionOperation getOperation() {
        return operation;
    }

    public void setOperation(ConditionOperation operation) {
        this.operation = operation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public ConditionTarget getConditionTarget() {
        return conditionTarget;
    }

    public void setConditionTarget(ConditionTarget conditionTarget) {
        this.conditionTarget = conditionTarget;
    }

    public String getConditionClass() {
        return conditionClass;
    }

    public void setConditionClass(String conditionClass) {
        this.conditionClass = conditionClass;
    }

    public ConditionRelation getConditionRelation() {
        return conditionRelation;
    }

    public void setConditionRelation(ConditionRelation conditionRelation) {
        this.conditionRelation = conditionRelation;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "type=" + type +
                ", operation=" + operation +
                ", value='" + value + '\'' +
                ", field='" + field + '\'' +
                ", conditionTarget=" + conditionTarget +
                ", conditionClass='" + conditionClass + '\'' +
                ", conditionRelation=" + conditionRelation +
                '}';
    }
}
