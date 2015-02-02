package com.ningo.tetris;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.ningo.tetris.shapes.I_Shape;
import com.ningo.tetris.shapes.L_Shape;
import com.ningo.tetris.shapes.L_Shape_Reversal;
import com.ningo.tetris.shapes.RegularShape;
import com.ningo.tetris.shapes.S_Shape;
import com.ningo.tetris.shapes.S_Shape_Reversal;
import com.ningo.tetris.shapes.T_Shape;
import com.ningo.tetris.shapes.TetrisShape;
import com.ningo.tetris.shapes.myshapes.Dot_Shape;
import com.ningo.tetris.shapes.myshapes.Slope_Shape;
import com.ningo.tetris.shapes.myshapes.SmallL_Shape;
import com.ningo.tetris.shapes.myshapes.SmallS_Shape;
import com.ningo.tetris.shapes.myshapes.Straight_Shape;
import com.ningo.tetris.shapes.myshapes.TinyStraight_Shape;
import com.ningo.tetris.shapes.myshapes.V_Shape;
import com.ningo.tetris.shapes.myshapes.WierdL_Shape;

public class TetrisMainPanel extends JPanel{
	
	
	private static final int TOTAL_SHAPE_KIND_AMOUNT = 8;
	private static  int M;
	private static  int N;
	private static  double S;
	private static  int oringinalRest;
	
	private boolean []selected;
	
	private int score;
	private int line;
	private int level;
	private double speed;
	
	private boolean isGameOver = false;
	
	public static int[][] latticeArray;
			
	private JPanel mPanel = this;
	
	private boolean isOnQuit = false;
	
	private TetrisShape shape;
	//private List<TetrisShape> accumulationMemoryList;
	
	public static String[][] accumulationMemoryMatrix;
	
	private ArrayList<String> myShapeList ;
	private TetrisShape forecastShape;
	
	private int WIDTH_AMOUNT;
	private int HEIGHT_AMOUNT;
	
	public static   int BASIC_LENGTH;

	public static   int ZERO_X;
	public static  int ZERO_Y;

	private   int MAIN_PANEL_WIDTH;
	private   int MAIN_PANEL_HEIGHT;
	
	public static  int LEFT_BORDER_X;
	public static  int RIGHT_BORDER_X;
	public static  int BOTTOM_BORDER_Y;
	
	private   int QUIT_RECT_ORIGINAL_X;
	private   int QUIT_RECT_ORIGINAL_Y;
	
	private   int QUIT_STR_ORIGIN_X;
	private   int QUIT_STR_ORIGIN_Y;
	
	
	private   int PAUSE_RECT_ORIGINAL_X;
	private   int PAUSE_RECT_ORIGINAL_Y;
	
	private   int PAUSE_STR_ORIGIN_X;
	private   int PAUSE_STR_ORIGIN_Y;

	private Timer timer;

	private boolean isPause;
	private Timer timerCheckTimer;
	protected boolean isNewClockGoingToStart = false;

	public static int I_SHAPE_START_POS_X;

