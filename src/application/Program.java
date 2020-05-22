package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato  = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //para formatar a data de entrada
		
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), formato);
			
			Reservation reservation = new Reservation(number, checkIn, checkOut); 
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): "); 
			checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("Check-in date (dd/MM/yyyy): "); 
			checkOut = LocalDate.parse(sc.next(), formato);
			
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch (DateTimeParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		/*UTILIZANDO UMA CLASSE DE EXCEÇÃO JÁ EXISTENTE
		 * catch (IllegalArgumentException e) {
		 * System.out.println("Error in reservation: " + e.getMessage()); }
		 */
		
		sc.close();

	}

}
