package com.yash.moviebookingsystem.util;

import java.util.Scanner;

import com.yash.moviebookingsystem.dao.MovieDAO;
import com.yash.moviebookingsystem.dao.ScreenDAO;
import com.yash.moviebookingsystem.dao.ShowDAO;
import com.yash.moviebookingsystem.daoimpl.MovieDAOImpl;
import com.yash.moviebookingsystem.daoimpl.ScreenDAOImpl;
import com.yash.moviebookingsystem.daoimpl.ShowDAOImpl;
import com.yash.moviebookingsystem.literals.MBSContants;
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
		String filePath = MBSContants.FILE_PATH;
		OperatorMenu operatorMenu = new OperatorMenu();
		Scanner inputScanner = new Scanner(System.in);
		ScreenDAO screenDAO = new ScreenDAOImpl();
		ScreenService screenService = new ScreenServiceImpl(screenDAO);
		MovieDAO movieDAO = new MovieDAOImpl();
		MovieService movieService = new MovieServiceImpl(movieDAO);
		ShowDAO showDAO = new ShowDAOImpl(jsonUtil);
		ShowService showService = new ShowServiceImpl(showDAO);
		String continueChoice;
		int id = 101;
		do {
			operatorMenu.getOperatorMenu(filePath);
			System.out.println(MBSContants.ENTER_YOUR_CHOICE);
			int choice = inputScanner.nextInt();
			switch (choice) {
			case 1:
				id = addScreen(inputScanner, screenService, id);
				break;
			case 2:
				addMovieToScreen(inputScanner, movieService);
				break;
			case 3:
				addShowToMovie(inputScanner, showService);
				break;
			case 4:
				System.out.println(MBSContants.MBS_EXITED);
				System.exit(0);
				break;
			default:
				System.out.println(MBSContants.INVALID_CHOICE);
			}
			System.out.println(MBSContants.CONTINUE_CHOICE);
			continueChoice = inputScanner.next();
		} while (continueChoice.equalsIgnoreCase("y"));

	}

	private void addShowToMovie(Scanner inputScanner, ShowService showService) {

		String continueChoice;
		System.out.println(MBSContants.ENTER_SCREEN_NAME);
		inputScanner.nextLine();
		String screenname = inputScanner.nextLine();
		showService.displayPossibleShows(screenname);
		System.out.println(MBSContants.ADD_SHOW_CONFIRMATION);
		continueChoice = inputScanner.next();
		if (continueChoice.equalsIgnoreCase("Y")) {
			showService.addShows(screenname);
			System.out.println(MBSContants.SHOWS_ADDED_SUCCESSFULLY);
		}
		if (continueChoice.equalsIgnoreCase("N")) {
			System.out.println(MBSContants.SHOWS_NOT_ADDED);
		}
	}

	private void addMovieToScreen(Scanner inputScanner, MovieService movieService) {

		Movie movie = new Movie();
		inputScanner.nextLine();
		System.out.println(MBSContants.ENTER_SCREEN_NAME);
		String screenName = inputScanner.nextLine();
		System.out.println(MBSContants.ENTER_TITLE);
		movie.setTitle(inputScanner.nextLine());
		System.out.println(MBSContants.ENTER_DURATION);
		movie.setDuration(inputScanner.nextLine());
		System.out.println(MBSContants.ENTER_PRODUCTION_NAME);
		movie.setProduction(inputScanner.nextLine());
		System.out.println(MBSContants.ENTER_ACTOR);
		movie.setActors(inputScanner.nextLine());
		movieService.addMovie(screenName, movie);
		System.out.println(MBSContants.MOVIE_ADDED);
	}

	private int addScreen(Scanner inputScanner, ScreenService screenService, int id) {

		System.out.println(MBSContants.ENTER_SCREEN_NAME);
		inputScanner.nextLine();
		String name = inputScanner.nextLine();
		Screen screen = new Screen(id++, name);
		screenService.addScreen(screen);
		System.out.println(MBSContants.SCREEN_ADDED);
		return id;
	}

}
