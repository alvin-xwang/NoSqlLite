package com.alvin.nosql.api;

/**
 * Filter condition which wraps <code>Operator</code> and provide eval method to compare value.
 *
 * @param <T> the generic type for comparable object.
 */
public class Condition<T> {

	private T value;
	private Operator operator;

	public Condition(T value, Operator operator) {
		this.value = value;
		this.operator = operator;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public boolean eval(T v2) {
		return operator.eval(this, v2);
	}
}
