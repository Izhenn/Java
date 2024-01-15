package H7;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.Stack;

public class test2 extends JFrame{
    static JFrame frm=new JFrame("計算機");
    static JPanel btnpnl=new JPanel(new GridLayout(4,4));
    static Label lab=new Label("0. ",Label.RIGHT);
    double result;
    String inputString;

    public static void main(String[] args) {

        frm.setLayout(null);
        frm.setTitle("Calculator");
        frm.setSize(500, 600);
        frm.setVisible(true);
        ((JFrame) frm).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
        lab.setBounds(20,30,300,100);
        lab.setBackground(new Color(240,220,190));
        btnpnl.setBounds(20,100 ,300 ,400 );
        // display=new JTextField();
        String[] btnlab={
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for(String label:btnlab){
            JButton button=new JButton(label);
            button.addActionListener(new ButtonClickListener());
            btnpnl.add(button);
        }

        frm.getContentPane().add(lab,BorderLayout.NORTH);
        frm.getContentPane().add(btnpnl,BorderLayout.CENTER);
        
    }
    private static class ButtonClickListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                Button source = (Button) e.getSource();

            }
        }
}
