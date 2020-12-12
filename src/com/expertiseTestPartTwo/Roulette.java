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
		
		//System.out.println(players);
	}
}
