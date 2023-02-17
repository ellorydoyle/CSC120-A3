/**
 * Just letting you know, I had issues with the scanner. The scanner kept reading an input that didn't exist before the user gets to input anything.
 * To combat this, I increase the round count by one and clear any possible responses that may come before the user gets to type a response.
 * I also prevent those wrongly scanned blanks from appearing on the transcript.
 * I'm sorry if this impacts the grading process negatively
 */

/**
 *  Filename: Conversation.java
    Description: A Chatbot!
    Author: Ellory Doyle (@ellorydoyle)
    Date: 17 February 2023
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 * The conversation class, everything happens in here.
 */
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
      //Preventing the transcript from adding the improperly scanned inputs
      if (i>0){transcript.add(userResponse);}
      String[] words = userResponse.split(" ");
      for (int j=0; j<words.length; j++){
        if (words[j].equalsIgnoreCase("I")) {
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
        //Preventing the terminal from printing a response in the first round because the scanner is not working correctly
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
      //Preventing the transcript from adding the improperly scanned inputs
      if(i>0){transcript.add(compResponse);}
      compResponse = "";
    }
    System.out.println("Goodbye!");
    transcript.add("Goodbye!");
    System.out.println(transcript);
  userinput.close();
  }
}


