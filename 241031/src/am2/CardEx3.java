package am2;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import am.MyWin;

public class CardEx3 extends JFrame implements ActionListener {
  /* Field */
  JPanel loginCardPanel, loginPanel, loginIdPanel, loginPWPanel, loginBtnPanel, chatCardPanel, chatTopPanel,
      chatTextPanel;
  JLabel loginIdLabel, loginPwLabel;
  JTextField loginIdTextField, loginPwTextField, chatTextField;
  JButton loginBtn, chatPrevBtn, chatSendBtn;
  JTextArea chatLogArea;
  CardLayout cardL;

  /* Constructer */
  public CardEx3() {
    /* Login panel */
    loginCardPanel = new JPanel(new BorderLayout());

    loginPanel = new JPanel(new GridLayout(3, 1));

    loginIdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    loginIdLabel = new JLabel("ID:");
    loginIdTextField = new JTextField(10);
    loginIdPanel.add(loginIdLabel);
    loginIdPanel.add(loginIdTextField);
    loginPanel.add(loginIdPanel);

    loginPWPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    loginPwLabel = new JLabel("PW:");
    loginPwTextField = new JTextField(10);
    loginPWPanel.add(loginPwLabel);
    loginPWPanel.add(loginPwTextField);
    loginPanel.add(loginPWPanel);

    loginBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    loginBtn = new JButton("Login");
    loginBtnPanel.add(loginBtn);
    loginPanel.add(loginBtnPanel);

    loginCardPanel.add(loginPanel, BorderLayout.SOUTH);

    /* chat panel */
    chatCardPanel = new JPanel(new BorderLayout());

    chatTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    chatPrevBtn = new JButton("Prev");
    chatTopPanel.add(chatPrevBtn);
    chatCardPanel.add(chatTopPanel, BorderLayout.NORTH);

    chatLogArea = new JTextArea();
    chatLogArea.setEditable(false);
    chatCardPanel.add(new JScrollPane(chatLogArea));

    chatTextPanel = new JPanel(new GridLayout(1, 2));
    chatTextField = new JTextField();
    chatSendBtn = new JButton("Send");
    chatTextPanel.add(chatTextField);
    chatTextPanel.add(chatSendBtn);
    chatCardPanel.add(chatTextPanel, BorderLayout.SOUTH);

    /* Card layout */
    cardL = new CardLayout();
    this.setLayout(cardL);
    this.getContentPane().add(loginCardPanel, "loginCard");
    this.getContentPane().add(chatCardPanel, "chatCard");

    /* Basement */
    this.setBounds(500, 100, 300, 500);
    this.setVisible(true);

    /* Event listener */
    this.addWindowListener(new MyWin());
    loginBtn.addActionListener(this);
    chatPrevBtn.addActionListener(this);
  }

  /* Event Handler */
  @Override
  public void actionPerformed(ActionEvent e) {
    Object obj = e.getSource();
    String cardName = null;
    if (obj == loginBtn) {
      cardName = "chatCard";
    } else {
      cardName = "loginCard";
    }
    cardL.show(this.getContentPane(), cardName);
  }

  public static void main(String[] args) {
    new CardEx3();
  }
}
