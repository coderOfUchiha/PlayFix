/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package playfix;

/**
 *
 * @author tariq
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class PlayFix {

    
    public static Random random= new Random();

    public static void main(String[] args) {

        //Declaring ArrayList for inserting team name
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int numberOfGroup;
        System.out.println("Enter team name: ");
        while(scanner.hasNextLine())
        {
            String a = scanner.nextLine();
            list.add(a);
            if (a.equals("done"))
            {
                break;
            }

        }
        System.out.println("Enter total group number: ");
         numberOfGroup=scanner.nextInt();
        System.out.println("Total team in eache group: ");
        int Total_team_in_each_group = scanner.nextInt();
         getRandomItem(list,numberOfGroup,Total_team_in_each_group);


    }

    private static void getRandomItem(ArrayList<String> list, int n, int total_team_in_each_group) {

       ArrayList<String> randomList = new ArrayList<String>();
        int index2=0;
        int listSize = list.size()-1;
        for(int j=0;j<listSize;j++)
        {
            int index1 = random.nextInt(list.size()-1);
            randomList.add(list.get(index1));
            list.remove(index1);
            System.out.println(list.size());
        }
        System.out.println(randomList);
        for(int i=1;i<=n;i++)
        {
            System.out.println("group:"+ i);
            for(int k=0;k<total_team_in_each_group;k++)
            {
                System.out.println(randomList.get(index2));
                index2++;
            }
        }
    }
}
    

