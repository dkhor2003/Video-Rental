package edu.iastate.cs228.hw4;


import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Dylan Khor
 *
 */

/**
 * 
 * The Transactions class simulates video transactions at a video store. 
 *
 */
public class Transactions 
{
	
	/**
	 * The main method generates a simulation of rental and return activities.  
	 *  
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		// 
		// 1. Construct a VideoStore object.
		// 2. Simulate transactions as in the example given in Section 4 of the 
		//    the project description. 
		
		System.out.println("Transactions at a Video Store"); 
		System.out.println("keys: 1 (rent)     2 (bulk rent)");
		System.out.println("      3 (return)   4 (bulk return)"); 
		System.out.println("      5 (summary)  6 (exit)"); 
 
		Scanner scnr = new Scanner(System.in); 
		int i = 0; 
		VideoStore store = new VideoStore("video.txt");
		
		while(i != 6) {  
			System.out.println();
			System.out.print("Transaction: "); 
			i = scnr.nextInt();
			
			if(i == 1) {
				System.out.print("Film to rent: ");
				scnr.nextLine();
				String film = scnr.nextLine();
				String filmName = VideoStore.parseFilmName(film);  
				int copies = VideoStore.parseNumCopies(film);
				try {
					store.videoRent(filmName, copies);
				} catch (IllegalArgumentException e) {	
					System.out.println("Film " + film + " has an invalid request"); 
				} catch (FilmNotInInventoryException e) {
					System.out.println("Film " + film + " is not in inventory"); 
				} catch (AllCopiesRentedOutException e) {
					System.out.println("Film " + film + " has been rented out"); 
				}
				
			}
			else if(i == 2) {
				System.out.print("Video file (rent): ");
				String videoFile = scnr.next(); 
				try {
					store.bulkRent(videoFile);
				} catch (FileNotFoundException e) {
					
				} catch (IllegalArgumentException e) {
					
				} catch (FilmNotInInventoryException e) {
					
				} catch (AllCopiesRentedOutException e) {
					
				}
			}
			else if(i == 3) {
				System.out.print("Film to return: ");
				scnr.nextLine();
				String film = scnr.nextLine();
				String filmName = VideoStore.parseFilmName(film);  
				int copies = VideoStore.parseNumCopies(film); 
				
				try {
					store.videoReturn(filmName, copies);
				} catch (IllegalArgumentException e) {
					
				} catch (FilmNotInInventoryException e) {
					
				}
				
			}
			else if(i == 4) {
				System.out.print("Video file (return): ");
				String videoFile = scnr.next(); 
				try {
					store.bulkReturn(videoFile);
				} catch (FileNotFoundException e) {
					
				} catch (IllegalArgumentException e) {
					
				} catch (FilmNotInInventoryException e) {
					
				}
			}
			else if(i == 5) {
				System.out.print(store.transactionsSummary());
			}
			else if(i == 6){
				System.out.println("-----TERMINATED-----");
			}
			else {
				System.out.println("Please enter a number from the keys listed above...");
				System.out.println(); 
			}
		}
	}
}
