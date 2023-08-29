//Chandrayaan 3 Lunar Craft: Galactic Space Craft Control

public class galacticSpcControl
 {
    int x, y, z;
    char facingDir;

    public galacticSpcControl(int x, int y, int z, char facingDir)
     {
        this.x = x;
        this.y = y;
        this.z = z;
        this.facingDir = facingDir;
    }

    void moveForward()
    {
        switch (facingDir)
        {
            case 'N':
                y++;
                break;
            case 'S':
                y--;
                break;
            case 'E':
                x++;
                break;
            case 'W':
                x--;
                break;
            case 'U':
                z++;
                break;
            case 'D':
                z--;
                break;
        }
    }

    void moveBackward()
     {
        switch (facingDir)
         {
            case 'N':
                y--;
                break;
            case 'S':
                y++;
                break;
            case 'E':
                x--;
                break;
            case 'W':
                x++;
                break;
            case 'U':
                z--;
                break;
            case 'D':
                z++;
                break;
        }
    }

    void moveCraft(char command)
    {
        switch (command)
         {
            case 'f':
                moveForward();
                break;
            case 'b':
                moveBackward();
                break;
            default:
                System.out.println("enter valid command");
        }
    }

    void rotateCraft(char command)
    {
        switch (command)
        {
            case 'l':
                rotateLeft();
                break;
            case 'r':
                rotateRight();
                break;
            case 'u':
                rotateUp();
                break;
            case 'd':
                rotateDown();
                break;
            default:
                System.out.println("enter valid command");
        }
    }


    void rotateLeft()
    {
        switch (facingDir)
        {
            case 'N':
                facingDir = 'W';
                break;
            case 'S':
                facingDir = 'E';
                break;
            case 'E':
                facingDir = 'N';
                break;
            case 'W':
                facingDir = 'S';
                break;
        }
    }

    void rotateRight()
     {
        switch (facingDir)
        {
            case 'N':
                facingDir = 'E';
                break;
            case 'S':
                facingDir = 'W';
                break;
            case 'E':
                facingDir = 'S';
                break;
            case 'W':
                facingDir = 'N';
                break;
        }
    }

    void rotateUp()
    {
        if (facingDir == 'N' || facingDir == 'S' || facingDir == 'E' || facingDir == 'W')
         {
            facingDir = 'U';
        }
    }

    void rotateDown()
    {
        if (facingDir == 'N' || facingDir == 'S' || facingDir == 'E' || facingDir == 'W')
         {
            facingDir = 'D';
        }
    }

    void printCraftPos()
    {
        System.out.println("\nposition of x y z and direction is : " + x +"," +y + "," +z +"," +" dir -> " +facingDir);
    }

    public static void main(String[] args)
     {
        galacticSpcControl c1 = new galacticSpcControl(0, 0, 0, 'W');

        char[] commands = {'f', 'r', 'f', 'l', 'b', 'u'}; 
        int i = commands.length;
        
        for (char command : commands) 
        {
            if (command == 'f' || command == 'b')
            {
               c1.moveCraft(command);
               i--;
            }
            else
            {
                c1.rotateCraft(command);
                i--;
            }

            c1.printCraftPos();

            if(i==0)
            {
                System.out.println("\nFinal position of x y z  and direction is:- ");
                c1.printCraftPos();
            }
        }
    } //end of main
} //end of class
