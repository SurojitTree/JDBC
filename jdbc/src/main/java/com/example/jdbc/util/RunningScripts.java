package com.example.jdbc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;

import org.apache.ibatis.jdbc.ScriptRunner;

public class RunningScripts {
	public void runDbScript() throws Exception {
		Connection con = DbUtil.getConnection();
		ScriptRunner sr = new ScriptRunner(con);
		BufferedReader reader = new BufferedReader(
				new FileReader("C:\\Users\\Surojit Ghosh\\Downloads\\jdbc\\jdbc\\db.sql"));
		//BufferedReader reader = new BufferedReader(new FileReader("/projects/challenge/JDBC/db.sql"));

		String st;
		while ((st = reader.readLine()) != null) {
			sr.runScript(reader);
		}
	}
}