	public static int NOT_I_SHAPE_START_POS_X;
	public TetrisMainPanel(int BASIC_LENGTH,int WIDTH_AMOUNT,int HEIGHT_AMOUNT,int M_out,int N_out,double S_out,boolean []selected)
	{
		
		M = M_out;
		N = N_out;
		S = S_out;
		this.selected = selected;
		oringinalRest = 400;
		
		
		score = 0;
		line  = 0;
		level = 1;
		speed = 1.0;
		
		TetrisMainPanel.BASIC_LENGTH = BASIC_LENGTH;
		
		this.WIDTH_AMOUNT = WIDTH_AMOUNT;
		
		this.HEIGHT_AMOUNT = HEIGHT_AMOUNT;
		
		MAIN_PANEL_WIDTH = WIDTH_AMOUNT * BASIC_LENGTH;
		MAIN_PANEL_HEIGHT = HEIGHT_AMOUNT * BASIC_LENGTH;
		
		ZERO_X = BASIC_LENGTH;
		ZERO_Y = BASIC_LENGTH;
		
		LEFT_BORDER_X = ZERO_X;
		RIGHT_BORDER_X = ZERO_X + MAIN_PANEL_WIDTH;
		BOTTOM_BORDER_Y = ZERO_Y + MAIN_PANEL_HEIGHT;
		
		QUIT_RECT_ORIGINAL_X = ZERO_X+MAIN_PANEL_WIDTH+25+100;
		QUIT_RECT_ORIGINAL_Y = ZERO_Y+MAIN_PANEL_HEIGHT-15;
		QUIT_STR_ORIGIN_X = ZERO_X+MAIN_PANEL_WIDTH+45+100;
		QUIT_STR_ORIGIN_Y = ZERO_Y+MAIN_PANEL_HEIGHT+20;
		PAUSE_RECT_ORIGINAL_X = ZERO_X+MAIN_PANEL_WIDTH/2-70-10;
		PAUSE_RECT_ORIGINAL_Y = ZERO_Y+MAIN_PANEL_HEIGHT/2-50;
		PAUSE_STR_ORIGIN_X = ZERO_X+MAIN_PANEL_WIDTH/2-35-10;
		PAUSE_STR_ORIGIN_Y = ZERO_Y+MAIN_PANEL_HEIGHT/2-3;
		
		
		TetrisMainPanel.I_SHAPE_START_POS_X = (WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 2;
		TetrisMainPanel.NOT_I_SHAPE_START_POS_X = (WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1;
		
		
		accumulationMemoryMatrix = new String[WIDTH_AMOUNT][HEIGHT_AMOUNT];
		for(int i = 0;i < WIDTH_AMOUNT;i++)
			for(int j = 0;j < HEIGHT_AMOUNT;j++)
				accumulationMemoryMatrix[i][j] = "null";
		
		myShapeList = new ArrayList<String>();
		myShapeList.add("I_Shape");
		myShapeList.add("L_Shape_Reversal");
		myShapeList.add("L_Shape");
		myShapeList.add("RegularShape");
		myShapeList.add("S_Shape_Reversal");
		myShapeList.add("S_Shape");
		myShapeList.add("T_Shape");

		 for(int i = 0;i < 8;i ++)
			 if(selected[i])
			 {
				 switch(i)
				 {
				 case 0: myShapeList.add("Dot_Shape");break;
				 case 1: myShapeList.add("Slope_Shape");break;
				 case 2: myShapeList.add("SmallL_Shape");break;
				 case 3: myShapeList.add("SmallS_Shape");break;
				 case 4: myShapeList.add("Straight_Shape");break;
				 case 5: myShapeList.add("TinyStraight_Shape");break;
				 case 6: myShapeList.add("V_Shape");break;
				 case 7: myShapeList.add("WierdL_Shape");break;
				 
				 
				 }
			 }
		 
		 
		forecastShape  = generateRandomShape();
		shape = forecastShape;
		
		forecastShape = generateRandomShape();
		
		latticeArray = new int[WIDTH_AMOUNT][HEIGHT_AMOUNT];
		for(int i = 0;i < WIDTH_AMOUNT;i++)
			for(int j = 0;j < HEIGHT_AMOUNT;j++)
		latticeArray[i][j] = 0;
		
		
		 
		 
		 
		this.addMouseListener(new MouseAdapter(){
			public void  mouseClicked(MouseEvent e) 
			{
				if(e.getX() > QUIT_RECT_ORIGINAL_X &&e.getX()< QUIT_RECT_ORIGINAL_X+100 && e.getY() > QUIT_RECT_ORIGINAL_Y && e.getY() < QUIT_RECT_ORIGINAL_Y+50)
			System.exit(ABORT); 
				
				else if(!(e.getX()>ZERO_X&&e.getX()<ZERO_X+MAIN_PANEL_WIDTH&&e.getY()>ZERO_Y&&e.getY()<ZERO_Y+MAIN_PANEL_HEIGHT))
				{
				
				 if(e.getButton() == MouseEvent.BUTTON1)
				{
					
					shape.toLeft();
					repaint();
				}
				else if(e.getButton() == MouseEvent.BUTTON3)
				{
					
					shape.toRight();
					repaint();
				}
				 
				 
				}
			}
		});
		
		
		this.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e)
			{
				if(e.getX()>ZERO_X&&e.getX()<ZERO_X+MAIN_PANEL_WIDTH&&e.getY()>ZERO_Y&&e.getY()<ZERO_Y+MAIN_PANEL_HEIGHT)
				{
					isPause = true;
					
					
					
					mPanel.repaint();
					
				}
				else
				{
					isPause = false;
					
					mPanel.repaint();
					
				}
				
				
				if(e.getX() > QUIT_RECT_ORIGINAL_X &&e.getX()< QUIT_RECT_ORIGINAL_X+100 && e.getY() > QUIT_RECT_ORIGINAL_Y && e.getY() < QUIT_RECT_ORIGINAL_Y+50)
				{
					isOnQuit = true;
					
					mPanel.repaint();
					
				}
				else
				{
					isOnQuit = false;
					
					mPanel.repaint();
					
				}
			}
		});
		
