import java.util.Random;

class Philosopher extends Thread {
  private Chopstick left, right;
  private Random random;
  private int thinkCount;
  private int maxThink;
  private int maxEat;
  private int cycleCount;
  private String start;

  public Philosopher(Chopstick left, Chopstick right, int maxThink, int maxEat, int cycleCount, String start) {
    this.left = left; this.right = right; this.maxThink = maxThink; this.maxEat = maxEat; this.cycleCount = cycleCount; this.start = start;
    random = new Random();
  }

  public void run() {
    try {
      if (cycleCount == 0){ //if cycleCount is 0, then will run forever
        while(true) {
          ++thinkCount;
          if (thinkCount % 10 == 0){
            System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
          int TempNum = random.nextInt(maxThink + 1);
          Thread.sleep(TempNum);     // Think for a while
          System.out.println("Philosopher " + this + "has thought for " + TempNum  + " units");

          if (start == "left"){ //if left handed, start with left
            System.out.println("Philosopher " + this + "wants left chopstick");
            synchronized(left) {                    // Grab left chopstick 
              System.out.println("Philosopher " + this + "wants right chopstick");
              synchronized(right) {                 // Grab right chopstick 
                int tempEat = random.nextInt(maxEat + 1);
                Thread.sleep(tempEat);
                System.out.println("Philosopher" + this + "has eaten for " + tempEat + "units");
               } // Eat for a while
               System.out.println("Philosopher" + this + "has realease right chopstick");
            }
            System.out.println("Philosopher" + this + "has realease left chopstick");
      
          }
          else{ //if right handed, start with right
            System.out.println("Philosopher " + this + "wants right chopstick");
            synchronized(right) {                    // Grab left chopstick 
              System.out.println("Philosopher " + this + "wants left chopstick");
              synchronized(left) {                 // Grab right chopstick 
                int tempEat = random.nextInt(maxEat + 1);
                Thread.sleep(tempEat);
                System.out.println("Philosopher" + this + "has eaten for " + tempEat + "units");
               } // Eat for a while
               System.out.println("Philosopher" + this + "has realease left chopstick");
            }
            System.out.println("Philosopher" + this + "has realease right chopstick");
          }
          }
        }
      }
      else{
        while(cycleCount >= 1) { //if cycleCount is greater than 1, run number of times declared as cycleCount
          ++thinkCount;
          if (thinkCount % 10 == 0)
            System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
            int TempNum = random.nextInt(maxThink + 1);
            Thread.sleep(TempNum);     // Think for a while
            System.out.println("Philosopher " + this + "has thought for " + TempNum  + " units");

          if (start == "left"){ //if left handed, start with left
            System.out.println("Philosopher " + this + "wants left chopstick");
            synchronized(left) {                    // Grab left chopstick 
              System.out.println("Philosopher " + this + "wants right chopstick");
              synchronized(right) {                 // Grab right chopstick 
                int tempEat = random.nextInt(maxEat + 1);
                Thread.sleep(tempEat);
                System.out.println("Philosopher" + this + "has eaten for " + tempEat + "units");
               } // Eat for a while
               System.out.println("Philosopher" + this + "has realease right chopstick");
            }
            System.out.println("Philosopher" + this + "has realease left chopstick");
            }
          else{ //if right handed, start with right
            System.out.println("Philosopher " + this + "wants right chopstick");
            synchronized(right) {                    // Grab left chopstick 
              System.out.println("Philosopher " + this + "wants left chopstick");
              synchronized(left) {                 // Grab right chopstick 
                int tempEat = random.nextInt(maxEat + 1);
                Thread.sleep(tempEat);
                System.out.println("Philosopher" + this + "has eaten for " + tempEat + "units");
               } // Eat for a while
               System.out.println("Philosopher" + this + "has realease left chopstick");
            }
            System.out.println("Philosopher" + this + "has realease right chopstick");
          }
          cycleCount -= 1;
        }
      }
    } catch(InterruptedException e) {}
  }
}
