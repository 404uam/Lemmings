/**
 * SolutionChecker.java
 * 
 * No backtracking implemented. Turning in to certain skills once an obstacle is met is implemented.
 * Skills are implemented "Basher, Blocker(Can't really show without the backtracking or hard code),Digger
 * completes the level or tries to atleast.
 * 
 * @author Louis Mau
 */
package lemming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SolutionChecker {
	private Level level;
	private int time;
	private Scanner keyboard = new Scanner(System.in);
	private Queue<Solution> solutions = new LinkedList<Solution>();
	
	public SolutionChecker(Level level)
	{
		this.level = level;
		time = 0;
	}
	
	public boolean run()
	{
		boolean solution = false;
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
					if(inExit(temp))
					{
						temp.setAliveStatus(false);
						level.decrementLemmingsLeft();
						level.decrementPassLemmings();
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = temp.getOccupyingBlock();
					}
					else if(inAir(temp))
					{
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = temp.getOccupyingBlock();
						temp.setX(temp.getCurrentX()+1);
						temp.setOccupyingBlock(level.getLevel()[temp.getCurrentX()][temp.getCurrentY()]);
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
					}
					else if(diggerCheck(temp))
					{
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = 'a';
						temp.setX(temp.getCurrentX()+1);
						level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = 'D';
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
						if(temp.isBasher())
						{
							level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = 's';
						}
						else
						{
							level.getLevel()[temp.getCurrentX()][temp.getCurrentY()] = ' ';
						}
					}
				}
			}
			
			/*	NOTE
			 * The following commented out code is for printing the stage step by step
			 */
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
		
		if(level.getLemmingsLeft() > 0 )
		{
			System.out.println("No solution found");
		}
		else if(level.getPassLemming() > 0)
		{
			System.out.println("No solution found");
		}
		else
		{
			solution = true;
			System.out.println("Solution found");
			for(int i = 0; i < solutions.size(); i++)
			{
				System.out.println(solutions.remove().toString());
			}
		}
	
		return solution;
	}
	public boolean inAir(Lemming lemming)
	{ 
		boolean result = false;
		try {
			if (level.getLevel()[lemming.getCurrentX() + 1][lemming.getCurrentY()] == 'a') {
				result = true;
				}
		} catch (ArrayIndexOutOfBoundsException e) {
			lemming.setAliveStatus(false);
			level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY()] = lemming.getOccupyingBlock();
		}
			
		return result;
	}
	
	public boolean canMove(Lemming lemming)
	{
		boolean result = false;
		if(lemming.isAlive()){
		try{
			if (lemming.facingRight()){
				if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] =='a'
						|| level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] ==' ')
				{
					result = true;
				}
				else
				{
					if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() + 1] == 'd')
					{			
						if(lemming.isBasher()){
							result = true;
						}
						else if(level.getBasher() > 0)
						{
							lemming.setBasher(true);
							level.decrementBasher();
							Solution temp = new Solution(lemming.getCurrentX(),lemming.getCurrentY(),time,'s');
							result = true;
							solutions.add(temp);
						}
					}
					else{
						lemming.turnAround();
					}
				}
			}
			else{
				if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] =='a'
						|| level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] ==' ')
				{
					result = true;
				}
				else
				{
					if(level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY() - 1] == 'd')
					{			
						if(lemming.isBasher()){
							result = true;
						}
						else if(level.getBasher() > 0)
						{
							lemming.setBasher(true);
							level.decrementBasher();
							Solution temp = new Solution(lemming.getCurrentX(),lemming.getCurrentY(),time,'s');
							result = true;
							solutions.add(temp);
						}
					}
					else{
						lemming.turnAround();
					}
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			lemming.turnAround();
		}
		}
		return result;
	}
	
	public boolean inExit (Lemming lemming)
	{
		boolean result = false;
		
		if(level.getExitX() == lemming.getCurrentY() && level.getExitY() == lemming.getCurrentX())
		{
			result = true;
		}
		
		return result;
	}
	
	public boolean diggerCheck (Lemming lemming)
	{
		boolean result = false;
		try{
			if(level.getLevel()[lemming.getCurrentX() + 1][lemming.getCurrentY()] == 'd')
			{
				if(lemming.isDigger())
				{
					result = true;
				}
				else if(level.getDigger() > 0)
				{
					result = true;
					lemming.setDigger(true);
					level.decrementDigger();
					Solution temp = new Solution(lemming.getCurrentX(),lemming.getCurrentY(),time,'s');
					solutions.add(temp);
				}
			}
			else if(lemming.isDigger())
			{
				lemming.setDigger(false);
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			lemming.setAliveStatus(false);
			level.getLevel()[lemming.getCurrentX()][lemming.getCurrentY()] = 'd';
		}
		
		return result;
	}

}
