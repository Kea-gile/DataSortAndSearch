
/**
 * Write a description of class Friend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Friend
{
   private String name;
   private int age;
   private String cell;
   
   public Friend(String name, int age, String cell)
   {
       this.name = name;
       this.age = age;
       this.cell = cell;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getCell()
    {
        return cell;
    }
    
    public String toString()
    {
        String str = String.format("%-20s\t%-10d%-20s", name, age, cell);
        return str;
    }
}
        
        