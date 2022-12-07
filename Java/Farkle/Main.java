package Java.Farkle;

import Java.ArrayListHelp.*;
import Java.BetterPrint.*;
import Java.BetterMath.*;
import java.util.*;

class Main
{
    public static void main(String[] args)
    {
        BetterPrint print = new BetterPrint();
        BetterMath math = new BetterMath();
        Scanner sc = new Scanner(System.in);

        ArrayList<ArrayList<Integer>> rolls = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentRoll = new ArrayList<Integer>();
        int numDice;
        int diceMax;
        int numRolls;

        numDice = 0;
        diceMax = 0;
        numRolls = 0;

        print.printStr("Number of dice: ");
        numDice = sc.nextInt();

        print.printStr("Number of die sides: ");
        diceMax = sc.nextInt();

        for(int i = 0; i <= math.pow(diceMax, numDice); i++)
        {
            rolls.add(new ArrayList<Integer>());
        }

        for(int i = 0; i <= math.pow(diceMax, numDice); i++)
        {
            for(int j = 0; j < numDice; j++)
            {
                rolls.get(i).add(0);
            }
        }

        for(int i = 0; i < numDice; i++)
        {
            currentRoll.add(0);
        }

        //print.printStr("Rolls list: ");
        //print.printStr(rolls.toString());
        //print.enter();

        for(int i = 1; i <= math.pow(diceMax, numDice); i++)
        {
            numRolls++;

            currentRoll.set(0, numRolls);

            for(int j = 0; j < numDice - 1; j++)
            {
                if(currentRoll.get(j) < diceMax)
                {
                    break;
                }

                if(numRolls >= diceMax)
                {
                    numRolls = 0;
                    currentRoll.set(j + 1, currentRoll.get(j + 1) + 1);
                }
            }
            rolls.set(i, currentRoll);
        }
        

        print.printStr("Rolls list: ");
        print.printStr(rolls.toString());
        print.enter();
    }
}