		this.addMouseWheelListener(new MouseWheelListener(){
			

public void mouseWheelMoved(MouseWheelEvent e) {
	if(!(e.getX()>ZERO_X&&e.getX()<ZERO_X+MAIN_PANEL_WIDTH&&e.getY()>ZERO_Y&&e.getY()<ZERO_Y+MAIN_PANEL_HEIGHT)){
	int count = e.getWheelRotation();
	if(count > 0)
	{
		
		shape.counter_clockwiseCoorAdjust();
		
		
		
    	
    	repaint();
	}
	else if((count < 0))
	{
		
		shape.clockwiseCoorAdjust();
		repaint();
		
	}

	}
		}
		});
		
		isPause = false;
		
		timer = new Timer();
        timer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(!isPause)
				{
				boolean canDrop = shape.drop();
		    	
		    	if(!canDrop)   	
		    	{
		    		/*??????????????????*/
		    		
		    		
		    		
		    		
		    		
		    		shape = forecastShape;
		    		if(!shape.isStartFree())
		    		{
		    			isGameOver = true;
		    			repaint();
		    			this.cancel();
		    			return;
		    		}
		    		
		    		forecastShape  = generateRandomShape();
		    		
		    		
		    		
		    		
		    	//////////////////////////20131009do	
		    		boolean isAborbingHappened = false;
		    		for(int i = 0;i < latticeArray[0].length;i++)
		    		{
		    			boolean judgeAllOne = true;
		    			for(int j = 0;j < latticeArray.length;j++)
		    				if(latticeArray[j][i] == 1)
		    					judgeAllOne = judgeAllOne && true;
		    				else
		    					judgeAllOne = judgeAllOne && false;
		    			
		    			if(judgeAllOne)
		    			{
		    				for(int j = 0;j < latticeArray.length;j++)
		    				{
		    					latticeArray[j][i] = 0;
		    					accumulationMemoryMatrix[j][i] = "null";
		    				}
		    				
		    				isAborbingHappened = true;
		    				line ++;
		    				if(line == N)
		    				{
		    					line = 0;
		    			
		    			speed = speed*(1 + S * level);
		    			
		    					level++;
		    					this.cancel();
		    					isNewClockGoingToStart  = true;
		    					
		    				}
		    				score = score + M * level;
		    				
		    				
		    				
		    			}
		    				
		    		}
		    		
		    		
		    		if(isAborbingHappened)
		    		{
		    			for(int i = 0;i < latticeArray[0].length;i++)
		    			{
		    				
		    				boolean judgeAllZero = true;
		    				
		    				for(int j = 0;j < latticeArray.length;j++)
		    				{
		    					if(latticeArray[j][i] == 1)
		    						judgeAllZero = judgeAllZero && false;
		    						else
		    						judgeAllZero = judgeAllZero && true;
		    					
		    					
		    				}
		    				
		    				if(judgeAllZero && i > 0)
		    				{
		    					for(int j = i - 1;j >= 0;j--)
		    					{
		    						
		    						for(int k = 0;k < latticeArray.length;k++)
		    						{
		    							latticeArray[k][j+1] = latticeArray[k][j];
		    							accumulationMemoryMatrix[k][j+1] = accumulationMemoryMatrix[k][j];
		    							
		    						}
		    						
		    					}
		    					
		    					for(int j = 0;j < latticeArray.length;j++)
		    					{
		    					latticeArray[j][0] = 0;
		    					accumulationMemoryMatrix[j][0] = "null";
		    					}
		    				}
		    			}
		    		}
		    		
		    		
		    		repaint();
		    	
		    	}
		    	
		    	repaint();
				}
			}
        	
        	
        	
        }, 0, oringinalRest);//
        
        timerCheckTimer = new Timer();
        timerCheckTimer.scheduleAtFixedRate(new TimerTask(){
        	public void run(){
        		if(isNewClockGoingToStart)
        		{
        			 timer.schedule(new TimerTask(){

        					@Override
        					public void run() {
        						isNewClockGoingToStart = false;
        						// TODO Auto-generated method stub
        						
        						if(!isPause)
        						{
        						boolean canDrop = shape.drop();
        				    	
        				    	if(!canDrop)   	
        				    	{
        				    		/*??????????????????*/
        				    		
        				    		
        				    		
        				    		
        				    		
        				    		shape = forecastShape;
        				    		if(!shape.isStartFree())
        				    		{
        				    			isGameOver = true;
        				    			repaint();
        				    			this.cancel();
        				    			return;
        				    		}
        				    		
        				    		forecastShape  = generateRandomShape();
        				    		
        				    		
        				    		
        				    		
        				    	//////////////////////////20131009do	
        				    		boolean isAborbingHappened = false;
        				    		for(int i = 0;i < latticeArray[0].length;i++)
        				    		{
        				    			boolean judgeAllOne = true;
        				    			for(int j = 0;j < latticeArray.length;j++)
        				    				if(latticeArray[j][i] == 1)
        				    					judgeAllOne = judgeAllOne && true;
        				    				else
        				    					judgeAllOne = judgeAllOne && false;
        				    			
        				    			if(judgeAllOne)
        				    			{
        				    				for(int j = 0;j < latticeArray.length;j++)
        				    				{
        				    					latticeArray[j][i] = 0;
        				    					accumulationMemoryMatrix[j][i] = "null";
        				    				}
        				    				
        				    				isAborbingHappened = true;
        				    				line ++;
        				    				if(line == 20)
        				    				{
        				    					line = 0;
        				    			
        				    			speed = speed*(1 + S * level);
        				    			
        				    					level++;
        				    					this.cancel();
        				    					isNewClockGoingToStart  = true;
        				    					
        				    				}
        				    				score = score + M * level;
        				    				
        				    				
        				    				
        				    			}
        				    				
        				    		}
        				    		
        				    		
        				    		if(isAborbingHappened)
        				    		{
        				    			for(int i = 0;i < latticeArray[0].length;i++)
        				    			{
        				    				
        				    				boolean judgeAllZero = true;
        				    				
        				    				for(int j = 0;j < latticeArray.length;j++)
        				    				{
        				    					if(latticeArray[j][i] == 1)
        				    						judgeAllZero = judgeAllZero && false;
        				    						else
        				    						judgeAllZero = judgeAllZero && true;
        				    					
        				    					
        				    				}
        				    				
        				    				if(judgeAllZero && i > 0)
        				    				{
        				    					for(int j = i - 1;j >= 0;j--)
        				    					{
        				    						
        				    						for(int k = 0;k < latticeArray.length;k++)
        				    						{
        				    							latticeArray[k][j+1] = latticeArray[k][j];
        				    							accumulationMemoryMatrix[k][j+1] = accumulationMemoryMatrix[k][j];
        				    							
        				    						}
        				    						
        				    					}
        				    					
        				    					for(int j = 0;j < latticeArray.length;j++)
        				    					{
        				    					latticeArray[j][0] = 0;
        				    					accumulationMemoryMatrix[j][0] = "null";
        				    					}
        				    				}
        				    			}
        				    		}
        				    		
        				    		
        				    		repaint();
        				    	
        				    	}
        				    	
        				    	repaint();
        						}
        					}
        		        	
        		        	
        		        	
        		        }, 0, oringinalRest/(int)speed);//
        		}
        	}
        }, 0, 1);
		
        
       
        
	}
	
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		
		
		
		
		g.drawRect(ZERO_X, ZERO_Y, MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT);
		g.drawRect(RIGHT_BORDER_X + BASIC_LENGTH , ZERO_Y, 6 * BASIC_LENGTH, 4 * BASIC_LENGTH);
		
		    g.setColor(Color.BLACK);
		    Font font0 = new Font("font0",Font.BOLD,BASIC_LENGTH);
			g.setFont(font0);
			g.drawString("LEVEL:        "+String.valueOf(level), RIGHT_BORDER_X + 60, 4 * BASIC_LENGTH+BASIC_LENGTH*5);
			g.drawString("LINES:         "+String.valueOf(line), RIGHT_BORDER_X + 60, 4 * BASIC_LENGTH+BASIC_LENGTH/2*15);
			g.drawString("SCORE:       "+String.valueOf(score), RIGHT_BORDER_X + 60, 4 * BASIC_LENGTH+BASIC_LENGTH*10);
			
			

