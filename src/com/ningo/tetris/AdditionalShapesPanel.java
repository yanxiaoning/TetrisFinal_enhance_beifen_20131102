package com.ningo.tetris;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdditionalShapesPanel extends JPanel{
	private final int size = 40;
	private static boolean[] selected;
	
	private static int M;
	private static int N;
	private static double S;
	private static int width;
	private static int height;
	private static int sqrSize;
	
	public AdditionalShapesPanel(int M,int N,double S,int width,int height,int sqrSize)
	{
		//repaint();
		AdditionalShapesPanel.M = M;
		AdditionalShapesPanel.N = N;
		AdditionalShapesPanel.S = S;
		AdditionalShapesPanel.width = width;
		AdditionalShapesPanel.height = height;
		AdditionalShapesPanel.sqrSize = sqrSize;
		
		
		selected = new boolean[8];
		for(int i = 0;i < 8;i++)
			selected[i] = false;
		
		

		this.addMouseListener(new MouseAdapter(){
			public void  mouseClicked(MouseEvent e) 
			{
				if(!(e.getX()<600 && e.getX()>500 && e.getY() < 600 && e.getY() > 550))
				{
			if((e.getX() < size*4) && (e.getX() > size))
				{
					if((e.getY() < size*4) && (e.getY() > size))
						{selected[0] = true;System.out.println("selected[0] = true");}
					else if((e.getY() < size*10) && (e.getY() > size*7))
						{selected[4] = true;System.out.println("selected[5] = true");}
				}
			else if((e.getX() < size*8) && (e.getX() > size*5))
				{
				if((e.getY() < size*4) && (e.getY() > size))
					selected[1] = true;
				else if((e.getY() < size*10) && (e.getY() > size*7))
					selected[5] = true;
				}
			else if((e.getX() < size*12) && (e.getX() > size*9))
				{
				if((e.getY() < size*4) && (e.getY() > size))
					selected[2] = true;
				else if((e.getY() < size*10) && (e.getY() > size*7))
					selected[6] = true;
				}
			else if((e.getX() < size*16) && (e.getX() > size*13))
				{
				if((e.getY() < size*4) && (e.getY() > size))
					selected[3] = true;
				else if((e.getY() < size*10) && (e.getY() > size*7))
					selected[7] = true;
				}
			
			repaint();
			}
				else
				{
					
					
					
					
					
					JFrame frame = new JFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
					
					TetrisMainPanel mainPanel = new TetrisMainPanel(AdditionalShapesPanel.sqrSize,AdditionalShapesPanel.width,AdditionalShapesPanel.height,AdditionalShapesPanel.M,AdditionalShapesPanel.N,AdditionalShapesPanel.S,AdditionalShapesPanel.selected);//(int BASIC_LENGTH,int WIDTH_AMOUNT,int HEIGHT_AMOUNT,int M_out,int N_out,double S_out,int oringinalRest_out)
					frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
					
					
					
					frame.setSize(900,1000);
					frame.setVisible(true);
					
				}
		}
		});
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		this.drawDotShape(g,size,size);
		this.drawSlopeShape(g, size*5, size);
		this.drawSmallLShape(g, size*9, size);
		this.drawSmallSShape(g, size*13, size);
		this.drawStraightShape(g, size, size*7);
		this.drawTinyStraightShape(g, size*5, size*7);
		this.drawVShape(g, size*9, size*7);
		this.drawWierdL_Shape(g, size*13, size*7);
		
		
		
		g.setColor(Color.BLACK);
		g.drawRect(size, size, size*3, size*3);
		g.drawRect(size*5, size, size*3, size*3);
		g.drawRect(size*9, size, size*3, size*3);
		g.drawRect(size*13, size, size*3, size*3);
		g.drawRect(size, size*6, size*3, size*3);
		g.drawRect(size*5, size*6, size*3, size*3);
		g.drawRect(size*9, size*6, size*3, size*3);
		g.drawRect(size*13, size*6, size*3, size*3);
		
		Font font = new Font("ningo",Font.BOLD,30);
		g.setFont(font);
		g.drawString("Please CLICK the shapes you want to add", 50, 30);
		
		
		g.drawRect(500, 550, 100, 50);
		g.drawString("OK", 530, 590);
		
		
		g.setFont(new Font("ningo",Font.BOLD,15));
		for(int i = 0;i < 8;i++)
			if(selected[i])
				
				
			
				if(i < 4)
				g.drawString("SELECTED", i * 4 * size + 2 * size -20, size + 2 * size -20);
				else
					g.drawString("SELECTED", (i - 4) * 4 * size + 2 * size -20, 6*size + 2 * size -20);
			
	}
	public void drawDotShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		
			
			
		
		
		
Color color = new Color(0x333399);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
	
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		
		
	
		
			
	}
	
	public void drawSlopeShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X+size*2;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y+size;
		
		int sqr_3_root_X = root_X;
		int sqr_3_root_Y = root_Y+size*2;
		
		
			
			
		
		
		
Color color = new Color(0x3399cc);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.fillRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.drawRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
			
	}
	
	
	public void drawSmallLShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X;
		int sqr_2_root_Y = root_Y+size;
		
		int sqr_3_root_X = root_X+size;
		int sqr_3_root_Y = root_Y+size;
		
		
			
			
		
		
		
Color color = new Color(0xa0a0a0);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.fillRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.drawRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
			
	}
	public void drawSmallSShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y+size;
		
		
			
			
		
		
		
Color color = new Color(0xcc6600);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
	
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
	
		
			
	}
	
	public void drawStraightShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y+size;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y+size;
		
		int sqr_3_root_X = root_X+size*2;
		int sqr_3_root_Y = root_Y+size;
		
		
			
			
		
		
		
Color color = new Color(0xcc6699);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.fillRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.drawRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
			
	}
	
	
	public void drawTinyStraightShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y;
		
		
			
			
		
		
		
Color color = new Color(0xccffcc);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
	
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
	
		
			
	}
	
	public void drawVShape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y+size;
		
		int sqr_3_root_X = root_X+size*2;
		int sqr_3_root_Y = root_Y;
		
		
			
			
		
		
		
Color color = new Color(0x999966);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.fillRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.drawRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
			
	}
	
	public void drawWierdL_Shape(Graphics g,int rootX,int rootY) {
		// TODO Auto-generated method stub
		
		int root_X = rootX;
		int root_Y = rootY;
		
		
		
		int sqr_1_root_X = root_X;
		int sqr_1_root_Y = root_Y;
		
		int sqr_2_root_X = root_X+size;
		int sqr_2_root_Y = root_Y+size;
		
		int sqr_3_root_X = root_X+size*2;
		int sqr_3_root_Y = root_Y+size;
		
		
			
			
		
		
		
Color color = new Color(0x66FF00);
		
		g.setColor(color);
		g.fillRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.fillRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.fillRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
	
	    g.setColor(Color.BLACK);
		g.drawRect(sqr_1_root_X, sqr_1_root_Y, size, size);
		g.drawRect(sqr_2_root_X, sqr_2_root_Y, size, size);
		g.drawRect(sqr_3_root_X, sqr_3_root_Y, size, size);
		
			
	}
	
}
