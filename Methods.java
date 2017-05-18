
/**
 * Write a description of class Methods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner;
import java.io.File;

public class Methods
{
    private Friend [] arrFriends = new Friend [50];
    private int count = 0;
    
    public void readData()
    {
       
        try
        {
            Scanner input = new Scanner(new File("Friends.txt"));
                       
            while(input.hasNext())
            {
                String line = input.nextLine();
                String [] info = line.split(",");
                
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String cell = info[2];
                
                arrFriends[count] = new Friend(name, age, cell);
                count++;
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Could not open or read file");
        }
        
    }
    
    public void sortArray()
    {
         
        for (int k = 0; k < count-1; k++)
        {
            
            for (int j = k+1; j < count; j++)
            {
               
                if(arrFriends[k].getName().compareTo(arrFriends[j].getName()) >0 )
                {
                    Friend temp = arrFriends[k];
                    arrFriends[k] = arrFriends[j];
                    arrFriends[j] = temp;
                }
                
            }
            
        }
        
    }
        
    public int searchName(String search_name)
    {
        
        for (int k = 0; k < count; k++)
        {
            
            if(search_name.equalsIgnoreCase(arrFriends[k].getName()))
            {
                return k;
            }
            
        }
        
        return -1;
    }
    
    public Friend [] getArray()
    {
        return arrFriends;
    }
    
    public int getCount()
    {
        return count;
    }
}