//////////////////////////////////////////////
			
			/*
			 * 
			 * 
			 * set color accumulation
			 * 
			 * 
			 * 
			 * 
			 * 
			 */
			
			
		//	 Color c = g.getColor();
			setColorAccumulation(g);
			
		//	g.setColor(c);
			
			
			
			///////////////////////////////////////
			
			shape.draw(g);
			forecastShape.drawForecast(g,RIGHT_BORDER_X + BASIC_LENGTH,ZERO_Y);
			
			
		if(isPause == false)
		{
			
		
		
		
		
		
		
        Font font = new Font("font1",Font.BOLD,25);
		
		g.setColor(Color.BLACK);
		
		g.setFont(font);
		g.drawString("QUIT", QUIT_STR_ORIGIN_X, QUIT_STR_ORIGIN_Y);

		g.drawRect( QUIT_RECT_ORIGINAL_X, QUIT_RECT_ORIGINAL_Y, 100, 50);
	}
		else
		{
			
			
		
			
			
			
		
			
			
			
			
			
			
			
			g.setColor(Color.BLUE);
			Font font2 = new Font("font2",Font.BOLD,30);
			g.setFont(font2);
			g.drawString("PAUSE", PAUSE_STR_ORIGIN_X, PAUSE_STR_ORIGIN_Y);
			g.drawRect( PAUSE_RECT_ORIGINAL_X, PAUSE_RECT_ORIGINAL_Y, 170, 70);
			
			Font font = new Font("font1",Font.BOLD,25);
			
			g.setColor(Color.BLACK);
			
			g.setFont(font);
			g.drawString("QUIT", QUIT_STR_ORIGIN_X, QUIT_STR_ORIGIN_Y);

			g.drawRect( QUIT_RECT_ORIGINAL_X, QUIT_RECT_ORIGINAL_Y, 100, 50);
		}
		
		
		if(isOnQuit == true)
		{
			
		
		
		
		
		
		
		
		
        Font font = new Font("font1",Font.BOLD,25);
		
		
		
		g.setFont(font);
		g.setColor(Color.RED);
		g.fillRect(QUIT_RECT_ORIGINAL_X, QUIT_RECT_ORIGINAL_Y, 100, 50);
		g.setColor(Color.BLACK);
		g.drawString("QUIT", QUIT_STR_ORIGIN_X, QUIT_STR_ORIGIN_Y);

		g.drawRect( QUIT_RECT_ORIGINAL_X, QUIT_RECT_ORIGINAL_Y, 100, 50);
	}
		else
		{
			
			
		
			
			
			
			
			
			Font font = new Font("font1",Font.BOLD,25);
			
			g.setColor(Color.BLACK);
			
			g.setFont(font);
			g.drawString("QUIT", QUIT_STR_ORIGIN_X, QUIT_STR_ORIGIN_Y);

			g.drawRect( QUIT_RECT_ORIGINAL_X, QUIT_RECT_ORIGINAL_Y, 100, 50);
		}
		
		
		if(isGameOver)
		{
			g.setColor(Color.RED);
			Font font2 = new Font("font2",Font.BOLD,30);
			g.setFont(font2);
			g.drawString("OVER!", PAUSE_STR_ORIGIN_X, PAUSE_STR_ORIGIN_Y);
			g.drawRect( PAUSE_RECT_ORIGINAL_X, PAUSE_RECT_ORIGINAL_Y, 170, 70);
		}
	}
	
	private TetrisShape generateRandomShape()
	{
		/*
		Random random = new Random();
		int randomNember = Math.abs(random.nextInt());
		
		return myShapeList.get(randomNember%myShapeList.size());
		
		
		*/
		

		
		
		 Random random = new Random();
			int randomNember = Math.abs(random.nextInt());
			
			switch(myShapeList.get(Math.abs(randomNember)%myShapeList.size()))
			{
			case "I_Shape":return new I_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 2),ZERO_Y);
			case "L_Shape_Reversal":return new L_Shape_Reversal(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y); 
			case "L_Shape":return new L_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y); 
			case "RegularShape":return new RegularShape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y); 
			case "S_Shape_Reversal":return new S_Shape_Reversal(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y); 
			case "S_Shape":return new S_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "T_Shape":return new T_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y); 
			case "Dot_Shape":return new Dot_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 2),ZERO_Y);
			case "Slope_Shape":return new Slope_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "SmallL_Shape":return new SmallL_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2),ZERO_Y);
			case "SmallS_Shape":return new SmallS_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "Straight_Shape":return new Straight_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "TinyStraight_Shape":return new TinyStraight_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "V_Shape":return new V_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
			case "WierdL_Shape":return new WierdL_Shape(ZERO_X+TetrisMainPanel.BASIC_LENGTH*((WIDTH_AMOUNT - (WIDTH_AMOUNT%2))/2 - 1),ZERO_Y);
		
				
			}
			
			return null;
		 
		
	}
	
	
	public void setColorAccumulation(Graphics g)
	{
		for(int i = 0;i < WIDTH_AMOUNT;i++)
			for(int j = 0;j < HEIGHT_AMOUNT;j++)
			{
				
				
				
				if(accumulationMemoryMatrix[i][j]=="RED")
				{
					g.setColor(new Color(0xFF0000));
					g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
					g.setColor(new Color(0x000000));
				    g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				}    
				else	if(accumulationMemoryMatrix[i][j]=="DEEPBLUE")
				{
					g.setColor(new Color(0x0066CC));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				}
				else	if(accumulationMemoryMatrix[i][j]=="LIGHTBLUE")
				{
					g.setColor(new Color(0x00CCCC));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				}
				else	if(accumulationMemoryMatrix[i][j]=="GREEN")
				{
					g.setColor(new Color(0x009900));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				}
				else	if(accumulationMemoryMatrix[i][j]=="ORANGE")
				{
					g.setColor(new Color(0xFF9900));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				}
				else	if(accumulationMemoryMatrix[i][j]=="YELLOW")
				{
				
				g.setColor(new Color(0xFFFF00));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				
				}
				
			   
				else	if(accumulationMemoryMatrix[i][j]=="PURPLE")
				{
					
				g.setColor(new Color(0x660099));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="Dot_Shape_Color")
				{
					
				g.setColor(new Color(0x333399));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="Slope_Shape_Color")
				{
					
				g.setColor(new Color(0x3399cc));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="SmallL_Shape_Color")
				{
					
				g.setColor(new Color(0xa0a0a0));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="SmallS_Shape_Color")
				{
					
				g.setColor(new Color(0xcc6600));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="Straight_Shape_Color")
				{
					
				g.setColor(new Color(0xcc6699));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="TinyStraight_Shape_Color")
				{
					
				g.setColor(new Color(0xccffcc));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="V_Shape_Color")
				{
					
				g.setColor(new Color(0x999966));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				else	if(accumulationMemoryMatrix[i][j]=="WierdL_Shape_Color")
				{
					
				g.setColor(new Color(0x66FF00));
				g.fillRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
				g.setColor(new Color(0x000000));
				g.drawRect(ZERO_X + i*BASIC_LENGTH, ZERO_Y + j*BASIC_LENGTH, BASIC_LENGTH, BASIC_LENGTH);
			    
				}
				
				
			}
	}
}
