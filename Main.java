import java.util.Arrays;
import java.util.Random;

import java.awt.event.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.util.Scanner;

public class Main {
    static String[] ListofOX = {"1","2","3","4","5","6","7","8","9"};
    static String player = "O";
    static void displayboard() {
        System.out.println(ListofOX[0] + "   |   " + ListofOX[1] + "   |   " + ListofOX[2]);
        System.out.println(ListofOX[3] + "   |   " + ListofOX[4] + "   |   " + ListofOX[5]);
        System.out.println(ListofOX[6] + "   |   " + ListofOX[7] + "   |   " + ListofOX[8]);
    }
    static void inputox() {
        try {
            System.out.println("This is " + player + " turn");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please enter your position : ");
            String userinput = scanner.next();
            int opos = Integer.parseInt(userinput);
            opos = opos - 1;

            if (0 <= opos && opos <= 8 && (!"O".equals(ListofOX[opos])) && (!"X".equals(ListofOX[opos]))) {
                ListofOX[opos] = player;
                if ("O".equals(player))
                    player = "X";
                else
                    player = "O";
            } else
                System.out.println("Please enter number between 1-9");

        } catch (Exception e) {
            System.out.println("ERROR");
        }
    }

    static boolean checkwin() {
        if (ListofOX[0].equals(ListofOX[1]) && ListofOX[1].equals(ListofOX[2]))
            return true;
        else if (ListofOX[3].equals(ListofOX[4]) && ListofOX[4].equals(ListofOX[5]))
            return true;
        else if (ListofOX[6].equals(ListofOX[7]) && ListofOX[7].equals(ListofOX[8]))
            return true;
        else if (ListofOX[0].equals(ListofOX[3]) && ListofOX[3].equals(ListofOX[6]))
            return true;
        else if (ListofOX[1].equals(ListofOX[4]) && ListofOX[4].equals(ListofOX[7]))
            return true;
        else if (ListofOX[2].equals(ListofOX[5]) && ListofOX[5].equals(ListofOX[8]))
            return true;
        else if (ListofOX[0].equals(ListofOX[4]) && ListofOX[4].equals(ListofOX[8]))
            return true;
        else if (ListofOX[2].equals(ListofOX[4]) && ListofOX[4].equals(ListofOX[6]))
            return true;
        else
        return false;
    }
    void Draw_game(){
        screen.removeAll();
        Graphics2D g2d = (Graphics2D) screen.getGraphics();
        g2d.setStroke(new BasicStroke(2));
        for (int i=0;i<3;i++){
            g2d.setColor(Color.black);
            g2d.drawLine(0, i*200, 800, i*200);
            for (int j=0;j<4;j++){
                g2d.setColor(Color.black);
                g2d.drawLine(j*200, 0, j*200, 600);
                g2d.setColor(Color.blue);
                g2d.setFont(new Font("Calibri", Font.PLAIN, 150));
                //g2d.drawString(game_board[i][j],60+(200*j),150+(200*i));
            }
        }
    }
    public static void main(String[] args) {
        int countround = 0;
        System.out.println("Welcome to OX GAME");
        displayboard();
        while(true){
            inputox();
            checkwin();
            displayboard();
            countround += 1;
            if (countround == 9 && (!checkwin())) {
                System.out.println("DRAW");
                break;
            }
            if (checkwin()) {
                if (player.equals("O"))
                    System.out.println("Player X Win");
                if (player.equals("X"))
                    System.out.println("Player O Win");
                break;


            }


        }
    }

    }
