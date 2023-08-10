package com.cestar.termproject.group2.Runner;

import java.util.Scanner;

import com.cestar.termproject.group2.Controller.PatientController;
import com.cestar.termproject.group2.DAO.PatientDAO;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PatientController obj = new PatientController();

		try (Scanner sc = new Scanner(System.in)) {
			int esc = 0;

			while (true) {
				System.out.println("**** Patients Management Concole ****");
				System.out.println("1. Display all patients");
				System.out.println("2. Display patients by id");
				System.out.println("3. Insert patients");
				System.out.println("4. Update patients by id");
				System.out.println("5. Delete patients by id");
				System.out.println("6. Exit");
				System.out.println("**************************************");
				System.out.println();

				System.out.println("--- Enter your choice -----");
				esc = sc.nextInt();

				switch (esc) {

				case 1:
					obj.getRecords();
					break;
				case 2:
					obj.getRecord();
					break;
				case 3:
					obj.insertRecords();
					break;
				case 4:
					obj.updateRecords();
					break;
				case 5:
					obj.deleteRecords();
					break;
				case 6:
				default:
					break;
				}
				if (esc == 6) {
					break;
				}
			}
		} catch (Exception e) {
			PatientDAO er = new PatientDAO();
			er.printError(e.getLocalizedMessage(), e);
		}
	}

}
