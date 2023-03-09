package 화면DB연결;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import 자바DB연결.BbsDAO;

public class BbsUI {

	public static void open() {
		JFrame f = new JFrame();
		f.setTitle("나의 게시판 화면");
		f.setSize(550, 410);

		JLabel l1 = new JLabel("게시판 글쓰기 화면");
		JLabel l2 = new JLabel("----------------------");
		JLabel l3 = new JLabel("게시판  i   d");
		JLabel l4 = new JLabel("게시판 제  목");
		JLabel l5 = new JLabel("게시판 내  용");
		JLabel l6 = new JLabel("게시판 작성자");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);

		JButton b1 = new JButton("게시물 작성 완료");
		JButton b2 = new JButton("게시물 수정 완료");
		JButton b3 = new JButton("게시물 삭제 완료");
		JButton b4 = new JButton("게시물 검색 완료");

		// f에 위에 있는 요소들ㅇ르 add로 붙여주어야하는데, 붙이는 순서대로 물흐르듯이 붙여주고 싶음.
		// 물 흐르듯이 붙여주는 부품이 필요
		FlowLayout flow = new FlowLayout();

		// 폰트를 설정하기 위해 font 부품 필요
		Font font = new Font("굴림", Font.BOLD, 40);
		Font font1 = new Font("굴림", Font.BOLD, 30);
		Font font2 = new Font("굴림", Font.BOLD, 25);

		////// 필요한 부품(객체)를 ram에 가져다 놓고, 준비 끝 //////
		/// 조립을 시작해보자. ///
		f.setLayout(flow);

		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(l4);
		f.add(t2);
		f.add(l5);
		f.add(t3);
		f.add(l6);
		f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		l1.setFont(font);
		l2.setFont(font1);
		l3.setFont(font1);
		l4.setFont(font1);
		l5.setFont(font1);
		l6.setFont(font1);
		t1.setFont(font1);
		t2.setFont(font1);
		t3.setFont(font1);
		t4.setFont(font1);
		b1.setFont(font2);
		b2.setFont(font2);
		b3.setFont(font2);
		b4.setFont(font2);

		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.white);
		t2.setBackground(Color.DARK_GRAY);
		t2.setForeground(Color.white);
		t3.setBackground(Color.DARK_GRAY);
		t3.setForeground(Color.white);
		t4.setBackground(Color.DARK_GRAY);
		t4.setForeground(Color.white);

		b1.setBackground(Color.white);
		b1.setForeground(Color.black);
		b2.setBackground(Color.white);
		b2.setForeground(Color.black);
		b3.setBackground(Color.white);
		b3.setForeground(Color.black);
		b4.setBackground(Color.white);
		b4.setForeground(Color.black);

		f.getContentPane().setBackground(Color.lightGray);

		// 검색
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String no = t1.getText();
				int no2 = Integer.parseInt(no);

				BbsDAO dao = new BbsDAO();
				BbsVO bag = dao.one(no2);
				if (bag != null) {
					t2.setText(bag.getTitle());
					t3.setText(bag.getContent());
					t4.setText(bag.getWriter());
					t2.setBackground(Color.pink);
					t3.setBackground(Color.pink);
					t4.setBackground(Color.pink);
				} else {
					JOptionPane.showMessageDialog(f, "검색결과 없음");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			}
		});

		// 맨끝으로
		f.setVisible(true);
	}

}
