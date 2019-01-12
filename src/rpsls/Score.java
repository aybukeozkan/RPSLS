package rpsls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Score {
    String temp = "";
    int tempScore = 0;

    File file = new File("scores.txt");

    public Score(){

    }
    public void writeScore(){    //Write the scores into a text file
        try{
            PrintWriter output = new PrintWriter(new FileWriter(file, true));
            output.print(Homepage.userName);
            output.print(" ");
            output.println(GamePanel.score1);
            output.close();
        } catch (Exception ex){
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    public void readScore(){     //Read scores from the text file

        try{
            Scanner input = new Scanner(file);

            String name;
            int i = 0;
            int[] score = new int[10];
            String[] player = new String[10];

            while (input.hasNext()) {     //Write the names and scores into an array
                name = input.next();
                score[i] = input.nextInt();
                player[i] = name + " - " + score[i];
                ++i;
            }
            for(int j = 0; j <= i; j++){      //Sort the scores from highest to lowest
                for(int k = 0; k <= i; k++){
                    if(j > k){
                        if(score[j] > score[k]){
                            temp = player[k];
                            player[k] = player[j];
                            player[j] = temp;

                            tempScore = score[k];
                            score[k] = score[j];
                            score[j] = tempScore;
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(null, player, "HIGH SCORES", JOptionPane.INFORMATION_MESSAGE);  //Show scores in a frame
            input.close();
        } catch (Exception ex){
            System.out.printf("ERROR: %s\n", ex);
        }

    }

    public void clearFile(){   //Clear the text file when exiting
        try{
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException ex){
            System.out.printf("ERROR: %s\n", ex);
        }
    }
}
