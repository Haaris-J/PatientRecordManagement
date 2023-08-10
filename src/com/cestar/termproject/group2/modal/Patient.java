package com.cestar.termproject.group2.modal;

import java.sql.Date;

/**
 * Represents a patient with various attributes.
 */
public class Patient {

	private int patient_id; // Patient ID
	private String name; // Patient name
	private String contact; // Patient contact information
	private String region; // Region of patient
	private String disease; // Disease of the patient
	private Date visit_date; // Date of patient visit

	/**
	 * Constructor to initialize a Patient object with details.
	 * 
	 * @param patient_id The ID of the patient
	 * @param name       The name of the patient
	 * @param contact    The contact information of the patient
	 * @param region     The region of the patient
	 * @param disease    The disease of the patient
	 * @param visit_date The date of the patient's visit
	 */
	public Patient(int patient_id, String name, String contact, String region, String disease, Date visit_date) {
		this.patient_id = patient_id;
		this.name = name;
		this.contact = contact;
		this.region = region;
		this.disease = disease;
		this.visit_date = visit_date;
	}

	/**
	 * Default constructor for the Patient class.
	 */
	public Patient() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Returns the patient ID.
	 * 
	 * @return The patient ID
	 */
	public int getPatient_id() {
		return patient_id;
	}

	/**
	 * Sets the patient ID.
	 * 
	 * @param patient_id The patient ID to set
	 */
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * Returns the patient's name.
	 * 
	 * @return The patient's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the patient's name.
	 * 
	 * @param name The patient's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the patient's contact information.
	 * 
	 * @return The patient's contact information
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * Sets the patient's contact information.
	 * 
	 * @param contact The patient's contact information to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * Returns the patient's region.
	 * 
	 * @return The patient's region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * Sets the patient's region.
	 * 
	 * @param region The patient's region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Returns the patient's disease.
	 * 
	 * @return The patient's disease
	 */
	public String getDisease() {
		return disease;
	}

	/**
	 * Sets the patient's disease.
	 * 
	 * @param disease The patient's disease to set
	 */
	public void setDisease(String disease) {
		this.disease = disease;
	}

	/**
	 * Returns the patient's visit date.
	 * 
	 * @return The patient's visit date
	 */
	public Date getVisit_date() {
		return visit_date;
	}

	/**
	 * Sets the patient's visit date.
	 * 
	 * @param visit_date The patient's visit date to set
	 */
	public void setVisit_date(Date visit_date) {
		this.visit_date = visit_date;
	}

	/**
	 * Generates a string representation of the Patient object.
	 * 
	 * @return A string representation of the Patient object
	 */
	@Override
	public String toString() {
		return "Patient [patient_id=" + patient_id + ", name=" + name + ", contact=" + contact + ", region=" + region
				+ ", disease=" + disease + ", visit_date=" + visit_date + "]";
	}
}
