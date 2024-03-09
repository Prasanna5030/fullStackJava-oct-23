package com.example;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello Mongo!");
		// Connect to MongoDB
		try {

			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase database = mongoClient.getDatabase("mydatabase");
			MongoCollection<Document> usersCollection = database.getCollection("users");

			//listAllDocumentsDemo(usersCollection);
			
			int age=30;
			listAllDocumentsHavingAge(usersCollection, age);

			// insertOneDocumentDemo(usersCollection, "USER102","USER102@gmail.com",28);
			
			//updateOneDocumentDemo(usersCollection, "USER101", "email", "USER101.new@gmail.com");
			
			//deleteOneDocumentDemo(usersCollection, "USER101");

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// Challenge: How will you find all users having age > 30 and name is Alice
	
	
	private static void listAllDocumentsHavingAge(MongoCollection<Document> usersCollection, int age) {
		
		FindIterable<Document> usersHavingAge30 = usersCollection.find(Filters.eq("age", 30));
		
		System.out.println("** Users Documents Having age 30**");
		for (Document user : usersHavingAge30) {
			System.out.println("** User **");
			System.out.println("Age: " + user.getInteger("age"));
			System.out.println("Username:  " + user.getString("username"));
			System.out.println("Email :  " + user.getString("email"));
			System.out.println("Name :  " + user.getString("name"));
			System.out.println("");
		}
		
	}


	public static void deleteOneDocumentDemo(MongoCollection<Document> collection, String username) {		

		collection.deleteOne(Filters.eq("username", username));

	}

	public static void updateOneDocumentDemo(MongoCollection<Document> collection, String username, String key,
			String new_value) {

		Document doc = new Document("$set", new Document(key, new_value));

		collection.updateOne(Filters.eq("username", username), doc);

	}

	public static void insertOneDocumentDemo(MongoCollection<Document> collection, String username, String email,
			int age) {

		Document user = new Document();

		user
		.append("email", email)
		.append("username", username)
		.append("age", age);

		collection.insertOne(user);
	}

	public static void listAllDocumentsDemo(MongoCollection<Document> collection) {
		FindIterable<Document> users = collection.find();

		for (Document user : users) {
			System.out.println("** User **");
			System.out.println("Age: " + user.getInteger("age"));
			System.out.println("Username:  " + user.getString("username"));
			System.out.println("Email :  " + user.getString("email"));
			System.out.println("Name :  " + user.getString("name"));
			System.out.println("");
		}

	}

}
