/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingogenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author cswan
 */
public class BingoGenerator
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        List<String> initList = new ArrayList<>();
        initList.add("1");
        initList.add("2");
        initList.add("3");
        initList.add("4");
        initList.add("5");
        initList.add("6");
        initList.add("7");
        initList.add("8");
        initList.add("9");
        initList.add("0");
        initList.add(" ");
        initList.add(" ");
        initList.add(" ");
        initList.add(" ");
        initList.add(" ");
        initList.add(" ");
        String[][] bingoCard = new String[15][10];
        int count = 0;
        boolean valid = false;

            for (int j = 0; j < 9; j++)
            {
                Collections.shuffle(initList);
                for (int i = 0; i < 15; i++)
                {
                    if (initList.get(i).equals(" "))
                    {
                        bingoCard[i][j] = "  ";
                    } else
                    {
                        bingoCard[i][j] = j + "" + initList.get(i);
                    }
                }
            }

            Random r = new Random();
            int index = r.nextInt(10);
            while (!bingoCard[index][8].equals("  "))
            {
                index = r.nextInt(10);
            }

            bingoCard[index][8] = "90";

            for (int j = 0; j < 9; j++)
            {
                for (int i = 0; i < 15; i++)
                {
                    if (bingoCard[i][j].equals("00"))
                    {
                        bingoCard[i][j] = "  ";
                    }
                }
            }

            for (int i = 0; i < 15; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    count = 0;
                    if (!bingoCard[i][j].equals("  "))
                    {
                        count++;
                    }
                    if (count != 5)
                    {
                        valid = false;
                    }
                }
            }

        for (int i = 0; i < 15; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(bingoCard[i][j] + " ");
            }
            System.out.println("");
            if ((i + 1) % 3 == 0)
            {
                System.out.println("******************");
            }
        }
    }
}
