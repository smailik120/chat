package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UserApp {
    public static void main(String args[]) throws IOException, InterruptedException {
        final Socket socket = new Socket("192.168.56.1",80);
        JFrame frame = new JFrame("Server");
        frame.setSize(600,600);
        final JTextField field = new JTextField("enter text");
        JButton button = new JButton("send message");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println(socket);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    DataInputStream inp = new DataInputStream(socket.getInputStream());
                    out.writeUTF(field.getText());
                    out.flush();
                    Thread.sleep(30);
                    String t = inp.readUTF();
                    System.out.println(t);
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (InterruptedException e1) {
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
