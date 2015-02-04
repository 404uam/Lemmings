/**
 * SolutionMaker.java
 *  
 *  Is supposed to hold and contain backtracking for creating solutions
 * 
 * @author Louis Mau
 */

package lemming;

public class SolutionMaker {

		private char[][] level;
		
		public SolutionMaker(Level level)
		{
			this.level = new char[level.getHeight()][level.getWidth()];
			cloneLevel(level);
		}
		
		public void cloneLevel(Level level)
		{
			for (int c = 0; c < level.getHeight(); c++)
			{
				for(int i = 0; i < level.getWidth(); i++)
				{
					this.level[c][i] = level.getLevel()[c][i];
				}
			}
		}
		
	
}
