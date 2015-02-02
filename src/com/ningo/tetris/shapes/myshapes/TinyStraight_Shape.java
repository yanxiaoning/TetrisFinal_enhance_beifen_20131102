package com.ningo.tetris.shapes.myshapes;

import java.awt.Color;
import java.awt.Graphics;

import com.ningo.tetris.TetrisMainPanel;
import com.ningo.tetris.shapes.TetrisShape;

public class TinyStraight_Shape implements TetrisShape{
	private final int COOR_SIT_0 = 0;
	private final int COOR_SIT_15 = 1;
	private final int COOR_SIT_30 = 2;
	private final int COOR_SIT_45 = 3;
	
	
	private int coorSituation = 0;
	
	private int startShapeHeight = 2;
	
	private int root_X;
	private int root_Y;
	
	private int sqr_1_root_X;
	private int sqr_1_root_Y;
	private int sqr_2_root_X;
	private int sqr_2_root_Y;

	
	
	private int[] sqr1_pos_start_relative;
	private int[] sqr2_pos_start_relative;

	
	
	public TinyStraight_Shape(int root_X,int root_Y)
	{
		this.root_X = root_X;
		this.root_Y = root_Y;
		
		sqr1_pos_start_relative = new int[] {0,0};
		sqr2_pos_start_relative = new int[] {1,0};

		
		
		set_coor_to_sit_0();
	}
	
