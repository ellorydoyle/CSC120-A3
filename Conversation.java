import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class Conversation {
  public static void main(String[] arguments) {
    // you will start the conversation here.
    String userResponse="";
    String compResponse="";
    ArrayList<String> cannedResponses = new ArrayList<String>();
    cannedResponses.add("Mhm");
    cannedResponses.add("Why don't you tell me more");
    cannedResponses.add("Can you tell me more");
  
    Scanner userinput = new Scanner(System.in);
    System.out.println("How many rounds of conversation do you want to have?");
    int rounds = userinput.nextInt();
    rounds = rounds+1;
      if (rounds <= 0) {
        System.out.println("Sorry, please input a valid number.");
      }
    ArrayList<String> transcript = new ArrayList<String>();
    System.out.println("Understood.");
    transcript.add("Hey there! What are you thinking about?");
    System.out.println("Hey there! What are you thinking about?"); 
    for (int i = 0; i < rounds; i++){
      userResponse = userinput.nextLine();
      transcript.add(userResponse);
      //Adds a space at the beginning so that pronouns at the beginning are recognized
      String[] words = userResponse.split(" ");
      for (int j=0; j<words.length; j++){
          //Some of the replacements are modified because those replacements would be incorrectly replaced otherwise
        if (words[j].equalsIgnoreCase("I")) {
          //Some of the replacements are modified because those replacements would be incorrectly replaced otherwise
          words[j]="you";
        }
        else if (words[j].equalsIgnoreCase("me")) {
          words[j]="you";
        }
        else if (words[j].equalsIgnoreCase("am")) {
          words[j]="are";
        }
        else if (words[j].equalsIgnoreCase("are")) {
          words[j]="am";
        }
        else if (words[j].equalsIgnoreCase("you")) {
          words[j]="I";;
        }
        else if (words[j].equalsIgnoreCase("my")) {
          words[j]="your";
        }
        else if (words[j].equalsIgnoreCase("your")) {
          words[j]="my";
        }
        else{
          words[j]=words[j];
        }
        compResponse = compResponse+" "+ words[j];
        compResponse = compResponse.trim();
        if (compResponse.equals(userResponse)){
          Random random_method = new Random();
          for (int k = 0; k < cannedResponses.size(); k++) {
            int index = random_method.nextInt(cannedResponses.size());
            compResponse = cannedResponses.get(index);
        }}
        if (i==0){
          compResponse = "";
        }
      }
      if (compResponse.contains(".")){
        compResponse = compResponse.replace(".","");
      }
      if (compResponse.contains("!")){
        compResponse = compResponse.replace("!","");}
      if (!compResponse.contains("?")&&(!compResponse.isEmpty())){
        compResponse = compResponse+"?";
      }
      if (!compResponse.isEmpty()){
        compResponse = compResponse.substring(0,1).toUpperCase()+compResponse.substring(1);
      }
      System.out.println(compResponse);
      transcript.add(compResponse);
      compResponse = "";
    }
    System.out.println("Goodbye!");
  userinput.close();
  }
}


