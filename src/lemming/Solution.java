/**
 * Solution.java
 * 
 * Container class to hold solution info
 * 
 * @author Louis
 */

package lemming;

public class Solution {
	
	private int x;
	private int y;
	private int time;
	private char skill;
	
	public Solution(int x, int y, int time, char skill)
	{
		this.x = x;
		this.y = y;
		this.time = time;
		this.skill = skill;
	}
	
	public String toString()
	{
		return x +" "+ y +" "+ time +" "+ skill;
	}
}
