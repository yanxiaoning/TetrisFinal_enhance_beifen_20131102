package com.ningo.tetris.shapes;

import java.awt.Graphics;

public interface TetrisShape {
	public void draw(Graphics g);
	public void clockwiseCoorAdjust();
	public void counter_clockwiseCoorAdjust();
	public void set_coor_to_sit_0();
	public void set_coor_to_sit_15();
	public void set_coor_to_sit_30();
	public void set_coor_to_sit_45();
	
	public boolean drop();
	
	public void toLeft();
	public void toRight();
	
	
	public boolean checkDownAvailable();
	public boolean checkLeftAvailable();
	public boolean checkRightAvailable();
	public boolean checkClockWiseRotateAvailable();
	public boolean checkCounter_ClockWiseRotateAvailable();
	
	public boolean can_to_sit_0();
	public boolean can_to_sit_15();
	public boolean can_to_sit_30();
	public boolean can_to_sit_45();
	public int getStartShapeHeight();
	
	public boolean isStartFree();
	public void drawForecast(Graphics g,int rootX,int rootY);
	
	
}
