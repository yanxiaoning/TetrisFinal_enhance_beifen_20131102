package com.ningo.tetris;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConfigPanel extends JPanel {
	private JSlider slider_M;
	private JSlider slider_N;
	private JSlider slider_S;
	
	private JSlider width_slider;
	private JSlider height_slider;
	private JSlider squareSize_slider;
	
	private JLabel label_M;
	private JLabel label_N;
	private JLabel label_S;
	
	private JLabel label_width;
	private JLabel label_height;
	private JLabel label_squareSize;
	
	public ConfigPanel()
	{
		GridLayout layout = new GridLayout(5,6);
		
		slider_M = new JSlider(JSlider.VERTICAL,1,10,1);
		slider_N = new JSlider(JSlider.VERTICAL,20,50,20);
		slider_S = new JSlider(JSlider.VERTICAL,1,10,1);
		
		width_slider = new JSlider(JSlider.VERTICAL,10,40,10);
		height_slider = new JSlider(JSlider.VERTICAL,20,80,20);
		squareSize_slider = new JSlider(JSlider.VERTICAL,20,100,20);
		
		
		Font font = new Font("font0",Font.BOLD,15);
		
		label_M = new JLabel();
		label_M.setText("M: "+String.valueOf(slider_M.getValue()));
		label_M.setFont(font);
		label_N = new JLabel();
		label_N.setText("N: "+String.valueOf(slider_N.getValue()));
		label_N.setFont(font);
		label_S = new JLabel();
		label_S.setText("S: "+String.valueOf((double)slider_S.getValue()/10));
		label_S.setFont(font);
		
	    label_width= new JLabel();
	    label_width.setText("width: "+String.valueOf(width_slider.getValue()));
	    label_width.setFont(font);
		label_height= new JLabel();
		label_height.setText("height: "+String.valueOf(height_slider.getValue()));
		label_height.setFont(font);
		label_squareSize= new JLabel();
		label_squareSize.setText("sqrSize: "+String.valueOf(squareSize_slider.getValue()));
		label_squareSize.setFont(font);
		
		
		slider_M.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				label_M.setText("M: "+String.valueOf(slider_M.getValue()));
				
			}
			
		});
		slider_N.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				label_N.setText("N: "+String.valueOf(slider_N.getValue()));
				
			}
			
		});
		slider_S.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				label_S.setText("S: "+String.valueOf((double)slider_S.getValue()/10));
				
			}
			
		});
		width_slider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
			    label_width.setText("width: "+String.valueOf(width_slider.getValue()));
				
			}
			
		});
		height_slider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				label_height.setText("height: "+String.valueOf(height_slider.getValue()));
				
			}
			
		});
		squareSize_slider.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				
				label_squareSize.setText("sqrSize: "+String.valueOf(squareSize_slider.getValue()));
				
			}
			
		});
		
		
		JButton button = new JButton("Confirm");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				
				int M = slider_M.getValue();
				int N = slider_N.getValue();
				double S = slider_S.getValue();
				
				int width = width_slider.getValue();
				int height = height_slider.getValue();
				int sqrSize = squareSize_slider.getValue();
				
				
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				AdditionalShapesPanel asp = new AdditionalShapesPanel(M,N,S, width, height, sqrSize);
				frame.getContentPane().add(BorderLayout.CENTER,asp);
				frame.setSize(700,700);
				frame.setVisible(true);
				
			}
			
		});
		
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(width_slider);
		add(label_width);
		add(height_slider);
		add(label_height);
		add(squareSize_slider);
		add(label_squareSize);
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		
		add(slider_M);
		add(label_M);
		add(slider_N);
		add(label_N);
		add(slider_S);
		add(label_S);
		
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(button);
		
		
		this.setLayout(layout);
		
		
	}

}
