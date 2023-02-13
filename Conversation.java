import java.util.Scanner;
class Conversation {
  public static void main(String[] arguments) {
    // you will start the conversation here.
    int rounds = 0;
    int count = 0;
    String userResponse = "";
    String compResponse = "";
    String i = " i ";
    String me = " me ";
    String am = " am ";
    String are = " are ";
    String you = " you ";
    String my = " my ";
    String your = " your ";
    String yours = " yours ";
    String mine = " mine ";
  
    Scanner userinput = new Scanner(System.in);

    while (rounds <= 0) {
      System.out.println("How many rounds of conversation do you want to have?");
      rounds = userinput.nextInt();
        if (rounds <= 0) {
          System.out.println("Sorry, please input a valid number.");
        }
    }
    System.out.println("Understood.\n");

    System.out.println("Hey there! What are you thinking about?"); 
    while (count <= rounds) {
      userResponse = userinput.nextLine();
      //Adds a space at the beginning so that pronouns at the beginning are recognized
      compResponse = " "+userResponse;
      //Some of the replacements are modified because those replacements would be incorrectly replaced otherwise
      compResponse = compResponse.toLowerCase().replaceAll(i, "youx").replaceAll(me, "youx").replaceAll(am, are).replaceAll(you, "ix").replaceAll(my, "yourx").replaceAll(your, my).replaceAll(mine, "yoursx").replaceAll(yours, mine);
      //Below is included to replace the modified replacements
      compResponse = compResponse.replaceAll("youx",you).replaceAll("ix"," I ").replaceAll("yourx",your).replaceAll("yoursx",yours);
      //Replaces any punctuation
      compResponse = compResponse.replace(".","?").replace("!","?");
      //Take out any white space at the start and end
      compResponse = compResponse.trim();
      System.out.println(compResponse);
      count += 1;
    }
    
    userinput.close();

///delete spaces at the beginning and end
///if punctuation at the end, replace with "?"
///if no punctuation at end, add "?"
///if sentence starts with one of the pronouns, recognize it even though it doesn't start with a space
  }
}
