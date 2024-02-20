public class DiningPhilosophers {


  /*np - # of philosophers/chopsticks (args[0])
  nc - # of cycles, 0 is forever (args[1])
  tt - Max thinking time (args[2])
  et - Max eating time (args[3])
  rl - 0 all grab right, 1 even right odd left (args[4])
  */

  public static void main(String[] args) throws InterruptedException {
    Philosopher[] philosophers = new Philosopher[Integer.parseInt(args[0])];
    Chopstick[] chopsticks = new Chopstick[Integer.parseInt(args[0])];
    System.out.println("Number of philosophers: " + args[0]);
    System.out.println("Number of cycles: " + args[1]);
    System.out.println("Max thinking time: " + args[2]);
    System.out.println("Max eating time: " + args[3]);
    System.out.println("Handed indicator: " + args[4]);
    
    for (int i = 0; i < Integer.parseInt(args[0]); i++)
      chopsticks[i] = new Chopstick(i);
    for (int i = 0; i < Integer.parseInt(args[0]); i++) {
      if (Integer.parseInt(args[4]) == 0){
        philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % Integer.parseInt(args[0])], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[1]), "right");
        philosophers[i].start();
      }
      else{
        if (i % 2 == 0){
          philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % Integer.parseInt(args[0])], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[1]), "right");
          philosophers[i].start();
        }
        else{
          philosophers[i] = new Philosopher(chopsticks[i], chopsticks[(i + 1) % Integer.parseInt(args[0])], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[1]), "left");
          philosophers[i].start();
        }
      }
    }
    for (int i = 0; i < Integer.parseInt(args[0]); i++)
      philosophers[i].join();
  }
}