import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class TicTacToeGUI extends JFrame {

    private Container pane;
    JPanel centerPanel;

    private JMenuBar menuBar;
    private JMenu menu;
    private JButton resetMenu;
    private JButton quit;

    private JLabel playerXscore;
    private JLabel playerOscore;


    private int scoreOfX;
    private int scoreOfO;

    private JButton [][] board;

    private boolean hasWinner;
    private String currentPlayer;

    public TicTacToeGUI(){
        super("TicTacToe");

        pane = getContentPane();
        pane.setLayout(new GridLayout(3,3));

        currentPlayer = "x";
        hasWinner = false;

        board = new JButton[3][3];

        scoreOfX = 0;
        scoreOfO = 0;

        // Make window exit application on close
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Set display size
        setSize(500,500);
        // Center the frame to middle of screen
        setLocationRelativeTo(null);
        // Disable resize
        setResizable(false);
        setVisible(true);

        initializeMenuBar();
        initializeBoard();

    }



    public void resetScore(){
        scoreOfX = 0;
        scoreOfO = 0;

        playerXscore.setText("Score of x is " + scoreOfX);
        playerOscore.setText("Score of O is " + scoreOfO);
    }

    public void resetBoard(){
        currentPlayer = "x";
        hasWinner = false;

        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j].setText("");
            }
        }
    }

    public void togglePlayer(){
        if(Objects.equals(currentPlayer, "x")){
            currentPlayer = "o";
        }
        else{
            currentPlayer = "x";
        }
    }

    public void initializeBoard(){
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                JButton btn =  new JButton();
                board[i][j]= btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(((JButton)e.getSource()).getText().isEmpty() && !hasWinner){
                            btn.setText(currentPlayer);
                            hasWinner();
                            togglePlayer();
                        }
                    }
                });
                pane.add(btn);
            }
        }
    }

    public void initializeMenuBar(){
        menuBar = new JMenuBar();

        resetMenu = new JButton("Reset All");
        resetMenu.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
                resetScore();
            }
        });

        quit = new JButton("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(resetMenu);
        menuBar.add(quit);

        playerOscore = new JLabel("Score of x is " + scoreOfX);
        playerXscore = new JLabel("Score of o is " + scoreOfO);

        menuBar.add(playerXscore);
        menuBar.add(playerOscore);

        setJMenuBar(menuBar);

    }

    public void updateScore(){
        if(Objects.equals(currentPlayer, "x")){
            scoreOfX++;
            playerXscore.setText("Score of x is " + scoreOfX);
        }
        else{
            scoreOfO++;
            playerOscore.setText("Score of O is " + scoreOfO);
        }
    }

    public void hasWinner(){
        if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) && board[0][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }
        else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }
        else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }
        else if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][2].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }else if(board[0][2].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) && board[2][0].getText().equals(currentPlayer)){
            JOptionPane.showMessageDialog(null, currentPlayer + "has won the game");
            hasWinner = true;
        }

        if(hasWinner){
            updateScore();
            resetBoard();
        }
    }
}
