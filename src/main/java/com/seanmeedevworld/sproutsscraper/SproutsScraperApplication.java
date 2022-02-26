package com.seanmeedevworld.sproutsscraper;

import com.seanmeedevworld.sproutsscraper.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class SproutsScraperApplication implements CommandLineRunner {

	@Autowired
	GroceryService groceryService;

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(SproutsScraperApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		runConsoleApp();
	}

	public void runConsoleApp() {
		String command = "";
		while(!command.toLowerCase().equals("exit")) {
			System.out.println("******* Choose a command ********");
			System.out.println("1: Update Sprouts Table");
			System.out.println("2: Clear Sprouts Table");
			System.out.println("Exit: Stop Application");
			Scanner scanner = new Scanner(System.in);
			command = scanner.next();
			switch (command)
			{
				case "1":
					groceryService.clearSproutsTable();
					groceryService.setSproutsTable();
					break;
				case "2":
					groceryService.clearSproutsTable();
			}
		}
		SpringApplication.exit(applicationContext, () -> 0);
	}
}
