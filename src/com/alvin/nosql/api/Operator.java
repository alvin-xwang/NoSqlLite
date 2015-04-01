package com.alvin.nosql.api;

import java.util.Date;

public abstract class Operator {

	public abstract boolean eval(Object v1, Object v2);

	public static Operator EQUAL = new Operator() {

		@Override
		public boolean eval(Object v1, Object v2) {
			if (v1 != null && v2 != null) {
				if (v1.equals(v2)) {
					return true;
				}
			}
			return false;
		}
	};

	public static Operator NOT_EQUAL = new Operator() {

		@Override
		public boolean eval(Object v1, Object v2) {
			if (v1 != null && v2 != null) {
				if (!v1.equals(v2)) {
					return true;
				}
			}
			return false;
		}
	};

	public static Operator GREAT_THAN = new Operator() {

		@Override
		public boolean eval(Object v1, Object v2) {
			boolean flag = false;
			if (v1 != null && v2 != null) {
				if (v1.getClass().equals(v2.getClass())) {
					if (v1 instanceof Date) {
						flag = ((Date) v1).after((Date)v2);
					} else if (v1 instanceof Number) {
						flag = (((Number)v1).doubleValue() > ((Number)v2).doubleValue());
					} else if (v1 instanceof String) {
						flag = ((String)v1).compareTo((String)v2) > 0;
					}
				}
			}
			return flag;
		}
	};

	public static Operator LESS_THAN = new Operator() {

		@Override
		public boolean eval(Object v1, Object v2) {
			boolean flag = false;
			if (v1 != null && v2 != null) {
				if (v1.getClass().equals(v2.getClass())) {
					if (v1 instanceof Date) {
						flag = ((Date) v1).before((Date)v2);
					} else if (v1 instanceof Number) {
						flag = (((Number)v1).doubleValue() < ((Number)v2).doubleValue());
					} else if (v1 instanceof String) {
						flag = ((String)v1).compareTo((String)v2) < 0;
					}
				}
			}
			return flag;
		}
	};
}
