package com.ascii274.retomwc2022;

import com.ascii274.retomwc2022.repository.DeveloperRepository;
import com.ascii274.retomwc2022.helper.MongoConnectDB;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.exclude;



public class AppRetoMWC {

	public static void main(String[] args) {

		DeveloperRepository developerController = new DeveloperRepository();
		MongoConnectDB mongoConnectDB = new MongoConnectDB();

		//ConfigLogger configLogger = new ConfigLogger(); // review JJJ
		Logger.getLogger("org.mongodb.driver.connection").setLevel(Level.OFF);
		Logger.getLogger("org.mongodb.driver.management").setLevel(Level.OFF);
		Logger.getLogger("org.mongodb.driver.cluster").setLevel(Level.OFF);
		Logger.getLogger("org.mongodb.driver.protocol.insert").setLevel(Level.OFF);
		Logger.getLogger("org.mongodb.driver.protocol.query").setLevel(Level.OFF);
		Logger.getLogger("org.mongodb.driver.protocol.update").setLevel(Level.OFF);
//		logging.level.org.mongodb=warn;
//		logging.level.org.springframework.boot.autoconfigure.mongo.embedded=warn;

//		Logger logger = Logger.getLogger("org.mongodb.driver.cluster");
//		logger.setLevel(Level.OFF);
		Logger logger = Logger.getLogger("org.mongodb.driver");
		logger.setLevel(Level.OFF);

		try{
			Options options = new Options();
			options.addOption("disday", "displayDay", false, "Display days" );
			options.addOption("lisdev", "listDevelop", false, "Listing developers" );
			options.addOption("addev", "adDevelop", false, "Adding developers" );
			CommandLine line = new DefaultParser().parse(options,args);

			if (line.hasOption("disday")){
				getDays(mongoConnectDB.getDevelopers());

			}

			if (line.hasOption("lisdev")){
				listDevelopers(mongoConnectDB.getDevelopers());
			}

			if(line.hasOption("addev")){
				developerController.insertDeveloper(mongoConnectDB.getDevelopers(), developerController.createDeveloper());
				listDevelopers(mongoConnectDB.getDevelopers());

			}


		} catch (Exception e) {
//            e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	//lambda version
	private static void getDays(MongoCollection<Document> developers) {
		Bson filter = Filters.empty();
		Bson projection = fields(include("date"), exclude("_id"));
		System.out.println("******************* Lista fechas ******************************");
		developers.find(filter).projection(projection).forEach(doc -> System.out.println(doc.toString()));
	}

	private static void getDays_2(MongoCollection<Document> developers) {
		Bson filter = Filters.empty();
		Bson projection = fields(include("date"), exclude("_id"));
		System.out.println("******************* Lista fechas ******************************");
		MongoCursor<Document> cursor= developers.find(filter).projection(projection).iterator();
		try{
			while (cursor.hasNext()){
				System.out.println(cursor.next().toString());
			}
		}finally {
			cursor.close();
		}
	}

	private static void listDevelopers(MongoCollection<Document> developers) {
		System.out.println("******************* Lista developers ******************************");
		MongoCursor<Document> cursor = developers.find().iterator();
		try{
			while (cursor.hasNext()){
				System.out.println(cursor.next().toString());
			}
		}finally {
			cursor.close();
		}
	}


}
