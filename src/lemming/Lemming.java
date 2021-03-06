/**
 * Lemming.java
 * 
 * Container class for each lemming.
 * @author Louis Mau
 */
package lemming;

public class Lemming {
	private int spawnX;
	private int spawnY;
	private int spawnTime;
	private int currentX;
	private int currentY;
	private boolean alive = false;
	private char occupyingBlock;
	private boolean facingRight = true;
	private boolean basher = false;
	private boolean blocker = false;
	private boolean digger = false;
	
	public Lemming()
	{	
	}
	
	public void spawn()
	{
		currentX = spawnX;
		currentY = spawnY;
		alive = true;
	}
	
	public void setSpawnX(int x) {
		this.spawnX = x;
	}

	public void setSpawnY(int y) {
		this.spawnY = y;
	}

	public void setTime(int time) {
		this.spawnTime = time;
	}
	
	public int getTime(){
		return spawnTime;
	}
	
	public int getCurrentX()
	{
		return currentX;
	}
	
	public int getCurrentY()
	{
		return currentY;
	}
	
	public void setX(int x)
	{
		currentX = x;
	}
	
	public void setY(int y)
	{
		currentY = y;
	}
	
	public boolean isAlive()
	{
		return alive;
	}
	
	public void setAliveStatus(boolean status)
	{
		alive = status;
	}
	
	public void setOccupyingBlock(char block)
	{
		this.occupyingBlock = block;
	}
	
	public char getOccupyingBlock()
	{
		return occupyingBlock;
	}
	
	public void turnAround()
	{
		facingRight = !facingRight;
	}
	
	public boolean facingRight()
	{
		return facingRight;
	}
	
	public boolean isBasher()
	{
		return basher;
	}
	
	public boolean isBlocker()
	{
		return blocker;
	}
	
	public boolean isDigger()
	{
		return digger;
	}
	
	public void setBasher(boolean basher)
	{
		this.basher = basher;
	}
	
	public void setBlocker(boolean blocker)
	{
		this.blocker = blocker;
	}
	
	public void setDigger(boolean digger)
	{
		this.digger = digger;
	}
}
