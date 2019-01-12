package rpsls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JFrame{
    public static int score1 = 0;
    public static int score2 = 0;

    Score scoreObj = new Score();

    int remainingNum = 10;

    int choice1 = 0;
    int choice2 = 0;

    public JLabel result = new JLabel();
    public JLabel remaining = new JLabel();

    //Choice images
    public JLabel yourChoiceImg = new JLabel();
    public JLabel compChoiceImg = new JLabel();

    //Score labels
    public JLabel yourScore = new JLabel();
    public JLabel compScore = new JLabel();


    //Panel for buttons and scores
    public JPanel topPanel = new JPanel();
    public JPanel scorePanel = new JPanel();
    public JPanel buttonPanel = new JPanel();

    //Buttons and Images
    public ImageIcon rockImg = new ImageIcon("rock.png");
    public JButton rock = new JButton(rockImg);

    public ImageIcon paperImg = new ImageIcon("paper.png");
    public JButton paper = new JButton(paperImg);

    public ImageIcon scissorsImg = new ImageIcon("scissors.png");
    public JButton scissors = new JButton(scissorsImg);

    public ImageIcon lizardImg = new ImageIcon("lizard.png");
    public JButton lizard = new JButton(lizardImg);

    public ImageIcon spockImg = new ImageIcon("spock.png");
    public JButton spock = new JButton(spockImg);

    //Result icons
    public ImageIcon won = new ImageIcon("won.png");
    public ImageIcon lost = new ImageIcon("lost.png");
    public ImageIcon tie = new ImageIcon("tie.png");

    public GamePanel(){
        createButtonPanel();
        createScorePanel();
        createTopPanel();

        setResizable(false);
        add(topPanel, BorderLayout.NORTH);
    }


    public void createTopPanel(){       //Create top panel
        topPanel.setLayout(new BorderLayout());
        topPanel.add(scorePanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public void createScorePanel(){      //Create score panel
        scorePanel.setLayout(new BorderLayout());
        scorePanel.setBackground(new Color(225, 238, 246));

        //User's score number
        yourScore.setText("Your Score: " + score1);
        yourScore.setFont(new Font("Arial", Font.BOLD, 18));
        yourScore.setForeground(new Color(18, 54, 80));
        scorePanel.add(yourScore, BorderLayout.WEST);

        //Computer's score number
        compScore.setText("Computer's Score: " + score2);
        compScore.setFont(new Font("Arial", Font.BOLD,18));
        compScore.setForeground(new Color(18, 54, 80));
        scorePanel.add(compScore, BorderLayout.EAST);
    }

    public void createButtonPanel(){      //Create button panel

        ////////rock     --> 1
        ////////paper    --> 2
        ////////scissors --> 3
        ////////lizard   --> 4
        ////////spock    --> 5

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(225, 238, 246));

        //Rock Button
        rock.setBackground(null);
        rock.setBorderPainted(false);
        buttonPanel.add(rock);
        rock.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice1 = 1;
                showChoice();
                computersChoice();
                compare();
                isWon();
            }
        });

        //Paper Button
        paper.setBackground(null);
        paper.setBorderPainted(false);
        buttonPanel.add(paper);
        paper.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice1 = 2;
                showChoice();
                computersChoice();
                compare();
                isWon();
            }
        });

        //Scissors Button
        scissors.setBackground(null);
        scissors.setBorderPainted(false);
        buttonPanel.add(scissors);
        scissors.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice1 = 3;
                showChoice();
                computersChoice();
                compare();
                isWon();
            }
        });

        //Lizard Button
        lizard.setBackground(null);
        lizard.setBorderPainted(false);
        buttonPanel.add(lizard);
        lizard.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice1 = 4;
                showChoice();
                computersChoice();
                compare();
                isWon();
            }
        });

        //Spock Button
        spock.setBackground(null);
        spock.setBorderPainted(false);
        buttonPanel.add(spock);
        spock.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                choice1 = 5;
                showChoice();
                computersChoice();
                compare();
                isWon();
            }
        });

    }
    public void showChoice(){      //Show the user's choice
        switch(choice1){
            case 1:
                yourChoiceImg.setIcon(rockImg);
                break;
            case 2:
                yourChoiceImg.setIcon(paperImg);
                break;
            case 3:
                yourChoiceImg.setIcon(scissorsImg);
                break;
            case 4:
                yourChoiceImg.setIcon(lizardImg);
                break;
            case 5:
                yourChoiceImg.setIcon(spockImg);
                break;
        }
    }
    public void computersChoice(){        //Show the computer's choice
        Random random = new Random();
        choice2 = random.nextInt(6);     //Choose it randomly

        switch(choice2){
            case 1:
                compChoiceImg.setIcon(rockImg);
                break;
            case 2:
                compChoiceImg.setIcon(paperImg);
                break;
            case 3:
                compChoiceImg.setIcon(scissorsImg);
                break;
            case 4:
                compChoiceImg.setIcon(lizardImg);
                break;
            case 5:
                compChoiceImg.setIcon(spockImg);
                break;
        }
    }
    public void compare(){     //Compare the choices

        setRemaining();

        switch(choice1){
            case 1: //ROCK
                if(choice2 == 1){   //Rock vs. Rock
                    result.setIcon(tie);
                }
                else if(choice2 == 2){   //Rock vs. Paper
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 3){   //Rock vs. Scissors
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 4){   //Rock vs. Lizard
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else{   //Rock vs. Spock
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                break;

            case 2: //PAPER
                if(choice2 == 1){   //Paper vs. Rock
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 2){   //Paper vs. Paper
                    result.setIcon(tie);
                }
                else if(choice2 == 3){   //Paper vs. Scissors
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 4){   //Paper vs. Lizard
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else{   //Paper vs. Spock
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                break;
            case 3: //SCISSORS
                if(choice2 == 1){   //Scissors vs. Rock
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 2){   //Scissors vs. Paper
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 3){   //Scissors vs. Scissors
                    result.setIcon(tie);
                }
                else if(choice2 == 4){   //Scissors vs. Lizard
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else{   //Scissors vs. Spock
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                break;
            case 4: //LIZARD
                if(choice2 == 1){   //Lizard vs. Rock
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 2){   //Lizard vs. Paper
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 3){   //Lizard vs. Scissors
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 4){   //Lizard vs. Lizard
                    result.setIcon(tie);
                }
                else{   //Lizard vs. Spock
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                break;
            case 5: //SPOCK
                if(choice2 == 1){   //Spock vs. Rock
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 2){   //Spock vs. Paper
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else if(choice2 == 3){   //Spock vs. Scissors
                    result.setIcon(won);
                    ++score1;
                    setScore();
                }
                else if(choice2 == 4){   //Spock vs. Lizard
                    result.setIcon(lost);
                    ++score2;
                    setScore();
                }
                else{   //Spock vs. Spock
                    result.setIcon(tie);
                }
                break;
        }
    }
    public void setRemaining(){      //Set the remaining game number
        --remainingNum;
        remaining.setText("Remaining Game: " + remainingNum);
    }

    public void setScore(){      //Set the score
        yourScore.setText("Your Score: " + score1);
        compScore.setText("Computer's Score: " + score2);
    }

    public void isWon(){     //Check whether the user won or lost the game

        if(remainingNum == 0){
            scoreObj.writeScore();
            Homepage obj = new Homepage();
            if (score1 > score2){     //User won
                int input = JOptionPane.showConfirmDialog (null, "You won the game!\n Do you want to return to the menu?",
                        "Bazinga!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(input  == JOptionPane.YES_OPTION){
                    super.dispose();
                    obj.setVisible(true);
                }
                else if(input  == JOptionPane.NO_OPTION || input == JOptionPane.CLOSED_OPTION){
                    super.dispose();
                    scoreObj.clearFile();
                }
            }
            else if (score1 < score2){    //User lost
                int input = JOptionPane.showConfirmDialog (null, "You lost the game!\n Do you want to return to the menu?",
                        "Bazinga!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(input  == JOptionPane.YES_OPTION){
                    super.dispose();
                    obj.setVisible(true);
                }
                else if(input  == JOptionPane.NO_OPTION || input == JOptionPane.CLOSED_OPTION){
                    super.dispose();
                    scoreObj.clearFile();
                }
            }
            else if (score1 == score2){     //Tie
                int input = JOptionPane.showConfirmDialog (null, "There is a tie!\n Do you want to return to the menu?",
                        "Bazinga!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(input  == JOptionPane.YES_OPTION){
                    super.dispose();
                    obj.setVisible(true);
                }
                else if(input  == JOptionPane.NO_OPTION || input == JOptionPane.CLOSED_OPTION){
                    super.dispose();
                    scoreObj.clearFile();
                }
            }
            score1 = 0;
            score2 = 0;
        }
    }
}
