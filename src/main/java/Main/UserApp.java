package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UserApp {
    public static void main(String args[]) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost",80);
        JFrame frame = new JFrame("Server");
        frame.setSize(600,600);
        JTextField field = new JTextField("enter text");
        JButton button = new JButton("send message");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF(field.getText());
                    out.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JPanel contents = new JPanel();
        contents.add(field);
        contents.add(button);
        frame.setVisible(true);
        frame.setContentPane(contents);
        contents.setSize(200,200);
    }
}
