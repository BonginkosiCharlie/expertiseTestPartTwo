package com.expertiseTestPartTwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Roulette {

	public static void main(String[] args) {
		/* Initialization of variables */
		String playerFile = "players.txt";
		String line = "";

		Scanner keyboard = new Scanner(System.in);
		Random generator = new Random();

		double amount = 0;
		String choice, amountStr = "";
		int spin = 0, rouletteNum;

		ArrayList<String> players = new ArrayList<String>();

		/* Extract players from a file */
		try {
			BufferedReader br = new BufferedReader(new FileReader(playerFile));

			while ((line = br.readLine()) != null) {
				System.out.println(line);
				players.add(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println(players);
		
		/* Storage for player's bet */
		String[][] playersBet = new String[players.size()][players.size()]; 
		
		for (int i = 0; i < players.size(); i++) {
			System.out.println(">>>>>>>>>>> Player "+ (i+1) +" <<<<<<<<<<<<");
			System.out.println("Place your bet and the amount you want to bet with " + players.get(i) + " ");
			
			choice = keyboard.nextLine();
			// check if bet is either 0-36 or even or odd 
			try{
				int choiceInt = Integer.parseInt(choice);
				if (choiceInt < 0 || choiceInt > 36) {
					System.out.println("Please enter a valid choice (either 0-36 or even or odd -- 1)...");
					choice = keyboard.nextLine();
					if (choice.equalsIgnoreCase("quit")) {
						break;
					}
				}
			} catch(NumberFormatException e) {
				if ((!choice.equalsIgnoreCase("even")) && (!choice.equalsIgnoreCase("odd"))) {
					if (choice.equalsIgnoreCase("quit")) {
						break;
					}
					System.out.println("Please enter a valid choice (either 0-36 or even or odd -- 2)...");
					choice = keyboard.nextLine();
					if (choice.equalsIgnoreCase("quit")) {
						break;
					}
				}
			}
			
			System.out.println(choice);
			
			amountStr = keyboard.nextLine();
			if (amountStr.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println(amountStr);
			
			try {
			  amount = Double.parseDouble(amountStr);
			} catch(NumberFormatException e) {
			  System.out.println("Please enter a valid amount...");
			  amountStr = keyboard.nextLine();
			  amount = Double.parseDouble(amountStr);
			}
			
			playersBet[i][0] = players.get(i);
			playersBet[i][1] = choice;
			playersBet[i][2] = String.valueOf(amount);
			
	
		}
		
	}
}
