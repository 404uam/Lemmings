package lemming;

import java.util.*;

public class Level {
	
	private int maxHeight;
	private int timeLimit;
	private int passLemming;
	private int amountOfLemmings;
	private int width;
	private int height;
	private char[][] level;
	private int exitX;
	private int exitY;
	private int blocker;
	private int basher;
	private int digger;
	
	private ArrayList<Lemming> lemmings = new ArrayList<Lemming>();
	
	public Level()
	{
		
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public int getPassLemming() {
		return passLemming;
	}

	public void setPassLemming(int passLemming) {
		this.passLemming = passLemming;
	}

	public int getAmountOfLemmings() {
		return amountOfLemmings;
	}

	public void setAmountOfLemmings(int amountOfLemmings) {
		this.amountOfLemmings = amountOfLemmings;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getHeight()
	{
		return height;
	}

	public char[][] getLevel() {
		return level;
	}

	public void setLevel(char[][] level) {
		this.level = level;
	}

	public int getExitX() {
		return exitX;
	}

	public void setExitX(int exitX) {
		this.exitX = exitX;
	}

	public int getExitY() {
		return (height - exitY)-1;
	}

	public void setExitY(int exitY) {
		this.exitY = exitY;
	}

	public int getBlocker() {
		return blocker;
	}

	public void setBlocker(int blocker) {
		this.blocker = blocker;
	}

	public int getBasher() {
		return basher;
	}

	public void setBasher(int basher) {
		this.basher = basher;
	}

	public int getDigger() {
		return digger;
	}

	public void setDigger(int digger) {
		this.digger = digger;
	}
	
	public ArrayList<Lemming> getLemmings()
	{
		return lemmings;
	}
	
	
}
