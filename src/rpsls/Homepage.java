package rpsls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Homepage extends JFrame implements ActionListener{

    Score scoreObj = new Score();

    Timer t = new Timer(30, this);
    int y1 = 150, velY = 2;
    int y2 = 200, velY2 = 2;

    public static String userName;

    JPanel panel = new JPanel();

    ImageIcon icon = new ImageIcon("header.png");
    JLabel header = new JLabel(icon);

    ImageIcon play = new ImageIcon("playbutton.png");
    ImageIcon play2 = new ImageIcon("playbutton2.png");

    ImageIcon highscore = new ImageIcon("scorebutton.png");
    ImageIcon highscore2 = new ImageIcon("scorebutton2.png");

    ImageIcon rules = new ImageIcon("rulesbutton.png");
    ImageIcon rules2 = new ImageIcon("rulesbutton2.png");

    ImageIcon exit = new ImageIcon("exitbutton.png");
    ImageIcon exit2 = new ImageIcon("exitbutton2.png");

    //Moving icons
    ImageIcon rockIcon = new ImageIcon("1.png");
    JLabel rock = new JLabel(rockIcon);
    ImageIcon paperIcon = new ImageIcon("2.png");
    JLabel paper = new JLabel(paperIcon);
    ImageIcon scissorsIcon = new ImageIcon("3.png");
    JLabel scissors = new JLabel(scissorsIcon);
    ImageIcon lizardIcon = new ImageIcon("4.png");
    JLabel lizard = new JLabel(lizardIcon);
    ImageIcon spockIcon = new ImageIcon("5.png");
    JLabel spock = new JLabel(spockIcon);

    ImageIcon icon2 = new ImageIcon("rulestext.png");

    JButton newGameBtn = new JButton(play);
    JButton highScoreBtn = new JButton(highscore);
    JButton rulesBtn = new JButton(rules);
    JButton exitBtn = new JButton(exit);


    public Homepage(){
        showHomepage();
        t.start();
    }
    public void showHomepage(){       //Create the Homepage
        setTitle("Rock-Paper-Scissors-Lizard-Spock");
        setLayout(new BorderLayout());
        setSize(800,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        //Set the panel
        panel.setLayout(null);
        panel.setBackground(new Color(211, 232, 225));
        add(panel);

        //Set the ""Wanna Play?" header
        header.setSize(450,100);
        header.setLocation(175,50);
        panel.add(header);

        //Set the moving images
        rock.setSize(130,40);
        rock.setLocation(20,y1);
        panel.add(rock);

        paper.setSize(130,40);
        paper.setLocation(160,y2);
        panel.add(paper);

        scissors.setSize(170,40);
        scissors.setLocation(300,y1);
        panel.add(scissors);

        lizard.setSize(130,40);
        lizard.setLocation(480,y2);
        panel.add(lizard);

        spock.setSize(130,40);
        spock.setLocation(620,y1);
        panel.add(spock);

        //Set the New Game button
        newGameBtn.setLocation(315, 300);
        newGameBtn.setSize(150, 50);
        newGameBtn.setBorderPainted(false);
        newGameBtn.setBackground(null);
        panel.add(newGameBtn);
        newGameBtn.addMouseListener(new MouseAdapter() {     //Changing the color of button
            public void mouseEntered(MouseEvent e) {
                newGameBtn.setIcon(play2);
            }

            public void mouseExited(MouseEvent e) {
                newGameBtn.setIcon(play);
            }
        });


        newGameBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){       //Create new game
                getName();
                ChoicesPanel game = new ChoicesPanel();
                game.setVisible(true);
                dispose();
            }
        });

        //Set the New Game button
        highScoreBtn.setLocation(290, 350);
        highScoreBtn.setSize(200, 50);
        highScoreBtn.setBorderPainted(false);
        highScoreBtn.setBackground(null);
        panel.add(highScoreBtn);
        highScoreBtn.addMouseListener(new MouseAdapter() {     //Changing the color of button
            public void mouseEntered(MouseEvent e) {
                highScoreBtn.setIcon(highscore2);
            }

            public void mouseExited(MouseEvent e) {
                highScoreBtn.setIcon(highscore);
            }
        });

        highScoreBtn.addActionListener(new ActionListener(){   //Display the score table
            public void actionPerformed(ActionEvent e){
                scoreObj.readScore();
            }
        });

        //Set the New Game button
        rulesBtn.setLocation(315, 400);
        rulesBtn.setSize(150, 50);
        rulesBtn.setBorderPainted(false);
        rulesBtn.setBackground(null);
        panel.add(rulesBtn);
        rulesBtn.addMouseListener(new MouseAdapter() {     //Changing the color of button
            public void mouseEntered(MouseEvent e) {
                rulesBtn.setIcon(rules2);
            }

            public void mouseExited(MouseEvent e) {
                rulesBtn.setIcon(rules);
            }
        });

        rulesBtn.addActionListener(new ActionListener(){     //Display the rules
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, icon2, "Rules", JOptionPane.PLAIN_MESSAGE);
            }
        });

        //Set the Exit button
        exitBtn.setLocation(315, 450);
        exitBtn.setSize(150, 50);
        exitBtn.setBorderPainted(false);
        exitBtn.setBackground(null);
        panel.add(exitBtn);
        exitBtn.addMouseListener(new MouseAdapter() {      //Changing the color of button
            public void mouseEntered(MouseEvent e) {
                exitBtn.setIcon(exit2);
            }

            public void mouseExited(MouseEvent e) {
                exitBtn.setIcon(exit);
            }
        });
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){     //Exit the game
                scoreObj.clearFile();
                System.exit(0);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {     //Moving weapon images
        if (y1 < 150 || y1 > 200){
            velY = -velY;
        }
        y1 += velY;
        rock.setLocation(20,y1);
        scissors.setLocation(300,y1);
        spock.setLocation(620,y1);

        if (y2 < 200 || y2 > 150){
            velY2 = -velY2;
        }
        y2 -= velY;
        paper.setLocation(160,y2);
        lizard.setLocation(480,y2);
    }
    public String getName(){      //Get the username as an input
        String name = JOptionPane.showInputDialog(null, "Enter your user name please: ", "User Name", JOptionPane.QUESTION_MESSAGE );
        if (name == null || name.compareTo("") == 0 || name.compareTo(" ") == 0){
            JOptionPane.showMessageDialog(null, "You must enter a user name!", "User Name", JOptionPane.INFORMATION_MESSAGE);
            getName();
        }
        if(name != null && name.compareTo("") != 0 && name.compareTo(" ") != 0){
            userName = name;
        }
        return userName;
    }
}
