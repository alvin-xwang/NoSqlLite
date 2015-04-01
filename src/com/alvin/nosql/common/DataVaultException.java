package com.alvin.nosql.common;

public class DataVaultException extends Exception {

	public DataVaultException(String m) {
		super(m);
	}
	public DataVaultException(String m, Throwable t) {
		super(m, t);
	}
}
