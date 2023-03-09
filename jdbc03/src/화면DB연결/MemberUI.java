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

import 자바DB연결.MemberDAO2;

public class MemberUI {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("나의 회원가입 화면");
		f.setSize(580, 420);

		JLabel l1 = new JLabel("<<<< 회원가입화면 >>>>");
		JLabel l2 = new JLabel("아이디");
		JLabel l3 = new JLabel("패스워드");
		JLabel l4 = new JLabel("이  름");
		JLabel l5 = new JLabel("전화번호");

		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(10);
		JTextField t4 = new JTextField(10);

		JButton b1 = new JButton("회원가입 처리");
		JButton b2 = new JButton("회원탈퇴 처리");
		JButton b3 = new JButton("회원수정처리");
		JButton b4 = new JButton("회원검색 처리");

		// 가입기능
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입처리");
				String id = t1.getText();
				String pw = t2.getText();
				String name = t3.getText();
				String tel = t4.getText();

				// id를 비워 뒀을 때
				if (id.equals("")) { // 기본형 4가지만 ==로 값을 비교 가능, 참조형은 equals 사용!
					JOptionPane.showMessageDialog(f, "id는 필수입력항목입니다.");
				}
				MemberDAO2 dao = new MemberDAO2();
				int result = dao.insert(id, pw, name, tel); // 1 or 0
				if (result ==1) {
					JOptionPane.showMessageDialog(f, "회원가입 성공");
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}else {
					JOptionPane.showMessageDialog(f, "회원가입 실패, 재입력해주세요.");
					t1.setText("");
				}
			}// action
		});// b1

		// 탈퇴기능
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원탈퇴처리");
				String id = t1.getText();
				
				MemberDAO2 dao = new MemberDAO2();
				int result = dao.delete(id);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "회원탈퇴 성공");
					t1.setText("");
				} else {
					JOptionPane.showMessageDialog(f, "회원탈퇴 실패, 재입력해주세요.");
					t1.setText("");
				}
			}// action
		});// b2

		// 수정기능
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원수정처리");
				String id = t1.getText(); // 조건
				String tel = t4.getText(); // 바꾸는 항목

				MemberDAO2 dao = new MemberDAO2();
				int result = dao.update(id, tel);
				if (result == 1) {
					JOptionPane.showMessageDialog(f, "회원수정 성공");
					t1.setText("");
					t4.setText("");
				} else {
					JOptionPane.showMessageDialog(f, "회원수정 실패, 재입력해주세요.");
					t1.setText(""); 
				}
			}// action
		});// b1

		// f에 위에 있는 요소들ㅇ르 add로 붙여주어야하는데, 붙이는 순서대로 물흐르듯이 붙여주고 싶음.
		// 물 흐르듯이 붙여주는 부품이 필요
		FlowLayout flow = new FlowLayout();

		// 폰트를 설정하기 위해 font 부품 필요
		Font font = new Font("굴림", Font.BOLD, 40);
		Font font1 = new Font("굴림", Font.BOLD, 30);

		////// 필요한 부품(객체)를 ram에 가져다 놓고, 준비 끝 //////
		/// 조립을 시작해보자. ///
		f.setLayout(flow);

		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);

		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		t1.setFont(font);
		t2.setFont(font);
		t3.setFont(font);
		t4.setFont(font);
		b1.setFont(font1);
		b2.setFont(font1);
		b3.setFont(font1);
		b4.setFont(font1);

		t1.setBackground(Color.DARK_GRAY);
		t1.setForeground(Color.white);
		t2.setBackground(Color.DARK_GRAY);
		t2.setForeground(Color.white);
		t3.setBackground(Color.DARK_GRAY);
		t3.setForeground(Color.white);
		t4.setBackground(Color.DARK_GRAY);
		t4.setForeground(Color.white);

		b1.setBackground(Color.pink);
		b1.setForeground(Color.black);
		b2.setBackground(Color.pink);
		b2.setForeground(Color.black);
		b3.setBackground(Color.pink);
		b3.setForeground(Color.black);
		b4.setBackground(Color.pink);
		b4.setForeground(Color.black);

		f.getContentPane().setBackground(Color.lightGray);

		// 맨끝으로
		f.setVisible(true);
	}

}
