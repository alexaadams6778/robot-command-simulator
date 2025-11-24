/*
 * Written by Alexa Adams
 */

import java.util.Scanner;

public class RobotSimulatorDriver 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String boardFile, commandFile, choice = "";
		Board board = new Board();
		Commands commandLoader = new Commands();
		QueueI<String> cmdQueue = new LLQueue<>();
		
		System.out.print("Welcome to the Robot Simulator Program.");
		
		do
		{
			System.out.print("\n\nEnter a file for the board: ");
			boardFile = scanner.nextLine().trim();
			if(boardFile == null)
			{
				System.out.print("File is not valid. Try again.");
				continue;
			}
			board.loadBoard(boardFile);
			
			System.out.print("\nEnter a file for the Robot Commands: ");
			commandFile = scanner.nextLine().trim();
			if(commandFile == null)
			{
				System.out.print("File is not valid. Try again.");
				continue;
			}
			commandLoader.loadCommands(commandFile, cmdQueue);
			
			Robot robot = new Robot(0, 0, "R");
			
			if(board.getCell(0, 0).equalsIgnoreCase("X"))
			{
				System.out.print("\nCRASH! Initial position is an obstacle.");
			}
			else
			{
				System.out.print("\nInitial board:\n");
				board.printBoard(robot);
				
				boolean crashed = false;
				int count = 0;
				
				while(cmdQueue.peek() != null)
				{
					String command = cmdQueue.dequeue();
					
					if(command == null)
						break;
					
					System.out.print("\nApplying command " + count + ": "+ command.toLowerCase() + "\n");
					count++;
					
					int newRow = robot.getRow();
					int newCol = robot.getCol();
					
					if(command.equalsIgnoreCase("Move Up"))
						newRow--;
					else if(command.equalsIgnoreCase("Move Down"))
						newRow++;
					else if(command.equalsIgnoreCase("Move Left"))
						newCol--;
					else
						newCol++;
					
					if(!board.inBounds(newRow, newCol))
					{
						System.out.print("\nCRASH! Out of bounds at " + newRow + ", " + newCol + ".\n");
						crashed = true;
						break;
					}
					
					if(board.getCell(newRow, newCol).equalsIgnoreCase("X"))
					{
						System.out.print("\nCRASH! Hit obstacle at " + newRow + ", " + newCol + ".\n");
						crashed = true;
						break;
					}
					
					robot.moveTo(newRow, newCol);
					board.printBoard(robot);
				}
				
				if(!crashed)
					System.out.print("\nSimulation complete! No more commands.\n");
			}
			
			System.out.print("\nDo you want to run the program again? (Y/N): ");
			choice = scanner.nextLine().trim();
			
			while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
			{
				System.out.print("\nThat's not a valid answer. Try again (Y/N): ");
				choice = scanner.nextLine().trim();
			}
			
		}while(choice.equalsIgnoreCase("y"));
		
		System.out.print("\n\nGoodbye!");
	}

}
