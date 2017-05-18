import javax.swing.JFrame;
public class test
{
    public static void main (String [] args)
    {
        GUI myGUI = new GUI();
        myGUI.setSize(400, 450);
        myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGUI.setVisible(true);
    }
}
