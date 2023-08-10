package com.cestar.termproject.group2.Controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.cestar.termproject.group2.DAO.PatientDAO;
import com.cestar.termproject.group2.modal.Patient;

public class PatientController {

	// Data Access Object for patient records
	PatientDAO dao = new PatientDAO();

	// Scanner for user input
	Scanner sc = new Scanner(System.in);

	/**
	 * Displays all patient records.
	 */
	public void getRecords() {
		try {
			System.out.println("*** Display Records ***");
			dao.getRecs(); // Retrieve and display patient records
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Displays a patient record by ID.
	 */
	public void getRecord() {
		try {
			System.out.println("*** Display Record by Id ***");

			// Patient object to hold search criteria
			Patient patient = new Patient();

			System.out.print("Enter patient id:");
			patient.setPatient_id(sc.nextInt()); // Read patient ID from user input
			sc.nextLine();

			dao.getRec(patient); // Retrieve and display patient record by ID
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getMessage(), e);
		}
	}

	/**
	 * Inserts a new patient record into the database.
	 */
	public void insertRecords() {
		try {
			System.out.println("*** Insert Records ***");

			// Patient object to hold new record data
			Patient patient = new Patient();

			System.out.print("Enter patient id:");
			patient.setPatient_id(sc.nextInt()); // Read patient ID from user input
			sc.nextLine();

			System.out.print("Enter patient name:");
			patient.setName(sc.nextLine()); // Read patient name from user input

			System.out.print("Enter patient contact:");
			patient.setContact(sc.nextLine()); // Read patient contact from user input

			System.out.print("Enter patient region:");
			patient.setRegion(sc.nextLine()); // Read patient region from user input

			System.out.print("Enter patient disease:");
			patient.setDisease(sc.nextLine()); // Read patient disease from user input

			System.out.print("Enter patient visit date (Eg. 2000-02-31):");
			String s = sc.nextLine();
			if (s.isEmpty()) {
				// Use current date if input is empty
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDateTime now = LocalDateTime.now();
				s = dtf.format(now);
			}
			Date date = Date.valueOf(s);
			patient.setVisit_date(date); // Set patient visit date

			dao.insertRecs(patient); // Insert the new patient record
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Updates an existing patient record in the database.
	 */
	public void updateRecords() {
		try {
			System.out.println("*** Update Records ***");

			// Patient object to hold updated record data
			Patient patient = new Patient();

			System.out.print("Enter patient id:");
			patient.setPatient_id(sc.nextInt()); // Read patient ID from user input
			sc.nextLine();

			System.out.print("Enter patient name:");
			patient.setName(sc.nextLine()); // Read updated patient name from user input

			System.out.print("Enter patient contact:");
			patient.setContact(sc.nextLine()); // Read updated patient contact from user input

			System.out.print("Enter patient region:");
			patient.setRegion(sc.nextLine()); // Read updated patient region from user input

			System.out.print("Enter patient disease:");
			patient.setDisease(sc.nextLine()); // Read updated patient disease from user input

			System.out.print("Enter patient visit date (Eg. 2000-02-31):");
			String s = sc.nextLine();
			if (!s.isEmpty()) {
				Date date = Date.valueOf(s);
				patient.setVisit_date(date); // Set updated patient visit date
			}

			dao.updateRecs(patient); // Update the existing patient record
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getLocalizedMessage(), e);
		}
	}

	/**
	 * Deletes a patient record from the database.
	 */
	public void deleteRecords() {
		try {
			System.out.println("*** Delete Records ***");

			// Patient object to hold record to be deleted
			Patient patient = new Patient();

			System.out.print("Enter patient id:");
			patient.setPatient_id(sc.nextInt()); // Read patient ID from user input
			sc.nextLine();

			dao.deleteRecs(patient); // Delete the patient record
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getLocalizedMessage(), e);
		}
	}
}
