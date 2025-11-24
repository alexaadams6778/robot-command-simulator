/*
 * Written by Alexa Adams
 */

import java.util.Scanner;
import java.io.*;

public class Board 
{
	private String[][] board;
	public static final int SIZE = 10;
	
	public Board()
	{
		board = new String[SIZE][SIZE];
	}
	
	public void loadBoard(String fileName)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			int row = 0;
			while(fileScanner.hasNextLine() && row < SIZE)
			{
				String fileLine = fileScanner.nextLine();
				
				if(fileLine.length() < SIZE)
					continue;	//skip if not properly formatted
				
				for(int col = 0; col < SIZE; col++)
				{
					char ch = fileLine.charAt(col);
					
					if(ch == 'X' || ch == 'x' || ch == '_')
						board[row][col] = String.valueOf(ch).toUpperCase();
					else
						board[row][col] = "_";
				}
				row++;
			}
			fileScanner.close();	//closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getCell(int r, int c)
	{
		return board[r][c];
	}
	
	public boolean inBounds(int r, int c) 
	{
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }
	
	public void printBoard(Robot robot)
	{
		for(int r = 0; r < SIZE; r++)
		{
			for(int c = 0; c < SIZE; c++)
			{
				if(r == robot.getRow() && c == robot.getCol())
					System.out.print(robot.getSymbol());
				else
					System.out.print(board[r][c]);
			}
			System.out.print("\n");
		}
	}
}