	public void draw(Graphics g)
	{
Color color = new Color(0xccffcc);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);

		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);

	
	}
	
	public void clockwiseCoorAdjust()
	{
		
		if(!checkClockWiseRotateAvailable())
			return;
		
		switch(coorSituation)
		{
		case COOR_SIT_0:
			set_coor_to_sit_15();
			coorSituation = COOR_SIT_15;
			break;
		case COOR_SIT_15:
			set_coor_to_sit_30();
			coorSituation = COOR_SIT_30;
			break;
		case COOR_SIT_30:
			set_coor_to_sit_45();
			coorSituation = COOR_SIT_45;
			break;
		case COOR_SIT_45:
			set_coor_to_sit_0();
			coorSituation = COOR_SIT_0;
			break;
		default:
			break;
		}
	}
	
	public void counter_clockwiseCoorAdjust()
	{
		if(!checkCounter_ClockWiseRotateAvailable())
			return;
		
		switch(coorSituation)
		{
		case COOR_SIT_0:
			set_coor_to_sit_45();
			coorSituation = COOR_SIT_45;
			break;
		case COOR_SIT_45:
			set_coor_to_sit_30();
			coorSituation = COOR_SIT_30;
			break;
		case COOR_SIT_30:
			set_coor_to_sit_15();
			coorSituation = COOR_SIT_15;
			break;
		case COOR_SIT_15:
			set_coor_to_sit_0();
			coorSituation = COOR_SIT_0;
			break;
			default:
				break;
		}
	}
	
	
	public void set_coor_to_sit_0()
	{
		sqr_1_root_X = root_X;
		sqr_1_root_Y = root_Y;
		
		sqr_2_root_X = root_X+TetrisMainPanel.BASIC_LENGTH;
		sqr_2_root_Y = root_Y;
		
		
		
		
		
		
	}
	
	

	public void set_coor_to_sit_15()
	{
		sqr_1_root_X = root_X;
		sqr_1_root_Y = root_Y;
		
		sqr_2_root_X = root_X;
		sqr_2_root_Y = root_Y+TetrisMainPanel.BASIC_LENGTH;
	
	
		
		
		
	}
	
	public void set_coor_to_sit_30()
	{
		sqr_1_root_X = root_X;
		sqr_1_root_Y = root_Y;
		
		sqr_2_root_X = root_X+TetrisMainPanel.BASIC_LENGTH;
		sqr_2_root_Y = root_Y;
		
		
		
		
		
		
		
	
	}
	
	public void set_coor_to_sit_45()
	{
		
		sqr_1_root_X = root_X;
		sqr_1_root_Y = root_Y;
		
		sqr_2_root_X = root_X;
		sqr_2_root_Y = root_Y+TetrisMainPanel.BASIC_LENGTH;
	
		
		
		
	}
	
	@Override
	public boolean drop() {
		// TODO Auto-generated method stub
		if(!checkDownAvailable())
		{
			
			TetrisMainPanel.latticeArray[(sqr_1_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_1_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] = 1;
			
			TetrisMainPanel.latticeArray[(sqr_2_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_2_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] = 1;
			
			
			
			
			TetrisMainPanel.accumulationMemoryMatrix[(sqr_1_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_1_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] = "TinyStraight_Shape_Color";
			TetrisMainPanel.accumulationMemoryMatrix[(sqr_2_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_2_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] = "TinyStraight_Shape_Color";
			
			
		return false;
		
		
		
		}
		root_Y = root_Y + TetrisMainPanel.BASIC_LENGTH;
		
		switch(coorSituation)
		{
		case COOR_SIT_0  :
			set_coor_to_sit_0();
			break;
		case COOR_SIT_15 :
			set_coor_to_sit_15();
			break;
		case COOR_SIT_30 :
			set_coor_to_sit_30();
			break;
		case COOR_SIT_45 :
			set_coor_to_sit_45();
			break;
		}
		
		return true;
		
	}

	@Override
	public void toLeft() {
		// TODO Auto-generated method stub
		
		if(!checkLeftAvailable())
			return;
		
		root_X = root_X - TetrisMainPanel.BASIC_LENGTH;
		
		switch(coorSituation)
		{
		case COOR_SIT_0  :
			set_coor_to_sit_0();
			break;
		case COOR_SIT_15 :
			set_coor_to_sit_15();
			break;
		case COOR_SIT_30 :
			set_coor_to_sit_30();
			break;
		case COOR_SIT_45 :
			set_coor_to_sit_45();
			break;
		}
	}

	@Override
	public void toRight() {
		// TODO Auto-generated method stub
		
		if(!checkRightAvailable())
			return;
		
		root_X = root_X + TetrisMainPanel.BASIC_LENGTH;
		
		switch(coorSituation)
		{
		case COOR_SIT_0  :
			set_coor_to_sit_0();
			break;
		case COOR_SIT_15 :
			set_coor_to_sit_15();
			break;
		case COOR_SIT_30 :
			set_coor_to_sit_30();
			break;
		case COOR_SIT_45 :
			set_coor_to_sit_45();
			break;
		}
		
	}



	@Override
	public boolean checkDownAvailable() {
		// TODO Auto-generated method stub
		
		
		
		//TetrisMainPanel.BasicGraphicArray 
		
		if(sqr_1_root_Y +TetrisMainPanel.BASIC_LENGTH == TetrisMainPanel.BOTTOM_BORDER_Y|| sqr_2_root_Y +TetrisMainPanel.BASIC_LENGTH == TetrisMainPanel.BOTTOM_BORDER_Y)
		return false;
		
		
		if(TetrisMainPanel.latticeArray[(sqr_1_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_1_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH + 1] == 1 || TetrisMainPanel.latticeArray[(sqr_2_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(sqr_2_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH + 1] == 1 )
			return false;
		
		
		
		return true;
	}

	@Override
	public boolean checkLeftAvailable() {
		// TODO Auto-generated method stub
		
		
		if(sqr_1_root_X == TetrisMainPanel.LEFT_BORDER_X|| sqr_2_root_X == TetrisMainPanel.LEFT_BORDER_X)
			return false;
		
		
		if(TetrisMainPanel.latticeArray[(sqr_1_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH - 1][(sqr_1_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1 || TetrisMainPanel.latticeArray[(sqr_2_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH - 1][(sqr_2_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1 )
			return false;
		
			
		
		return true;
	}

	@Override
	public boolean checkRightAvailable() {
		// TODO Auto-generated method stub
		if(sqr_1_root_X +TetrisMainPanel.BASIC_LENGTH == TetrisMainPanel.RIGHT_BORDER_X|| sqr_2_root_X +TetrisMainPanel.BASIC_LENGTH == TetrisMainPanel.RIGHT_BORDER_X)
			return false;
		
		
		if(TetrisMainPanel.latticeArray[(sqr_1_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH + 1][(sqr_1_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1 || TetrisMainPanel.latticeArray[(sqr_2_root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH + 1][(sqr_2_root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1 )
			return false;
		
		
		
		return true;
	}

	@Override
	public boolean checkClockWiseRotateAvailable() {
		// TODO Auto-generated method stub
		
		
		switch(coorSituation)
		{
		case COOR_SIT_0  :
			return can_to_sit_15();
		case COOR_SIT_15 :
			return can_to_sit_30();
		case COOR_SIT_30 :
			return can_to_sit_45();
		case COOR_SIT_45 :
			return can_to_sit_0();
		}
		
		return false;
		
	}

	@Override
	public boolean checkCounter_ClockWiseRotateAvailable() {
		// TODO Auto-generated method stub
		switch(coorSituation)
		{
		case COOR_SIT_0  :
			return can_to_sit_45();
		case COOR_SIT_15 :
			return can_to_sit_0();
		case COOR_SIT_30 :
			return can_to_sit_15();
		case COOR_SIT_45 :
			return can_to_sit_30();
		}
		
		return false;
	}

	@Override
	public boolean can_to_sit_0() {
		// TODO Auto-generated method stub
		
		
		
		
		if(root_X < TetrisMainPanel.ZERO_X || root_X+TetrisMainPanel.BASIC_LENGTH >  TetrisMainPanel.RIGHT_BORDER_X - TetrisMainPanel.BASIC_LENGTH || root_Y > TetrisMainPanel.BOTTOM_BORDER_Y - TetrisMainPanel.BASIC_LENGTH)
			return false;
		
		 if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
				if(TetrisMainPanel.latticeArray[(root_X + TetrisMainPanel.BASIC_LENGTH  - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
			
				
				
				
				return true;
	}

	@Override
	public boolean can_to_sit_15() {
		// TODO Auto-generated method stub
		/*
	    if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
		return false;
		
		if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
		return false;
		
		if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
		return false;
		
		if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
		return false;
		 * 
		 * */
		
		
		
		if(root_X < TetrisMainPanel.ZERO_X|| root_X >  TetrisMainPanel.RIGHT_BORDER_X - TetrisMainPanel.BASIC_LENGTH || root_Y+TetrisMainPanel.BASIC_LENGTH > TetrisMainPanel.BOTTOM_BORDER_Y - TetrisMainPanel.BASIC_LENGTH)
			return false;
		
		 if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
				if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y + TetrisMainPanel.BASIC_LENGTH - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
			
		
			
			
			
			return true;
		
		
	}

	@Override
	public boolean can_to_sit_30() {
		// TODO Auto-generated method stub
		if(root_X < TetrisMainPanel.ZERO_X || root_X+TetrisMainPanel.BASIC_LENGTH >  TetrisMainPanel.RIGHT_BORDER_X - TetrisMainPanel.BASIC_LENGTH || root_Y > TetrisMainPanel.BOTTOM_BORDER_Y - TetrisMainPanel.BASIC_LENGTH)
			return false;
		
		 if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
				if(TetrisMainPanel.latticeArray[(root_X + TetrisMainPanel.BASIC_LENGTH  - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
			
				
				
				
				return true;
	}

	@Override
	public boolean can_to_sit_45() {
		// TODO Auto-generated method stub
		if(root_X < TetrisMainPanel.ZERO_X|| root_X >  TetrisMainPanel.RIGHT_BORDER_X - TetrisMainPanel.BASIC_LENGTH || root_Y+TetrisMainPanel.BASIC_LENGTH > TetrisMainPanel.BOTTOM_BORDER_Y - TetrisMainPanel.BASIC_LENGTH)
			return false;
		
		 if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
				
				if(TetrisMainPanel.latticeArray[(root_X - TetrisMainPanel.ZERO_X)/TetrisMainPanel.BASIC_LENGTH][(root_Y + TetrisMainPanel.BASIC_LENGTH - TetrisMainPanel.ZERO_Y)/TetrisMainPanel.BASIC_LENGTH] == 1)
				return false;
			
		
			
			
			
			return true;
		
	}

	

	

	
	@Override
	public void drawForecast(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+TetrisMainPanel.BASIC_LENGTH;
		int sqr_2_root_Y = root_Y;
		
		
			
			
		
		
		
Color color = new Color(0xccffcc);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
	
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, TetrisMainPanel.BASIC_LENGTH, TetrisMainPanel.BASIC_LENGTH);
	
		
			
	}
	
	
	@Override
	public int getStartShapeHeight() {
		// TODO Auto-generated method stub
		return startShapeHeight;
	}
	
	
	
	@Override
	public boolean isStartFree(){
		
		boolean judge1 = TetrisMainPanel.latticeArray[TetrisMainPanel.I_SHAPE_START_POS_X + sqr1_pos_start_relative[0]][sqr1_pos_start_relative[1]] == 0;
		boolean judge2 = TetrisMainPanel.latticeArray[TetrisMainPanel.I_SHAPE_START_POS_X + sqr2_pos_start_relative[0]][sqr2_pos_start_relative[1]] == 0;
		
		return judge1&&judge2;
	}
	
}
