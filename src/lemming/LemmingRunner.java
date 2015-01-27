package lemming;

import java.io.File;
import java.util.*;

public class LemmingRunner {

	public static void main(String[] args) {
		
		//Reading in the file
		readFile();
		

	}
	public static void readFile()
	{
		File file = new File("test_level_01.txt");
		Scanner reader = null;
		try{
			reader = new Scanner(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		int maxHeight = reader.nextInt();
		int timeLimit = reader.nextInt();
		int passLemming = reader.nextInt();
		int amountOfLemmings = reader.nextInt();
		
		for (int c = 0; c < amountOfLemmings; c++)
		{
			Lemming temp = new Lemming();
			temp.setX(reader.nextInt());
			temp.setY(reader.nextInt());
			temp.setTime(reader.nextInt());
		}
		
		
	}


}
