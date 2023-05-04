package com.jspiders.jdbc;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your name");
		String name = scanner.next();
		System.out.println(name);
		System.out.println("Enter your Age");
		int age = scanner.nextInt();
		System.out.println(age);
		
	}
}
