package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formato  = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //para formatar a data de entrada
		
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), formato);
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), formato);
		
		//SOLUÇÃO MUITO RUIM
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), formato);
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), formato);
			
			LocalDate hoje = LocalDate.now();
			if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}

		}
		
		/*TESTE DO MÉTODO DURATION
		 * int num = 1001; LocalDate checkIn = LocalDate.of(2020, 5, 29); LocalDate
		 * checkOut = LocalDate.of(2020, 6, 04);
		 * 
		 * Reservation reservation = new Reservation(num, checkIn, checkOut);
		 * 
		 * System.out.println("Reservation: " + reservation);
		 */
		 
		sc.close();

	}

}
