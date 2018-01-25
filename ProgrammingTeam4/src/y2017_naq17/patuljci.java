/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package y2017_naq17;

import java.util.ArrayList;
import java.util.Scanner;

class Main0 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 9; i++) list.add(sc.nextInt());
        solve(list, 0, new ArrayList(), 0);
    }

    public static void solve(ArrayList<Integer> list, int j, ArrayList<Integer> partial, int sum) {
        if (partial.size() == 7 && sum == 100) {
            for(int i = 0; i < partial.size()-1; i++)
                System.out.println(partial.get(i));
            System.out.println(partial.get(partial.size()-1));
        } else {
            for (int i = j; i < list.size(); i++) {
                Integer item = list.get(i);
                partial.add(item);
                if(partial.size() <= 7 && sum+item <= 100)
                    solve(list, i + 1, partial, sum+item);
                partial.remove(item);
            }
        }
    }
}
