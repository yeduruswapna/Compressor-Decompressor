
package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton= new JButton("Select a file to Compress");
        compressButton.setBounds(200,100,200,30);
        compressButton.addActionListener(this);
        
        decompressButton= new JButton("Select a file to decompress");
        decompressButton.setBounds(500,100,200,30);
        decompressButton.addActionListener(this);
        
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==compressButton){
            JFileChooser filechooser= new JFileChooser();
            int response= filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file= new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
        
        
        if(e.getSource()==decompressButton){
            JFileChooser filechooser= new JFileChooser();
            int response= filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file= new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }catch(Exception ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }
        }
    }
}
