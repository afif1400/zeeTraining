package com.zee.zee5app;

import java.net.URL;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.MovieService;
import com.zee.zee5app.service.SeriesService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create register object
		Register register = new Register();
		// Register : class name
		// register: reference which will refer your object - in stack memory
		// new : is used to create object - in heap memory
		// Register(): default constructor
		
		register.setFirstName("rajiv");
		register.setLastName("gupta");
		register.setEmail("rg@321");
		
		System.out.println(register);
		System.out.println(register.toString());
		
		// whenever you will print the referenfe then it will call toString() method
		System.out.println(register.getEmail());
		
		//Create login object
		
		Login login  = new Login();
		
		login.setUserName("rg123");
		login.setPassword("sds");
		
		System.out.println(login);
		
		// we dont introduce private here to make it accessible
		UserService service = UserService.getInstance();
		// main is consuming the service
		// if we even call this 100 times it will create only 1 object now
		
		for(int i =1; i<=20;i++) {
			Register register2 = new Register();
			register2.setId("rg00"+i);
			register2.setFirstName("rajiv"+i);
			register2.setFirstName("gupta"+i);
			register2.setEmail("rg2321"+i);
			String result = service.addUser(register2);
			System.out.println(result);
			
		}
		
		Register register2 = service.getUserById("rg01");
		System.out.println(register2!=null);
		
		for (Register register3 : service.getUsers()) {
			if(register3!=null)
			 System.out.println(register3);
					
		}
			
		SubscriptionService service2 = SubscriptionService.getInstance();
		
		for(int i =1; i<=3;i++) {
			Subscription subscription = new Subscription();
			subscription.setId("sub00"+i);
			subscription.setAutoRenewal(null);
			subscription.setDateOfPurchase(null);
			subscription.setExpiryDate(null);
			subscription.setPackCountry(null);
			subscription.setPaymentMode(null);
			subscription.setStatus(null);
			subscription.setType(null);
			String result = service2.addSubscription(subscription);
			System.out.println(result);
			
		}
		
		
		MovieService service3 = MovieService.getInstance();
		for(int i =1; i<=5;i++) {
			Movie movie = new Movie();
			movie.setId("mov00"+i);
			movie.setMovieName("abc"+i);
			movie.setAgeLimit(null);
			movie.setCast(new String[] {"hrk","abt","tdc","sdf"});
			movie.setGenre("action"+i);
			movie.setLength(null);
			movie.setReleaseDate(null);
			movie.setTrailer(new URL("http://example.com/pages/page1.html"));
			String result = service3.addMovie(movie);
			System.out.println(result);
			
		}
		

		SeriesService service4 = SeriesService.getInstance();
		for(int i =1; i<=7;i++) {
			Series series = new Series();
			series.setId("sr00"+i);
			series.setSeriesName("xyz"+i);
			series.setAgeLimit(null);
			series.setCast(new String[] {"ytd","efd","gfh","trd"});
			series.setGenre("thriller"+i);
			series.setLength(null);
			series.setReleaseDate(null);
			series.setTrailer(null);
			String result = service4.addSeries(series);
			System.out.println(result);
			
		}
		
		for (Subscription subscription : service2.getAllSubscriptions()) {
			if(subscription!=null)
			 System.out.println(subscription);
					
		}
		
		for (Movie movie : service3.getAllMovies()) {
			if(movie!=null)
			 System.out.println(movie);
					
		}
		
		for (Series series : service4.getAllSeries()) {
			if(series!=null)
			 System.out.println(series);
					
		}
	

	}

}
