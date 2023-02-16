package com.mashibing.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {
	
	Tank myTank = new Tank(200, 200, Dir.DOWN);
	
	public TankFrame() {
		this.setSize(800, 600);
		this.setResizable(false);
		this.setTitle("Tank War");
		this.setVisible(true);
		
		this.addKeyListener(new MyKeyListener());
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
//		System.out.println("TankFrame.paint()");	// paint method 被系统自动调用
		myTank.paint(g);
		
	}

	class MyKeyListener extends KeyAdapter {
		
		boolean bL = false;
		boolean bU = false;
		boolean bR = false;
		boolean bD = false;

		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.println("TankFrame.MyKeyListener.keyPressed()");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = true;
				break;
			case KeyEvent.VK_UP:
				bU = true;
				break;
			case KeyEvent.VK_RIGHT:
				bR = true;
				break;
			case KeyEvent.VK_DOWN:
				bD = true;
				break;

			default:
				break;
			}
//			x +=100;
//			repaint();
			setMainTankDir();
		}

		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.println("TankFrame.MyKeyListener.keyReleased()");
			int key = e.getKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bL = false;
				break;
			case KeyEvent.VK_UP:
				bU = false;
				break;
			case KeyEvent.VK_RIGHT:
				bR = false;
				break;
			case KeyEvent.VK_DOWN:
				bD = false;
				break;

			default:
				break;
			}
			setMainTankDir();
		}

		private void setMainTankDir() {
			
			if(!bL && !bU && !bR && !bD) myTank.setMoving(false);
			else {
				myTank.setMoving(true);
				if(bL) myTank.setDir(Dir.LEFT);
				if(bU) myTank.setDir(Dir.UP);
				if(bR) myTank.setDir(Dir.RIGHT);
				if(bD) myTank.setDir(Dir.DOWN);
			}
			
		}
		
	}
	
}
