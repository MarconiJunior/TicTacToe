import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener {

    Random random = new Random();

    JFrame frame = new JFrame();

    JPanel title_panel = new JPanel();

    JPanel button_panel = new JPanel();

    JLabel textfield = new JLabel();

    JButton[] buttons = new JButton[9];


    boolean player1_turn;


    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(new Color(153,50,204));
        textfield.setForeground(new Color(255,250,240));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);



        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);



        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(240,248,255));








        for(int i = 0;i < 9;i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0;i < 9; i++) {

            if(e.getSource()==buttons[i]) {

                if(player1_turn) {

                    if(buttons[i].getText()== "") {

                        buttons[i].setForeground(new Color(178,34,34));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setText("O turn");
                        check();

                    }

                }

                else {

                    if(buttons[i].getText()== "") {

                        buttons[i].setForeground(new Color(75,0,130));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setText("X turn");
                        check();

                    }
                }

            }
        }

    }

    public void firstTurn() {



        if(random.nextInt(2)==0) { //se o número aleatório for igual a 0, o turno do player 1 será verdadeiro e será a vez do X, se não o turno do player 1 será falso e será a vez da O

            player1_turn=true;
            textfield.setText("X turn");

        }

        else {

            player1_turn=false;
            textfield.setText("O turn");

        }
    }


    public void check() {
        //checar a condição de vitória do X
        if (
                (buttons[0].getText()=="X")&&
                        (buttons[1].getText()=="X")&&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);
        } if (
                (buttons[3].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        } if (
                (buttons[6].getText()=="X")&&
                        (buttons[7].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        } if (
                (buttons[0].getText()=="X")&&
                        (buttons[3].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        } if (
                (buttons[1].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        } if (
                (buttons[2].getText()=="X")&&
                        (buttons[5].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        } if (
                (buttons[0].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        } if (
                (buttons[2].getText()=="X")&&
                        (buttons[4].getText()=="X")&&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
        //checar a condição de vitória do O
        if (
                (buttons[0].getText()=="O")&&
                        (buttons[1].getText()=="O")&&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        } if (
                (buttons[3].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        } if (
                (buttons[6].getText()=="O")&&
                        (buttons[7].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        } if (
                (buttons[0].getText()=="O")&&
                        (buttons[3].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        } if (
                (buttons[1].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        } if (
                (buttons[2].getText()=="O")&&
                        (buttons[5].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        } if (
                (buttons[0].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        } if (
                (buttons[2].getText()=="O")&&
                        (buttons[4].getText()=="O")&&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }
        //check draw
        if (
                ((buttons[0].getText()=="O")||(buttons[0].getText()=="X"))&&
                        ((buttons[1].getText()=="O")||(buttons[1].getText()=="X"))&&
                        ((buttons[2].getText()=="O")||(buttons[2].getText()=="X"))&&
                        ((buttons[3].getText()=="O")||(buttons[3].getText()=="X"))&&
                        ((buttons[4].getText()=="O")||(buttons[4].getText()=="X"))&&
                        ((buttons[5].getText()=="O")||(buttons[5].getText()=="X"))&&
                        ((buttons[6].getText()=="O")||(buttons[6].getText()=="X"))&&
                        ((buttons[7].getText()=="O")||(buttons[7].getText()=="X"))&&
                        ((buttons[8].getText()=="O")||(buttons[8].getText()=="X"))

        ) {
            draw();
        }
    }

    public void xWins(int a,int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
        confirmDialog();

    }

    public void oWins(int a,int b, int c) {

        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i<9; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
        confirmDialog();

    }

    public void draw() {

        for (int i = 0; i<9; i++) {
            buttons[i].setEnabled(false);
            buttons[i].setBackground(new Color (255, 228, 181));
        }
        textfield.setText("Draw");
        confirmDialog();
    }

    public void resetGame() {
        firstTurn();
        for (int i = 0; i<9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
            buttons[i].setBackground(Color.WHITE);
        }

    }

    public void confirmDialog() {
        int confirm = JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Escolha a Opção", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            resetGame();
        } else {
            System.exit(1);
        }
    }
}
