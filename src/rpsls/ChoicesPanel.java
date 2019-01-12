package rpsls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChoicesPanel extends GamePanel{

    //Panel for choices
    public JPanel bottomPanel = new JPanel();
    public JPanel choicePanel = new JPanel();
    public JPanel remainingPanel = new JPanel();

    //Label images
    public ImageIcon choice1 = new ImageIcon("yourchoice.png");
    public ImageIcon choice2 = new ImageIcon("compchoice.png");

    //Choice labels
    public JLabel yourChoice = new JLabel(choice1);
    public JLabel compChoice = new JLabel(choice2);



    public ChoicesPanel(){
        //Set the game frame
        setTitle("Rock-Paper-Scissors-Lizard-Spock");
        setSize(750,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createRemaining();
        createChoices();
        createBottomPanel();

        add(bottomPanel, BorderLayout.CENTER);
    }

    public void createBottomPanel(){      //Create bottom panel
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(choicePanel, BorderLayout.CENTER);
        bottomPanel.add(remainingPanel, BorderLayout.SOUTH);
    }

    public void createChoices(){          //Create choices panel
        choicePanel.setLayout(null);
        choicePanel.setBackground(new Color(225, 238, 246));

        //Your choice
        yourChoice.setSize(200,70);
        yourChoice.setLocation(70, 50);
        yourChoiceImg.setSize(108,108);
        yourChoiceImg.setLocation(120, 120);
        choicePanel.add(yourChoice);
        choicePanel.add(yourChoiceImg);

        //Computer's choice
        compChoice.setSize(200,70);
        compChoice.setLocation(450, 50);
        compChoiceImg.setSize(108,108);
        compChoiceImg.setLocation(508, 120);
        choicePanel.add(compChoice);
        choicePanel.add(compChoiceImg);

        //Result
        result.setSize(200,70);
        result.setLocation(270, 150);
        choicePanel.add(result);

    }
    public void createRemaining(){       //Display number of remaining game
        remainingPanel.setLayout(new BorderLayout());
        remainingPanel.setBackground(new Color(225, 238, 246));

        //Number of remaining game
        remaining.setText("Remaining Game: " + remainingNum);
        remaining.setHorizontalAlignment(0);
        remaining.setFont(new Font("Arial", Font.BOLD, 20));
        remaining.setForeground(new Color(18, 54, 80));
        remainingPanel.add(remaining, BorderLayout.CENTER);

    }

}
