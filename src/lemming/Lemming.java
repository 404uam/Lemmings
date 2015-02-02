package lemming;

public class Lemming {
	private int spawnX;
	private int spawnY;
	private int spawnTime;
	private int currentX;
	private int currentY;
	private boolean alive = false;
	
		
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

}
