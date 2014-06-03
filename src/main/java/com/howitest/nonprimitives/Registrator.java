package com.howitest.nonprimitives;

public class Registrator {

	private DatabaseWriter writer = new DatabaseWriter();
	
	// for unit tests
	void setDatabaseWriter(DatabaseWriter newWriter) {
		writer = newWriter;
	}
	
	public void registerRootUser(String password) {
		Parameters params = new Parameters();
		params.username = "root";
		params.password = password;
		writer.writeUserInfo(params);
	}
}
