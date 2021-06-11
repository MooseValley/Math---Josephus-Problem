public class JosephusProblem
{
   private static boolean[] soldiers;


   public static int getNextLivingSoldier (int currentSoldier)
   {
      int livingSoldierIndex = -1;

      for (int numSoldiers = currentSoldier + 1; numSoldiers < soldiers.length; numSoldiers++)
      {
         if (numSoldiers [numSoldiers] == true) // Living soldier
         {
            livingSoldierIndex = numSoldiers;
            numSoldiers = soldiers.length; // Exit loop !
         }
      }

      return livingSoldierIndex;
   }

   public static int getWinner (int numSoldiers)
   {
      boolean done = false;
      boolean[] soldiers = new boolean [numSoldiers];

      for (int k = 1; k < numSoldiers; k++)
      {
         soldiers[k] = true; // Soldier is alive.
      }


      while (done == false)
      {
         for (int k = 1; k < numSoldiers; k++)
         {
         }
      }
   }

   public static void main (String[] args)
   {
      for (int numSoldiers = 1; numSoldiers < 20; numSoldiers++)
      {
      }
   }
}