import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TickTackToe implements ActionListener {

    Random random = new Random();
    ImageIcon icon = new ImageIcon("ticktacttoe.png");

    JFrame frame = new JFrame(); //creates a window frame
    JPanel title_panel = new JPanel(); // creates a panel in a frame
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9]; //declares nine button
    JMenuBar menubar = new JMenuBar();

    JMenuItem newgame = new JMenuItem("NewGame");



    boolean player1_turn;

    //constructor
    TickTackToe() {

        //setting frame attributes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setIconImage(icon.getImage());
        frame.setResizable(false);
        frame.setTitle("Tic-Tac-Toe");

        //setting text attribute that shows on top of buttons in title_panel
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TictTacToe");
        textfield.setOpaque(true);

        //setting title panel that shows on top
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 500, 100);
        title_panel.add(textfield);

        //adding buttons to the frame via next panel
        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(149, 149, 149));
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);


        }

        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setJMenuBar(menubar);
        menubar.add(newgame);
        newgame.addActionListener(this);
        frame.setVisible(true);

        FirstTurn();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==newgame){
            frame.dispose();
            new TickTackToe();
        }

        for(int i=0;i<9;i++) {
            if(e.getSource()==button[i]) {
                if(player1_turn) {
                    if(button[i].getText()=="") {
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O's turn");
                        CheckWin("X");
                    }
                }
                else{
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0, 0, 255));
                        button[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X's turn");
                        CheckWin("O");
                    }
                }

            }

        }
    }

    public void FirstTurn() {

        try {
            Thread.sleep(1000);// to display ticttactoe for 2sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //to determine whose turn is first
        if (random.nextInt(10) <= 5) {
            player1_turn = true;
            textfield.setText("X's turn");
        } else {
            player1_turn = false;
            textfield.setText("O's turn");
        }

    }


    public void CheckWin(String a) {


                if (
                        (button[0].getText() == button[1].getText()) &&
                                (button[1].getText() == button[2].getText()) &&
                                        (button[0].getText() == a)
                                ) {
                    Win(0, 1, 2);
                }
                if (

                        (button[3].getText() == button[4].getText()) &&
                                (button[4].getText() == button[5].getText()) &&
                                (button[3].getText() == a)
                ) {
                    Win(3, 4, 5);
                }
                if (

                        (button[6].getText() == button[7].getText()) &&
                                (button[7].getText() == button[8].getText()) &&
                                 (button[6].getText() == a)
                ) {
                    Win(6, 7, 8);
                }
                if (

                        (button[0].getText() == button[3].getText()) &&
                                (button[3].getText() == button[6].getText()) &&
                                (button[0].getText() == a)
                ) {
                    Win(0, 3, 6);
                }
                if (

                        (button[1].getText() == button[4].getText()) &&
                                (button[4].getText() == button[7].getText()) &&
                                (button[1].getText() == a)
                ) {
                    Win(1, 4, 7);
                }
                if (

                        (button[2].getText() == button[5].getText()) &&
                                (button[5].getText() == button[8].getText()) &&
                                (button[2].getText() == a)
                ) {
                    Win(2, 5, 8);
                }
                if (
                        (button[0].getText() == button[4].getText()) &&
                                (button[4].getText() == button[8].getText()) &&
                                (button[0].getText() == a)
                ) {
                    Win(0, 4, 8);
                }
                if (
                        (button[2].getText() == button[4].getText()) &&
                                (button[4].getText() == button[6].getText()) &&
                                (button[2].getText() == a)
                ) {
                    Win(2, 4, 6);
                }
            }


    public void Win(int a, int b, int c) {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++) {
            button[i].setEnabled(false);
        }
        textfield.setText(button[a].getText() + "Wins");
    }

}

