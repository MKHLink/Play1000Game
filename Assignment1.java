import java.util.Random;

public class Assignment1
{
  public static void main(String[] args)
  {
    int lower, upper;

    lower = Integer.parseInt(args[0]);
    upper = Integer.parseInt(args[1]);
    testEachInteger(lower, upper);
    System.out.println();
    playOneThousandGames(lower, upper);
    System.out.println();
    playOneThousandGames(lower, upper);
  }

  public static String playGame(int chosenNumber, int lower, int upper)
  {
      String ansKey=" ";
      int middle;
      
            
      while(lower<=upper)
      {
         middle = ((upper + lower)/2);

         if(middle < chosenNumber)
         {
            lower = middle+1;
            ansKey += "1";
         }
         else if(middle > chosenNumber)
         {
            upper = middle -1;
            ansKey += "0";
         }
         else if(middle == chosenNumber)
         {
            ansKey += "0";
            break;
         }
      }
      return ansKey;
  }

  public static void testEachInteger(int lower, int upper)
  {
   int aCount = 0,bCount = 0;
      String chosenInt = " ";
      double average;

      
      double a = Math.log(upper) / Math.log(2);
      int intA = (int) a;
      int intB = intA+1;
         
      
      for(int i = lower;i<=upper;i++)
      {
         System.out.format("Chosen integer %3d : ",i);
         chosenInt = playGame(i,lower,upper);
         System.out.println(chosenInt);
         System.out.println();
         if(chosenInt.length()==intA)
         {
            aCount++;
         }
         if(chosenInt.length()==intB)
         {
            bCount++;
         }   
   
      }
      average = ((aCount*intA)+(bCount*intB))/upper;
      System.out.println("There are "+aCount+ " integers where only "+ intA+" questions are asked");
      System.out.println("There are "+bCount+ " integers where only "+intB+ " questions are asked");
      System.out.println("The weighted average is "+average);

  }

  public static void playOneThousandGames(int lower, int upper)
  {
      int aCount = 0,bCount = 0;
      String chosenInt = " ";
      double average;

  
      double a = Math.log(upper) / Math.log(2);
      int intA = (int) a;
      int intB = intA+1;
      
      Random rand = new Random();
      for(int i = 0;i<=1000;i++)
      {
         int x = rand.nextInt(upper-lower)+lower;
         chosenInt = playGame(x,lower,upper);
         
         System.out.println(chosenInt);
         System.out.println();
         if(chosenInt.length()==intA)
         {
            aCount++;
         }
         if(chosenInt.length()==intB)
         {
            bCount++;
         }  
      }
      average = ((aCount*intA)+(bCount*intB))/upper;
      System.out.println("There are "+aCount+ " integers where only "+ intA+" questions are asked");
      System.out.println("There are "+bCount+ " integers where only "+intB+ " questions are asked");
      System.out.println("The weighted average is "+average);

  }
}