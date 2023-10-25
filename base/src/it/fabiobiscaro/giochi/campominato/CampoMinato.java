package it.fabiobiscaro.giochi.campominato;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CampoMinato extends JFrame implements ActionListener, MouseListener {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 10;

    private static final int COVERED_CELL = 0;
    private static final int UNCOVERED_CELL = 1;
    private static final int MARKED_CELL = 2;

    private static final int MINE_CELL = -1;

    private static int[][] board = new int[ROWS][COLS];
    private static int[][] state = new int[ROWS][COLS];

    private static Random random = new Random();

    private JButton[][] buttons = new JButton[ROWS][COLS];

    public CampoMinato() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(ROWS, COLS));

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].addActionListener(this);
                buttons[row][col].addMouseListener(this);
                boardPanel.add(buttons[row][col]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

        initializeBoard();
        updateButtons();
    }

    private void initializeBoard() {
        int count = 0;
        while (count < MINES) {
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLS);
            if (board[row][col] != MINE_CELL) {
                board[row][col] = MINE_CELL;
                count++;
            }
        }

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] != MINE_CELL) {
                    board[row][col] = countAdjacentMines(row, col);
                }
            }
        }
    }

    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, ROWS - 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, COLS - 1); j++) {
                if (board[i][j] == MINE_CELL) {
                    count++;
                }
            }
        }
        return count;
    }

    private void updateButtons() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (state[row][col] == COVERED_CELL) {
                    buttons[row][col].setText("");
                    buttons[row][col].setEnabled(true);
                    buttons[row][col].setBackground(Color.LIGHT_GRAY);
                } else if (state[row][col] == MARKED_CELL) {
                    buttons[row][col].setText("M");
                    buttons[row][col].setEnabled(true);
                    buttons[row][col].setBackground(Color.LIGHT_GRAY);
                } else {
                    buttons[row][col].setText(board[row][col] == MINE_CELL ? "X" : Integer.toString(board[row][col]));
                    buttons[row][col].setEnabled(false);
                    buttons[row][col].setBackground(Color.WHITE);
                }
            }
        }
    }

    private void uncoverCell(int row, int col) {
        state[row][col] = UNCOVERED_CELL;

        if (board[row][col] == 0) {
            for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, ROWS - 1); i++) {
                for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, COLS - 1); j++) {
                    if (state[i][j] == COVERED_CELL) {
                        uncoverCell(i, j);
                    }
                }
            }
        }
    }

    private boolean checkForWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (state[row][col] == COVERED_CELL && board[row][col] != MINE_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
    	// TODO Auto-generated method stub
    	System.out.println("Ciao");
    	//this.
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	System.out.println("Action Performed");
        JButton button = (JButton) e.getSource();
        int row = -1;
        int col = -1;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (button == buttons[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        if (state[row][col] == UNCOVERED_CELL) {
            JOptionPane.showMessageDialog(this, "Cell already uncovered!");
            return;
        }

        if (state[row][col] == MARKED_CELL) {
            JOptionPane.showMessageDialog(this, "Cell already marked!");
            return;
        }

        if (board[row][col] == MINE_CELL) {
            JOptionPane.showMessageDialog(this, "Game over!");
            state[row][col] = UNCOVERED_CELL;
            updateButtons();
            return;
        }

        uncoverCell(row, col);

        if (checkForWin()) {
            JOptionPane.showMessageDialog(this, "You win!");
            updateButtons();
            return;
        }

        updateButtons();
    }

    public static void main(String[] args) {
        CampoMinato game = new CampoMinato();
        game.pack();
        game.setVisible(true);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse Clicked Button:"+e.getModifiersEx());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}