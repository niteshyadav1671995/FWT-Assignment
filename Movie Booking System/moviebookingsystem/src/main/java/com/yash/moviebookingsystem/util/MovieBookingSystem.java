package com.yash.moviebookingsystem.util;

import java.util.Scanner;

import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.daoimpl.ShowDAOImpl;
import com.yash.moviebookingsystem.model.Movie;
import com.yash.moviebookingsystem.model.Screen;
import com.yash.moviebookingsystem.service.MovieService;
import com.yash.moviebookingsystem.service.ScreenService;
import com.yash.moviebookingsystem.service.ShowService;
import com.yash.moviebookingsystem.serviceimpl.MovieServiceImpl;
import com.yash.moviebookingsystem.serviceimpl.ScreenServiceImpl;
import com.yash.moviebookingsystem.serviceimpl.ShowServiceImpl;

public class MovieBookingSystem {

	public void startMbsApp() {
		JSONUtil jsonUtil = new JSONUtil();
		String filePath = "src/main/resources/file/OperatorMenu.txt";
		OperatorMenu operatorMenu = new OperatorMenu();
		Scanner inputScanner = new Scanner(System.in);
		ScreenService screenService = new ScreenServiceImpl();
		MovieService movieService = new MovieServiceImpl();
		ShowDAO showDAO = new ShowDAOImpl(jsonUtil);
		ShowService showService = new ShowServiceImpl(showDAO);
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
			case 4:
				System.out.println("Enter Screen Name ");
				inputScanner.nextLine();
				String screenname = inputScanner.nextLine();
				showService.displayPossibleShows(screenname);
				System.out.println("Add the shows to the screen. Y/N to confirm");
				continueChoice = inputScanner.next();
				if (continueChoice.equalsIgnoreCase("Y")) {
					showService.addShows(screenname);
				}
				break;
			}
			System.out.println("Do you want to Continue (Y/N)");
			continueChoice = inputScanner.next();
		} while (continueChoice.equalsIgnoreCase("y"));

	}

}
