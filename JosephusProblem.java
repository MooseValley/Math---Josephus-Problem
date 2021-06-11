/*
     Author: Moose OMalley, https://github.com/MooseValley/
       Date: 11-Jun-2021
My web site: Moose's Sofwtare Valley, Established July-1996, https://moosevalley.github.io/
     GitHub: https://github.com/MooseValley/Math---Josephus-Problem
Description: My code to explore the The Josephus Problem, following on from the Numberphile video:
             https://www.youtube.com/watch?v=uCsD3ZGzMgE
License:     MIT License - use all or any part of my code, but you must give me full credit.


If n = 2^a + L
where L < 2^a
then Winner = 2L + 1

eg. If 41 soldiers
then 41 = 32 + 9
Winner = 2*9 + 1 = 19

Or In Assembler
   ROL L

Beautiful !

*/
import java.util.Scanner;

class Josephus
{
   private boolean[] soldiers;
   private int numSoldiers;
   Scanner kb = new Scanner (System.in);

   public Josephus ()
   {
      this (1);
   }

   public Josephus (int numSoldiers)
   {
      this.numSoldiers = numSoldiers;

      soldiers = new boolean [numSoldiers];
   }

   private int getNextLivingSoldier (int currentSoldier)
   {
      int livingSoldierIndex = -1;

      for (int k = 0; k < soldiers.length; k++)
      {
         int index = (k + currentSoldier + 1) % soldiers.length;

         //System.out.print ("  -> Looking for LIVE solder at index: " + index);

         if (soldiers [index] == true) // Living soldier
         {
            //System.out.println (" - FOUND !");
            livingSoldierIndex = index;

            k = soldiers.length; // Exit loop !
         }
      }

      return livingSoldierIndex;
   }

   public int getAliveCount ()
   {
      int count = 0;

      for (int index = 0; index < soldiers.length; index++)
      {
         if (soldiers [index] == true) // Living soldier
         {
            count++;
         }
      }

      return count;
   }

   public int getWinner ()
   {
      boolean done = false;

      for (int k = 0; k < numSoldiers; k++)
      {
         soldiers[k] = true; // Soldier is alive.
      }

      int currSoldier = 0;

      int aliveCount = numSoldiers;

      if (numSoldiers > 1)
      {
         while (aliveCount > 1)
         {
            int nextLivingSoldier = getNextLivingSoldier (currSoldier);

/*
            if (nextLivingSoldier < 0)
            {
               done = true;
            }
            else
            {
*/
               //System.out.println ("-> Killing soldier: " + nextLivingSoldier);

               soldiers[nextLivingSoldier] = false; // He Dead !
               aliveCount--;

               //System.out.println (toString() );

               currSoldier = getNextLivingSoldier (nextLivingSoldier);

               //kb.nextLine();
/*
               if (nextLivingSoldier < 0)
               {
                  done = true;
               }
               else
               {
                  currSoldier = nextLivingSoldier;
               }
*/
            //}
         }
      }

      //System.out.println ("-> Last Living soldier: " + currSoldier);

      return currSoldier + 1; // Convert array index to Count
   }

   public String toString()
   {
      StringBuilder sb    = new StringBuilder();

      for (int k = 0; k < soldiers.length; k++)
      {
         sb.append ("" + (k+1) ); // Output Solider's starting at 1.
         if (soldiers [k] == true)
            sb.append ("(A)");
          else
            sb.append ("(D)");

         sb.append (", ");
      }

      return sb.toString();
   }
}


public class JosephusProblem
{
   public static void main (String[] args)
   {
      Josephus josephus = new Josephus (5);

      //System.out.println (5 + ": " + josephus.getWinner () );


      for (int numSoldiers = 1; numSoldiers <= 20; numSoldiers++)
      {
         josephus = new Josephus (numSoldiers);

         System.out.println (numSoldiers + ": " + josephus.getWinner() +
                             "  -> " + josephus.toString() );
      }

   }
}