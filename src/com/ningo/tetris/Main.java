package com.ningo.tetris;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {




public static void main(String[] args)
{
	
	
	
	
	
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	ConfigPanel panel = new ConfigPanel();
	
frame.getContentPane().add(BorderLayout.CENTER,panel);
	
	
	
	frame.setSize(700,700);
	frame.setVisible(true);
	
	/*
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	TetrisMainPanel mainPanel = new TetrisMainPanel(20,15,30,5,1,0.5);//(int BASIC_LENGTH,int WIDTH_AMOUNT,int HEIGHT_AMOUNT,int M_out,int N_out,double S_out,int oringinalRest_out)
	frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
	
	
	
	frame.setSize(900,1000);
	frame.setVisible(true);
	*/
}
}
