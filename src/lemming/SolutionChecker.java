package lemming;

import java.util.Scanner;

public class SolutionChecker {
	private Level level;
	private int time;
	private Scanner keyboard = new Scanner(System.in);
	
	public SolutionChecker(Level level)
	{
		this.level = level;
		time = 0;
	}
	
	public void run()
	{
		while(time < level.getTimeLimit())
		{
			for(int c = 0; c < level.getAmountOfLemmings(); c++)
			{
				Lemming temp = level.getLemmings().get(c);
				
				if(time == temp.getTime())
				{
					temp.spawn();
					level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
				}
				
				else if(temp.isAlive())			
				{
					if(inAir(temp))
					{
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = 'a';
						temp.setX(temp.getCurrentX()+1);
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
					}
				}
			}
			
			for(int i = 0; i < level.getHeight(); i++)
			{
				for(int j = 0; j < level.getWidth(); j++)
				{
					System.out.print(level.getLevel()[i][j]);
				}
				System.out.print("\n");
			}
			System.out.println("Press a button");
			keyboard.nextLine();
			time++;
		}
	}
	public boolean inAir(Lemming lemming)
	{ 
		boolean result = false;
		
		if(level.getLevel()[lemming.getCurrentX() + 1][lemming.getCurrentY()] == 'a')
		{
			result = true;
		}
		
		
		return result;
	}

}
