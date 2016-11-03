package com.poc.db.nosql.mongo;

import com.mongodb.CommandResult;
import com.mongodb.MongoClient;
import com.mongodb.DB;

import java.util.Map.Entry;
import java.util.Set;

public class MongoDBJDBC {

	public static void main(String args[]) {
		try {
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// Now connect to your databases
			DB db = (DB) mongoClient.getDB("helloworld");
			System.out.println("Connect to database successfully");
			CommandResult res = db.command("db.users.find()");
			Set<Entry<String, Object>> values = res.entrySet();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}