import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame
{
    private JLabel heading, bottomheading;
    private JButton search, quit;
    private JButton display; 
    private JButton read, sort;
    private JTextArea t_display;
    private JPanel mainPanel,topPanel,centrePanel,buttonPanel, bottomPanel;
    int count = 0;
    Methods myMethods = new Methods();
   

    public GUI()
    {
        heading = new JLabel("Friends",SwingConstants.CENTER);
        search = new JButton("Search");
        read = new JButton("Read");
        display = new JButton("Display");
        sort = new JButton("Sort");
        quit = new JButton("Quit");
        t_display = new JTextArea(20,30);
       
        mainPanel = new JPanel(new BorderLayout());
        topPanel = new JPanel(new FlowLayout());
        centrePanel = new JPanel(new FlowLayout());
       
        buttonPanel = new JPanel(new GridLayout(1,5,1,1));
        bottomPanel = new JPanel(new FlowLayout());
        topPanel.add(heading);
        centrePanel.add(t_display);
        
        buttonPanel.add(read);
        buttonPanel.add(display);
        buttonPanel.add(sort);
        buttonPanel.add(search);
        buttonPanel.add(quit);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(centrePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        
        add(mainPanel);
        
        buttonListener handler = new buttonListener(); 
        read.addActionListener(handler); 
        sort.addActionListener(handler); 
        search.addActionListener(handler);
        display.addActionListener(handler);
        quit.addActionListener(handler);
    }
   
    private class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Friend [] arrFriends = myMethods.getArray();
            int count = myMethods.getCount(); 
                            
            if(e.getSource() == read)
            {
                myMethods.readData();                
               
                JOptionPane.showMessageDialog(null,"Data has been read");
               
            }
            
            if(e.getSource() == search)
            {
                String searchedName = JOptionPane.showInputDialog(null, "Enter the name you want to be searched");
                
                int index = myMethods.searchName(searchedName);
                
                if(index >= 0)
                {
                    t_display.setText("Infomation of" + searchedName + "\n\\n");
                    
                    t_display.append("Name: " + arrFriends[index].getName() + "\n");
                    t_display.append("Age: " + arrFriends[index].getAge() + "\n");
                    t_display.append("Cell: " + arrFriends[index].getCell() + "\n");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Name of " + searchedName + " not found");
                }
                
            }
            
            if(e.getSource() == display)
            {
                t_display.setText("Friends\n");
                t_display.append("Name       Age     Cell\n\n");
                
                for(int k = 0; k < count; k++)
                {
                    t_display.append(arrFriends[k].toString() + "\n");
                }
                
            }
            
            if(e.getSource() == sort)
            {
                myMethods.sortArray();
               
                JOptionPane.showMessageDialog(null,"Data has been sorted by name");
               
            }
            
            if(e.getSource() == quit)
            {
                System.exit(0);
            }
            
        }
        
    }
    
}
