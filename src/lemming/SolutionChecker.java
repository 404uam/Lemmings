/**
 * 
 * @author Louis Mau
 */
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
		while(time < level.getTimeLimit() && level.getLemmingsLeft() > 0)
		{
			for(int c = 0; c < level.getAmountOfLemmings(); c++)
			{
				Lemming temp = level.getLemmings().get(c);
				
				if(time == temp.getTime())
				{
					temp.spawn();
					temp.setOccupyingBlock(level.getLevel()[temp.getCurrentX()][temp.getCurrentY()]);
					level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
				}
				
				else if(temp.isAlive())			
				{
					if(inAir(temp))
					{
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = temp.getOccupyingBlock();
						temp.setX(temp.getCurrentX()+1);
						temp.setOccupyingBlock(level.getLevel()[temp.getCurrentX()][temp.getCurrentY()]);
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
					}
					else if(temp.getFalling() >= level.getMaxHeight())
					{
						temp.setAliveStatus(false);
						level.decrementLemmingsLeft();
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = temp.getOccupyingBlock();
					}
					else if(inExit(temp))
					{
						temp.setAliveStatus(false);
						level.decrementLemmingsLeft();
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = temp.getOccupyingBlock();
					}
					/*
					 * NOTE:
					 * When displaying, if 2 lemmings pass each other there will be a frame where 1 lemming is not visible.
					 * But he is still there and working properly.
					 */
					else if(canMove(temp))
					{
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = 'a';
						
						if(temp.facingRight()){
							temp.setY(temp.getCurrentY()+1);
						}
						else
						{
							temp.setY(temp.getCurrentY()-1);
						}
						temp.setOccupyingBlock(level.getLevel()[temp.getCurrentX()][temp.getCurrentY()]);
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
			System.out.println("Press Enter");
			keyboard.nextLine();
			time++;
		}
	}
	public boolean inAir(Lemming lemming)
	{ 
		boolean result = false;
		try {
			if (level.getLevel()[lemming.getCurrentX() + 1][lemming.getCurrentY()] == 'a') {
				result = true;
				lemming.incrementFalling();
				}
		} catch (Exception e) {
			lemming.setAliveStatus(false);
			level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY()] = lemming.getOccupyingBlock();
		}
			
		return result;
	}
	
	public boolean canMove(Lemming lemming)
	{
		boolean result = false;
		try{
			if (lemming.facingRight()){
				if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] =='a'
						|| level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] ==' ')
				{
					result = true;
				}
				else if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] == 'd')
				{
					lemming.turnAround();
				}
				else if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] == 'r')
				{
					lemming.turnAround();
				}
			}
			else{
				if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] =='a'
						|| level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] ==' ')
				{
					result = true;
				}
				else if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] == 'd')
				{
					lemming.turnAround();
				}
				else if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] == 'r')
				{
					lemming.turnAround();
				}
			}
		}
		catch (Exception e)
		{
			lemming.turnAround();
		}
		return result;
	}
	
	public boolean inExit (Lemming lemming)
	{
		boolean result = false;
		
		if(level.getExitX() == lemming.getCurrentY() && level.getExitY() == lemming.getCurrentX())
		{
			result = true;
			level.decrementLemmingsLeft();
		}
		
		return result;
	}

}
