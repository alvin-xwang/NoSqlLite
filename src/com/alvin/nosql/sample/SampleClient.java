package com.alvin.nosql.sample;

import com.alvin.nosql.NoSqlDbConnection;
import com.alvin.nosql.api.Operator;
import com.alvin.nosql.common.DataVault;
import com.alvin.nosql.common.DataVaultException;

public class SampleClient {

	public static void main(String[] args) {
		NoSqlDbConnection conn = NoSqlDbConnection.getNewConnection();
		try {
			conn.open("sample");
			DataVault dv = conn.getDataVault();

			UserCollection userCollection = (UserCollection)dv.findCollection("users", User.class);
			UserFilter filter = (UserFilter) userCollection.getDataFilter();
			filter.setAgeCondition(2, Operator.LESS_THAN);

			User[] users = userCollection.applyFilter(filter);

			System.out.println(users.length);
			
		} catch (DataVaultException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (DataVaultException e) {
				e.printStackTrace();
			}
		}
	}
}
