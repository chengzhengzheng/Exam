package com.xianyang.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** 登录界面 是一个具体窗口框 */
public class LoginFrame extends JFrame{
  /**
   * 
   */
  private static final long serialVersionUID = -7993721800179709451L;
  public LoginFrame() {
    init();
  }
  /** 初始化界面组件和布局的 */
  private void init(){
    this.setTitle("登录系统");
    JPanel contentPane = createContentPane();
    this.setContentPane(contentPane);
    setSize(270,188);
    setLocationRelativeTo(null);//居中
    
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        clientContext.exit(LoginFrame.this);
      }
    });
    
  }
  private JPanel createContentPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,8,8,8));
    p.add(BorderLayout.NORTH, 
        new JLabel("登录考试系统", JLabel.CENTER));
    p.add(BorderLayout.CENTER, createCenterPane());
    p.add(BorderLayout.SOUTH, createBtnPane());
    return p;
  }
  private JPanel createBtnPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("Login");
    JButton cancel = new JButton("Cancel");
    
    getRootPane().setDefaultButton(login);
    
    p.add(login);
    p.add(cancel);
    
    login.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        //System.out.println("click login button");
        clientContext.login();
      }
    });
    cancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        //LoginFrame.this 是当前LoginFrame对象的实例
        //就是登录窗口对象的引用
        clientContext.exit(LoginFrame.this);
      }
    });
    
    return p;
  }
  private JPanel createCenterPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,0,0,0));
    p.add(BorderLayout.NORTH, createIdPwdPane());
    message = new JLabel("",JLabel.CENTER);
    p.add(BorderLayout.CENTER, message);
    return p;
  }
  private JPanel createIdPwdPane(){
    JPanel p =  new JPanel(new GridLayout(2, 1, 0, 6));
    p.add(createIdPane());
    p.add(createPwdPane());
    return p;
  }
  private JPanel createIdPane(){
    JPanel p = new JPanel(new BorderLayout(6,0));
    p.add(BorderLayout.WEST, new JLabel("编号:"));
    JTextField idField = new JTextField();
    p.add(BorderLayout.CENTER, idField);
    //将实例变量idField 引用到界面控件上
    this.idField = idField;
    return p;
  }
  /** 简单工厂方法, 封装的复杂对象的创建过程, 返回一个对象实例 */
  private JPanel createPwdPane(){
    JPanel p = new JPanel(new BorderLayout(6,0));
    p.add(BorderLayout.WEST, new JLabel("密码:"));
    JPasswordField pwdField = new JPasswordField();
    pwdField.enableInputMethods(true);
    p.add(BorderLayout.CENTER, pwdField);
    this.pwdField = pwdField;
    return p;
  }
  private ClientContext clientContext;
  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
  }
  private JTextField idField;
  private JPasswordField pwdField;
  private JLabel message;
  public int getUserId(){
    return Integer.parseInt(idField.getText());
  }
  public String getPassword(){
    char[] pwd = pwdField.getPassword();
    return new String(pwd);
  }
  public void showMessage(String message){
    this.message.setText(message);
  }
}








