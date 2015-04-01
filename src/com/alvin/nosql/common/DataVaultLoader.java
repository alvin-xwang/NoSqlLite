package com.alvin.nosql.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataVaultLoader {

	private static final String PROP_VAULT_PATH = "DataVault.dir";
	private static final String vaultDir = System.getProperty(PROP_VAULT_PATH);
	
	private static Object locker = new Object();

	static {
		if (vaultDir == null) {
			throw new RuntimeException("Property -D" + PROP_VAULT_PATH +" is required!");
		}
	}

	public static DataVault loadDataVault(String vaultName) throws Exception {
		DataVault dataVault = DataVault.NULL;
		String vaultPath = vaultDir.concat(File.separator).concat(vaultName);
		if (!new File(vaultPath).exists()) {
			return dataVault;
		}

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(vaultPath));
			Object object = ois.readObject();

			if (object instanceof DataVault) {
				dataVault = (DataVault)object;
			}
		} catch (IOException e) {
			throw new Exception("Failed to load data vault due to " + e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			throw new Exception("Failed to load data vault due to " + e.getMessage(), e);
		} finally {
			if (ois != null) {
				ois.close();
			}
		}
		return dataVault;
	}

	public static void saveDataVault(String vaultName, DataVault dataVault) throws Exception {
		synchronized(locker) {
			String vaultPath = vaultDir.concat(File.separator).concat(vaultName);
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(vaultPath));
				oos.writeObject(dataVault);
				oos.flush();
			} catch (IOException e) {
				throw new Exception("Failed to save data vaule due to " + e.getMessage(), e);
			} finally {
				if (oos != null) {
					oos.close();
				}
			}
		}
	}
}
