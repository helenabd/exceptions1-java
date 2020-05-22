package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter formato  = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
		//TRATANDO EXCEÇÕES
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long difdias = ChronoUnit.DAYS.between(checkIn, checkOut);
		return difdias;
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		LocalDate hoje = LocalDate.now();
		if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if(!checkOut.isAfter(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		/* UTILIZANDO UMA CLASSE DE EXCEÇÃO JÁ EXISTENTE
		 * if(checkIn.isBefore(hoje) || checkOut.isBefore(hoje)) { throw new
		 * IllegalArgumentException("Reservation dates for update must be future dates"
		 * ); } if(!checkOut.isAfter(checkIn)) { throw new
		 * IllegalArgumentException("Check-out date must be after check-in date"); }
		 */
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room: "
				+ this.roomNumber
				+ ", check-in: "
				+ this.checkIn.format(formato)
				+ ", check-out: "
				+ this.checkOut.format(formato)
				+ ", "
				+ this.duration()
				+ " nights";
				
	}
}
