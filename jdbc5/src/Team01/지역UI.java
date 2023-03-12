package Team01;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class 지역UI {

	//화살표는 안하는것 추천
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("수도권");
		f.setSize(500, 500);
		
		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);
		
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 15);
		
		JLabel title = new JLabel("지역별 공연");
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		JLabel l3 = new JLabel();
		JLabel l4 = new JLabel();
		JLabel l5 = new JLabel();
		
		JButton button1 = new JButton("수도권");
		JButton button2 = new JButton("지방");
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		
		title.setFont(font);
		button1.setFont(font1);
		button2.setFont(font1);
		l1.setFont(font2);
		l2.setFont(font2);
		l3.setFont(font2);
		l4.setFont(font2);
		l5.setFont(font2);

		f.add(title);
		f.add(button1);
		f.add(button2);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		

		
		f.setVisible(true);
	}
}
