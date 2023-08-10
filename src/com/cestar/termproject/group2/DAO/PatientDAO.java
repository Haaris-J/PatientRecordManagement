package com.cestar.termproject.group2.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cestar.termproject.group2.modal.Patient;

public class PatientDAO {

	// Database connection variables
	private String user = "root"; // Database username
	private String password = ""; // Database password
	private String url = "jdbc:mysql://localhost:3306/PatientRecords"; // Database URL

	/**
	 * Establishes a database connection.
	 *
	 * @return The established database connection.
	 */
	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, password);

			System.out.println("Connection successful");

		} catch (ClassNotFoundException e) {
			printError(e.getLocalizedMessage(), e);
		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}

		return con;
	}

	/**
	 * Retrieves a list of all patients' records from the database.
	 *
	 * @return A list containing Patient objects representing retrieved records.
	 */
	public List<Patient> getRecs() {
		List<Patient> patients = new ArrayList<>();

		String sql = "select * from Patients";

		Connection con = getConnection();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// Extracting patient information from result set
				Patient patients_from_resultSet = new Patient(rs.getInt("patient_id"), rs.getString("name"),
						rs.getString("contact"), rs.getString("region"), rs.getString("disease"),
						rs.getDate("visit_date"));

				patients.add(patients_from_resultSet);

			}
			System.out.println("\n**************************************");
			if (patients.size() > 0) {
				for (int i = 0; i < patients.size(); i++) {
					System.out.println(patients.get(i));
				}
			} else {
				System.out.println("No records found!!");
			}
			System.out.println("**************************************\n");

		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}
		return patients;
	}

	/**
	 * Retrieves a list of patients' records matching the given patient object from
	 * the database.
	 *
	 * @param patient The Patient object to be used for retrieving records.
	 * @return A list containing Patient objects representing retrieved records.
	 */
	public List<Patient> getRec(Patient patient) {
		List<Patient> patients = new ArrayList<>();

		String sql = "select * from Patients where patient_id= ? ";

		Connection con = getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, patient.getPatient_id());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Extracting patient information from result set
				Patient patients_from_resultSet = new Patient(rs.getInt("patient_id"), rs.getString("name"),
						rs.getString("contact"), rs.getString("region"), rs.getString("disease"),
						rs.getDate("visit_date"));

				patients.add(patients_from_resultSet);

			}
			System.out.println("\n**************************************");
			if (patients.size() > 0) {
				for (int i = 0; i < patients.size(); i++) {
					System.out.println(patients.get(i));
				}
			} else {
				System.out.println("No records found!!");
			}
			System.out.println("**************************************\n");

		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}
		return patients;
	}

	/**
	 * Inserts a new patient record into the database.
	 *
	 * @param patients The Patient object containing record information to be
	 *                 inserted.
	 */
	public void insertRecs(Patient patients) {

		String sql = "insert into Patients (patient_id,name,contact,region,disease,visit_date) values(?,?,?,?,?,?)";

		Connection con = getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, patients.getPatient_id());
			stmt.setString(2, patients.getName());
			stmt.setString(3, patients.getContact());
			stmt.setString(4, patients.getRegion());
			stmt.setString(5, patients.getDisease());
			stmt.setDate(6, patients.getVisit_date());

			int status = stmt.executeUpdate();

			if (status == 1) {
				System.out.println("Record inserted successfully");
			} else {
				System.out.println("Record not inserted");
			}

		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}

	}

	/**
	 * Updates an existing patient record in the database.
	 *
	 * @param patients The Patient object containing updated record information.
	 */
	public void updateRecs(Patient patients) {

		String sql = "update Patients set ";
		Boolean bfr = false;
		Connection con = getConnection();

		try {

			if (!patients.getName().isEmpty()) {
				sql = sql + "name = '" + patients.getName().toString() + "'";
				bfr = true;
			}

			if (!patients.getContact().isEmpty()) {
				if (bfr) {
					sql = sql + ",";
				}
				sql = sql + "contact = '" + patients.getContact().toString() + "'";
				bfr = true;
			}

			if (!patients.getRegion().isEmpty()) {
				if (bfr) {
					sql = sql + ",";
				}
				sql = sql + "region = '" + patients.getRegion().toString() + "'";
				bfr = true;
			}

			if (!patients.getDisease().isEmpty()) {
				if (bfr) {
					sql = sql + ",";
				}
				sql = sql + "disease = '" + patients.getDisease().toString() + "'";
				bfr = true;
			}

			if (patients.getVisit_date() != null) {
				if (bfr) {
					sql = sql + ",";
				}
				sql = sql + "visit_date = '" + patients.getDisease().toString() + "'";
				bfr = true;
			}

			sql = sql + " where patient_id=" + patients.getPatient_id();
			PreparedStatement stmt = con.prepareStatement(sql);
			int status = stmt.executeUpdate();

			if (status == 1) {
				System.out.println("Record updated successfully");
			} else {
				System.out.println("Record not updated");
			}

		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}

	}

	/**
	 * Deletes a patient record from the database.
	 *
	 * @param patients The Patient object containing record information to be
	 *                 deleted.
	 */
	public void deleteRecs(Patient patients) {

		String sql = "delete from Patients where patient_id = ?";

		Connection con = getConnection();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, patients.getPatient_id());

			int status = stmt.executeUpdate();

			if (status == 1) {
				System.out.println("Record deleted successfully");
			} else {
				System.out.println("Record not deleted");
			}

		} catch (SQLException e) {
			printError(e.getLocalizedMessage(), e);
		}

	}

	/**
	 * Prints error message and writes full error to a file
	 *
	 * @param error The message string to print on console
	 * @param e     The error object
	 */
	public void printError(String error, Object e) {
		System.out.println("**** Error occured ****");
		if (error != null) {
			System.out.println(error);
		}
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("Error.txt", true));
			// Writing on. file
			out.write(System.lineSeparator());
			out.write(java.time.LocalDate.now().toString() + " " + java.time.LocalTime.now());
			out.write(System.lineSeparator());
			out.write(e.toString());
			out.write(System.lineSeparator());

			// Closing file connections
			out.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("*** returning to menu ***\n");
	}
}
