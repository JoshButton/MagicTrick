import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class MagicTrick {
	public static void main(String[] args) {
		Scanner in = null; //For reading input.txt
		PrintWriter out = null; //For writing output.txt
		int[][] grid = new int[4][4]; //For storing first arrangement of cards
		int[][] grid2 = new int[4][4]; //For storing second arrangement of cards
		try {
			in = new Scanner(new FileReader("input.txt")); //Point Scanner to input.txt
			out = new PrintWriter(new FileWriter("output.txt")); //Point PrintWriter to file to create
			String s = ""; //Declare String for reading lines from input file.
			String line = in.nextLine(); //Read first line of input.txt
			int testcase = 1; // to be printed in the output file (game number)
			while (in.hasNextLine()) {
				// for each iteration: parse the lines of the first board
				line= in.nextLine(); //Read line
				int n1 = Integer.parseInt(line) -1; /// read 1st answer
				//starts from 0
				for (int i=0; i<4; i++) {
					line= in.nextLine();
					String[] tokens= line.split(" ");
					//StringTokenizer st = new StringTokenizer(line);
					for (int j=0; j<tokens.length; j++) {
						grid[i][j] = Integer.parseInt(tokens[j]);
						System.out.print(grid[i][j] + " ");
					}
					System.out.println();//Gap between each line of file
				}
				System.out.println();//Gap between Boards
				// 1. now parse the lines of the second board
				line= in.nextLine();
				int n2 = Integer.parseInt(line) -1; /// read second answer
				for (int i=0; i<4; i++) {
					line= in.nextLine();
					String[] tokens= line.split(" ");
					for (int j=0; j<tokens.length; j++) {
						grid2[i][j] = Integer.parseInt(tokens[j]);
						System.out.print(grid[i][j] + " ");
					}
					System.out.println();
				}
				// 2. calculate the output
				HashSet<Integer> row = new HashSet<>();
				for (int j=0;j<4;j++) {
					row.add(grid[n1][j]);
				}

				int noInCommon =0;
				int number=0;

				for (int j=0;j<4;j++) {
					if (row.contains(grid2[n2][j])) {
						noInCommon++;	// count of how many numbers are in common between the 2 grids
						if (noInCommon == 1){
							number = grid2[n2][j]; // get the number that is in common
						}
						else{
							number = 0;
						}
					}
				}
				// 3. print the result on the output file

				if (noInCommon==0) System.out.println("Case #"+ testcase + ": " + "Volunteer cheated!"); //if 0 in common then "Volunteer cheated"
				if (noInCommon==1) System.out.println("Case #"+ testcase + ": " +  number); // if 1 in common show the common element
				if (noInCommon>1)  System.out.println("Case #"+ testcase + ": " +  "Bad magician!"); // if more than 1 in common then "Bad magician!"

				testcase++; //Increment testcase ready for next testcase(game)
			}
			in.close(); // close the scanner
			out.close(); // close the file to save the data

		}
		catch (Exception ex) {
			System.out.println("Error!!!");
		}
	}
}
