package com.alvin.nosql;

import com.alvin.nosql.common.DataVault;
import com.alvin.nosql.common.DataVaultException;
import com.alvin.nosql.common.DataVaultLoader;

public class NoSqlDbConnection {
	private DataVault vault = null;
	private String vaultName = null;

	private NoSqlDbConnection() {
		
	}

	public static NoSqlDbConnection getNewConnection() {
		return new NoSqlDbConnection();
	}

	public void open(String vaultName) throws DataVaultException {
		try {
			this.vaultName = vaultName;
			vault = DataVaultLoader.loadDataVault(vaultName);
		} catch (Exception e) {
			throw new DataVaultException("Unable to open DataVault for name= " + vaultName
					+ " due to " + e.getMessage(), e);
		}
	}

	public void close() throws DataVaultException {
		if (vault != null) {
			try {
				DataVaultLoader.saveDataVault(vaultName, vault);
			} catch (Exception e) {
				throw new DataVaultException("Unable to close DataVault for name= " + vaultName
						+ " due to " + e.getMessage(), e);
			}
		}
	}

	public DataVault getDataVault() {
		return vault;
	}
}
