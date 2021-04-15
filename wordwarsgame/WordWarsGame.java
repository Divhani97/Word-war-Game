
package wordwarsgame;

import java.util.Scanner;

public class WordWarsGame {
//declering variable for the alphabets
private static String alphabets="a b c d e f g h i j k l m n o p q  r s t u v w x y z";
//declering variable for the player word
private static String playedWord="";
// private static String updatedLetters=" ";
//declering variable that stores used letters
private static String usedLetters="";
//declering variables for the player names
private static String name1;
private static String name2;
//declering variabl that allows us to swap the names of the players
private static int playerNumber=1;
//variable to update alphabet
private static boolean playersAgree=true;
private static String currentPlayer; 
//decering variables for the players scores
private static int p1=0;
private static int p2=0;
//creating scanner object for keybord user input    
static Scanner vhona=new Scanner(System.in);

    public static void main(String[] args) 
    {// TODO code application logic here
         System.out.print("Welcome to the Word WAR Game"+
                         "\nPRESS (1) TO START THE GAME"+
                         "\nPRESS ANY OTHER KEY TO EXIT"+
                      "\n" + "\nENTER YOUR SELECTION : " ); 
        //declering variable for the game initiation selection.
        String selection;
        selection = vhona.next();
        //
        if(selection.equals("1"))
        {
         //to input the name of player 1.
         System.out.print("*************************"
                       + "*************************"+ 
                         "\nENTER PLAYER 1 NAME : ");
         name1=vhona.next();
         
        //to input the name for player 2.
        System.out.print("\nENTER PLAYER 2 NAME: ");
        name2=vhona.next();
        
        //calling a method to start the game.
        PlayTheGame();
        }
        else
        {
         System.exit(0);
        }
     
}
    //this method starts the game.
    private static void PlayTheGame()
    {
        //to display the welcome message of the game. 
        System.out.print("\nLETS PLAY THE WORD WARS GAME!!!");
        /*If a player cannot create a word, they are required 
        to enter in a sentinel value of three questionmarks “???”
        when th player doesnt enter "???",the game proceeds
        */
        
        //while loop to loop the game
        while(!playedWord.equals("???"))
        {
            //method call to determine the current player
            TheCurrentPlayer();
            System.out.print("\nAlphabet Letters Left : "+updateAlpha()+ "\n");
            System.out.print(currentPlayer+" Enter Your Word : ");
            playedWord=new Scanner(System.in).next();
             
            //method call to validate player word
            ConfirmPlayrWord();   
        }
            //calling a method to display the scores
            DisplayScores();
    }
    
    //this method shows that only vowels are not removed from the alphabet list
    private static void vowelsTrim() 
    {
    //declare local variable to hold the vowels
    String vowels="aeiou";
        //looping through played word
        for(int i=0;i<playedWord.toCharArray().length;i++)
        {
          if(vowels.contains( (playedWord.toCharArray()[i]+"") )  )
            {
              playedWord=playedWord.replace((playedWord.toCharArray()[i]+""),"");
            }
        }
    }
    
    //this method to confirm the players entered word
    private static void ConfirmPlayrWord() 
    {
 System.out.print("\n ENTER (Y) IF BOTH PLAYERS AGREE ON THE WORD"+
                         "OR ENTER ANY KEY IF THEY DISAGREE : ");
        
        if(new Scanner(System.in).next().equalsIgnoreCase("Y"))
        {
                    //calling method to search for used letters.
                    usedLetterSearch();
                    //method call for the vowel list.
                    vowelsTrim();
                    //calling method to determine player score.
                    DetermineScore();
        }
        else
        {
        playedWord="";
        }
    }
    
    //this method determines the current player
    private static void TheCurrentPlayer() {
     if(playerNumber==1)
       {
         currentPlayer=name1;
         playerNumber+=1;
       } 
       else
       {
         currentPlayer=name2;
         playerNumber-=1;
       }
    }
    //this method updates the the letters of the aplhabet
    private static String updateAlpha()
    {
     if(playersAgree==true)
     {
        //a for loop to loop through the alphabet list
                for (int i=0;i<alphabets.toCharArray().length;i++)
                {
                    //to get the alphabets used
                  if(playedWord.contains( (alphabets.toCharArray()[i]+"")  ))
                  {
                     usedLetters+=(alphabets.toCharArray()[i]+""); 
                  alphabets=alphabets.replace((alphabets.toCharArray()[i]+""), "_");
                  }
                }
        }
        else
        {
       System.out.print("\nSorry !! THE PLAYED WORD CONTAINS USED LETTERS OR IT IS NOT VALID!! ");
       playersAgree=true;
        }
       return alphabets;   
    }
    //this method searches for the letters used
    private static void usedLetterSearch()
    {
        //loop to loop through our used letters
      for(int i=0;i<usedLetters.toCharArray().length;i++)
      {
        if(playedWord.contains( (usedLetters.toCharArray()[i]+"")))
        {
          playersAgree=false;
            if (playedWord.contains( (usedLetters.toCharArray()[i]+""))) 
             {}
        }
      } 
    }
    
    //this method displays the player scores
    private static void DisplayScores() 
    {
     System.out.print(name1 + " score " + p1+"\n"+name2+ " score " + p2 );
    }
    
    //mehtod to determine the players score
    private static void DetermineScore() 
    {
       //checking the name of the current player 
       if(currentPlayer.equals(name1)&& !playedWord.equals("???"))
          {
           p1+=1;
          }
      //for the second player
      if(currentPlayer.equals(name2)&& !playedWord.equals("???"))
         {
          p2+=1;
         }
    }
}