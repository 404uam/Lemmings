package lemming;

import java.io.File;
import java.util.*;

public class LemmingRunner {

	public static void main(String[] args) {
		
		Level level = new Level();
		//Reading in the file
		readFile(level);
		System.out.println(level.getAmountOfLemmings());
		

	}
	public static void readFile(Level level)
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
		level.setMaxHeight(reader.nextInt());
		level.setTimeLimit(reader.nextInt());
		level.setPassLemming(reader.nextInt());
		level.setAmountOfLemmings(reader.nextInt());
		
		for (int c = 0; c < level.getAmountOfLemmings(); c++)
		{
			Lemming temp = new Lemming();
			temp.setX(reader.nextInt());
			temp.setY(reader.nextInt());
			temp.setTime(reader.nextInt());
		}
		level.setWidth(reader.nextInt());
		level.setHeight(reader.nextInt());
		
		char[][] tempLevel = new char[level.getHeight()][level.getWidth()];
		
		for (int c = 0; c < level.getHeight(); c++)
		{
			String tempLine = reader.next();
			for(int i = 0; i < level.getWidth(); i++)
			{
				tempLevel[c][i] = tempLine.charAt(i);
			}
		}
		level.setLevel(tempLevel);
		level.setExitX(reader.nextInt());
		level.setExitY(reader.nextInt());
		reader.nextInt();
		reader.nextInt();
		reader.nextInt();
		level.setBlocker(reader.nextInt());
		reader.nextInt();
		level.setBasher(reader.nextInt());
		level.setDigger(reader.nextInt());
		reader.nextInt();
		
	}


}
