package test;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName YHAngle
 * @Description TODO
 * @Auther danni
 * @Date 2019/9/10 19:45]
 * @Version 1.0
 **/

public class YHAngle {
    private static List<List<Integer>> angle1(int high){
        List<List<Integer>> angle=new ArrayList<>();
        for (int i = 0; i <high ; i++) {
            angle.add(new ArrayList<>());
        }
        if(high==1||high==2){
            angle.get(0).add(1);
            angle.get(1).add(1);
            angle.get(1).add(1);
            return angle;
        }
        for (int i = 0; i <high ; i++) {
            for (int j = 0; j <=i ; j++) {
                angle.get(i).add(1);
            }
        }
        for (int i = 2; i <high ; i++) {
            for (int j = 1; j <(angle.get(i).size()-1); j++) {
                angle.get(i).set(j,angle.get(i-1).get(j-1)+angle.get(i-1).get(j));
            }
        }
        return angle;
    }
    private static void print(List<List<Integer>> angle,int high){
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i <high ; i++) {
             list=angle.get(i);
            System.out.println(list);
        }
    }
    private static List<List<Integer>> angle2(int high){
        List<List<Integer>> angle=new ArrayList<>();
        if(high==1||high==2){
            angle.add(new ArrayList<>());
            angle.get(0).add(1);
            angle.add(new ArrayList<>());
            angle.get(0).add(1);
            angle.get(0).add(1);
            return angle;
        }else {
            angle.add(new ArrayList<>());
            angle.get(0).add(1);
            angle.add(new ArrayList<>());
            angle.get(1).add(1);
            angle.get(1).add(1);
            for (int i = 2; i < high; i++) {
                angle.add(new ArrayList<>());
                angle.get(i).add(1);
                for (int j = 1; j < i; j++) {
                    int a = angle.get(i - 1).get(j - 1);
                    int b = angle.get(i - 1).get(j);
                    angle.get(i).add(a + b);
                }
                angle.get(i).add(1);
            }
        }
        return angle;
    }
    public static void main(String[] args) {
        List<List<Integer>> angle=new ArrayList();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入三角形的高度");
        int high=scanner.nextInt();
        angle=angle1(high);
        print(angle,high);
        angle=angle2(high);
        print(angle,high);

    }


}

