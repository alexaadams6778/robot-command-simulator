/*
 * Written by Alexa Adams
 */

import java.io.File;
import java.util.Scanner;

public class Commands //command class to add to queue
{
	public void loadCommands(String fileName, QueueI<String> cmdQueue)
	{
		try
		{
			Scanner fileScanner = new Scanner(new File(fileName));
			
			while(fileScanner.hasNextLine())
			{
				String command = fileScanner.nextLine();
				
				if(command.equalsIgnoreCase("Move Up") || command.equalsIgnoreCase("Move Down") || 
						command.equalsIgnoreCase("Move Right") || command.equalsIgnoreCase("Move Left"))
					cmdQueue.enqueue(command);
				else
					continue;	//skip if not a proper command
			}
			fileScanner.close();	//closes the file Scanner
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
