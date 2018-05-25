package com.yash.moviebookingsystem.util;

import java.util.Scanner;

import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.MovieService;
import com.yash.moviebookingsystem.service.ScreenService;
import com.yash.moviebookingsystem.serviceimpl.MovieServiceImpl;
import com.yash.moviebookingsystem.serviceimpl.ScreenServiceImpl;

public class MovieBookingSystem {

	public void startMbsApp() {
		String filePath = "src/main/resources/file/OperatorMenu.txt";
		OperatorMenu operatorMenu = new OperatorMenu();
		Scanner inputScanner = new Scanner(System.in);
		ScreenService screenService = new ScreenServiceImpl();
		MovieService movieService = new MovieServiceImpl();
		String continueChoice;
		int id = 101;
		do {
			operatorMenu.getOperatorMenu(filePath);
			System.out.println("Enter your choice ");
			int choice = inputScanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Your Screen name ");
				inputScanner.nextLine();
				String name = inputScanner.nextLine();
				Screen screen = new Screen(id++, name);
				screenService.addScreen(screen);
				break;
			case 2:
				Movie movie = new Movie();
				inputScanner.nextLine();
				System.out.println("Enter Screen Name ");
				String screenName = inputScanner.nextLine();
				System.out.println("Enter  Title ");
				movie.setTitle(inputScanner.nextLine());
				System.out.println("Enter Duration");
				movie.setDuration(inputScanner.nextLine());
				System.out.println("Enter Production name ");
				movie.setProduction(inputScanner.nextLine());
				System.out.println("Enter Actor");
				movie.setActors(inputScanner.nextLine());
				movieService.addMovie(screenName, movie);
				break;

			}
			System.out.println("Do you want to Continue (Y/N)");
			continueChoice = inputScanner.next();
		} while (continueChoice.equalsIgnoreCase("y"));

	}

}
