package com.zensar.cms;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(DemoApplication.class, args);
		File file = new File("C:\\Users\\gk57092\\Desktop\\dbRecords.txt");
		Scanner sc = new Scanner(file);



		ArrayList<String> dbRecords = new ArrayList<>();

		while (sc.hasNextLine())
		dbRecords.add(sc.nextLine());


		File file2 = new File("C:\\Users\\gk57092\\Desktop\\pd_details.txt");
		Scanner sc2 = new Scanner(file2);



		ArrayList<String> pdRecords = new ArrayList<>();

		while (sc2.hasNextLine())
		pdRecords.add(sc2.nextLine());

		//here check the missmatch records

		ArrayList<String> result = (ArrayList)dbRecords.stream().filter(i->!pdRecords.contains(i)).collect(Collectors.toList());

		result.forEach(i->System.out.println(i));
		//System.out.println(result.size());
		}




		static void show() throws ArithmeticException {
		try {
		System.out.println("##" + 1 / 0);



		// return 1;
		} catch (Exception e) {
		System.out.println("^^^");
		// return 2;
		throw e;

	}
	}

}
