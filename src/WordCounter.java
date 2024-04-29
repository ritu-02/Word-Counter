import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter extends JFrame implements ActionListener {
    JLabel label1 , label2, label3;
    JButton btn1, btn2,btn3;
    JTextArea textArea;
    JScrollPane scrollPane;

    public WordCounter(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setTitle("Word Counter");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0xDCDFDC));

        textArea = new JTextArea("Enter your text.....");
        textArea.setBounds(80,30,600,300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10,10,10,10));

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(80,30,600,300);

        label1 = new JLabel("Word Count : 0");
        label1.setBounds(90,400,200,40);
        label1.setFont(new Font("Italic",Font.BOLD,14));
        label1.setForeground(Color.blue);

        label2 = new JLabel("Character Count : 0");
        label2.setBounds(70,450,250,40);
        label2.setFont(new Font("Italic",Font.BOLD,14));
        label2.setForeground(Color.blue);

        label3 = new JLabel("Line Count : 0");
        label3.setBounds(90,500,200,40);
        label3.setFont(new Font("Italic",Font.BOLD,14));
        label3.setForeground(Color.blue);

        btn1 = new JButton("Word Counter");
        btn1.setBounds(350,400,200,40);
        btn1.setFont(new Font("Italic",Font.BOLD,14));
        btn1.setForeground(Color.CYAN);

        btn2 = new JButton("Character Counter");
        btn2.setBounds(325,450,250,40);
        btn2.setFont(new Font("Italic",Font.BOLD,14));
        btn2.setForeground(Color.CYAN);

        btn3 = new JButton("Line Counter");
        btn3.setBounds(350,500,200,40);
        btn3.setFont(new Font("Italic",Font.BOLD,14));
        btn3.setForeground(Color.CYAN);

        this.add(scrollPane);
        // this.add(textArea);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         String text = textArea.getText();
         String[] words = text.split("\\s+");
         // To split by one or more whitespace
         String[] lines = text.split("\n");

         if (e.getSource()==btn1){
             label1.setText("Words Count : "+words.length);
         } else if (e.getSource()==btn2) {
             // Remove whitespaces and count characters
             label2.setText("Characters Count : "+text.replaceAll("\\s","").length());
         }else {
             // Remove trailing empty lines
             int count = text.isEmpty()?0:text.split("\n").length;
             label3.setText("Lines Count : "+count);
         }

    }
}
