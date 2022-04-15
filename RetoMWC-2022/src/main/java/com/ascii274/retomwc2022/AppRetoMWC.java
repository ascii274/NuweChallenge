package com.ascii274.retomwc2022;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.ascii274.retomwc2022.helper.MongoConnectDB;
import com.ascii274.retomwc2022.repository.DeveloperRepository;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.LoggerFactory;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Projections.exclude;

public class AppRetoMWC {

	public static void main(String[] args) {

		DeveloperRepository developerRepository = new DeveloperRepository();
		MongoConnectDB mongoConnectDB = new MongoConnectDB();

		// disable mongo logging
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		Logger rootLogger = loggerContext.getLogger("org.mongodb.driver");
		rootLogger.setLevel(Level.OFF);

		try{
			MongoClient client = MongoClients.create();
			MongoDatabase database = client.getDatabase("nuwe-db");
			MongoCollection<Document> developers = database.getCollection("developers");
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
				developerRepository.insertDeveloper(mongoConnectDB.getDevelopers(), developerRepository.createDeveloper());

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
