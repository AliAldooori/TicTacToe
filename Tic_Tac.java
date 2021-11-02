

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tic_Tac {

	static ArrayList<Integer> playerinput = new ArrayList<>();
	static ArrayList<Integer> playerRandom = new ArrayList<>();

	public static void main(String[] args) {

		char[][] board = new char[][] { { ' ', '|', ' ', '|', ' ' },
			                           { '-', '+', '-', '+', '-' },
				                       { ' ', '|', ' ', '|', ' ' }, 
				                       { '-', '+', '-', '+', '-' }, 
				                       { ' ', '|', ' ', '|', ' ' } };

		printbord(board);
		
		int player1current;
		int player2current;
		
		do {
			System.out.println("Enter your number between 1-9: ");

			player1current = player1();
			playerposition(board, player1current, "player1");
			playerinput.add(player1current);
			System.out.println(playerinput);
			
			printbord(board);

			player2current = player2(); 
			playerposition(board, player2current, "player2");
			playerRandom.add(player2current);
			System.out.println(playerRandom);
			
			printbord(board);
			
			
			ArrayListWinner(playerinput, playerRandom);

		} while (playerinput.size() + playerRandom.size() <= 9);
		System.out.println("game over ");

	}

	public static void printbord(char[][] bord) {

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				System.out.print(bord[i][j]);

			}
			System.out.println();
		}

	}

	public static int player1() {

		Scanner input = new Scanner(System.in);

		int player1 = input.nextInt();
		while (playerinput.contains(player1) || playerRandom.contains(player1)) {
			System.out.println("Invalid position, choose another position: ");
			player1 = input.nextInt();
		
		}
		return player1;

	}

	public static int player2() {

		Random rnd = new Random();

		int player2 = rnd.nextInt(9) + 1;
		while (playerinput.contains(player2) || playerRandom.contains(player2)) {
			player2 = rnd.nextInt(9) + 1;
		
		}
		return player2;

	}

	public static void playerposition(char[][] bord, int pos, String user) {

		char symbol = ' ';

		if (user.equals("player1")) {

			symbol = 'x';

		} else if (user.equals("player2")) {

			symbol = 'o';
		}

		switch (pos) {

		case 1:
			bord[0][0] = symbol;
			break;
		case 2:
			bord[0][2] = symbol;
			break;
		case 3:
			bord[0][4] = symbol;
			break;
		case 4:
			bord[2][0] = symbol;
			break;
		case 5:
			bord[2][2] = symbol;
			break;
		case 6:
			bord[2][4] = symbol;
			break;
		case 7:
			bord[4][0] = symbol;
			break;
		case 8:
			bord[4][2] = symbol;
			break;
		case 9:
			bord[4][4] = symbol;
			break;

		}

	} 
	
	public static void ArrayListWinner(ArrayList a, ArrayList b) {

		

		List<Integer> toprow = Arrays.asList(1, 2, 3);
		List<Integer> middlerow = Arrays.asList(4, 5, 6);
		List<Integer> bottumrow = Arrays.asList(7, 8, 9);
		List<Integer> leftcolum = Arrays.asList(1, 4, 7);
		List<Integer> midcolum = Arrays.asList(2, 5, 8);
		List<Integer> rightcolum = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(3, 5, 7);

		ArrayList<List> winner = new ArrayList<List>();

		winner.add(toprow);
		winner.add(middlerow);
		winner.add(bottumrow);
		winner.add(leftcolum);
		winner.add(midcolum);
		winner.add(rightcolum);
		winner.add(cross1);
		winner.add(cross2);

		if (a.equals(toprow) || a.equals(middlerow) || a.equals(bottumrow) || a.equals(leftcolum) || a.equals(midcolum)
				|| a.equals(rightcolum) || a.equals(cross1) || a.equals(cross2)) {

			System.out.println("congrats, you win");
			return;
		}

		else if (b.equals(toprow) || b.equals(middlerow) || b.equals(bottumrow) || b.equals(leftcolum)
				|| b.equals(midcolum) || b.equals(rightcolum) || b.equals(cross1) || b.equals(cross2)) {

			System.out.println("Sorry ,you lose  cpu win");
			return;
		}
	}
		
}
