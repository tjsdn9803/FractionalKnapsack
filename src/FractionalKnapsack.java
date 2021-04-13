import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

class Item implements Comparable<Item>{
    String name;
    int weight;
    int price;
    public Item(String name,int weight,int price){
        this.name=name;
        this.weight=weight;
        this.price=price;
    }

    @Override           // 무게당 가치가 작은순으로 정렬
    public int compareTo(Item o) {
        if ((this.price/this.weight) < (o.price/o.weight)) {
            return 1;
        } else if ((this.price/this.weight) > (o.price/o.weight)) {
            return -1;
        }
        return 0;
    }
}
public class FractionalKnapsack {
    public static ArrayList<Item> knapsack(Item[] I,int num,int C){

        int w=0; // 무게의 합
        int v=0; // 가치의 합
        ArrayList<Item> S=new ArrayList<Item>(); // 정렬된 물건 리스트
        ArrayList<Item> L=new ArrayList<Item>(); // 배낭에 담을 물건 리스트

        for(int i=0;i<num;i++)
            S.add(I[i]);
        Collections.sort(S);

        Item x=S.get(0);
        while(w+x.weight<C){
            x=S.get(0);
            L.add(x);
            w=w+x.weight;
            v=v+x.price;
            S.remove(0);
            }

        if((C-w)>0){
            x=S.get(0);
            L.add(new Item(x.name,C-w,(C-w)*(x.price/x.weight)));
        }
        return L;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        Item[] I = new Item[num+1];

        for(int i=0;i<num;i++)
            I[i]=new Item(sc.next(),sc.nextInt(),sc.nextInt()); //각 물건의 이름과 무게와 가치

        int C=sc.nextInt(); //배낭의 용량
        ArrayList<Item> L=new ArrayList<Item>();
        L=knapsack(I,num,C);
        int w=0;
        for(int i=0;i<L.size();i++) {
            System.out.print(L.get(i).name + " ");
            w=w+L.get(i).price;
        }
        System.out.print(w);

    }
}
