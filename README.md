# FractionalKnapsack
#### 팀원: 권순준 이선우 장진이
#### 일자: 2021/04/13
---
#### Mission: 부분 배낭 알고리즘 구현하기
#### 목차
1. [Item](#1-Item)
2. [FractionalKnapsack](#2-FractionalKnapsack)
3. [Main](#3-Main)

---

```java
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Scanner;
```

> 코드를 작성하는 동안 쓰인 클래스
>
> 배열, 정렬, 입력하는데에 사용하였다. 

## 1. Item

> 배낭에 넣을 수 있는 아이템의 정보와, 아이템을 단위 무게 당 가치를 기준으로 내림차순 정렬하는 구문

```java
class Item implements Comparable<Item>{  
    String name;  
    int weight;  
    int price;  
    public Item(String name,int weight,int price){  
        this.name=name;  
        this.weight=weight;  
        this.price=price;  
    }  
  
```

타입 매개변수 `Item`을 가진 제네릭 클래스 Comparable 을 만들었다.

`public Item(String name,int weight,int price)` 은 이름, 무게, 가치를 클래스의 객체에 각각 입력하는 역할을 한다.

```java
    @Override // 무게당 가치가 작은순으로 정렬  
  public int compareTo(Item o) {  
        if((this.price/this.weight) < (o.price/o.weight)) {  
            return 1;  
        }  
        else if((this.price/this.weight) == (o.price/o.weight)){  
            if(this.price < o.price) {  
                return 1;  
            }  
            else return 0;  
        }  
        else return -1;  
    }  
}  

```

`compareTo`는 무게 당 가격순 정렬의 기준을 정하는 메소드이다. <br>
선택한 **`Item o`의 무게 당 가격**과 **Item 클래스에 저장된 무게 당 가격**을 비교하여 

**O**의 무게 당 가격이 크거나, 전체 가격이 더 크면 **1**,

​		무게 당 가격과 전체 가격이 같으면 **0**,

​		무게 당 가격이 작으면 **-1** 을 리턴한다.



## 2. FractionalKnapsack

> 그리디 알고리즘을 따라 용량이 한정된 배낭에 최고 가치의 물건을 넣는 구문

```java
public class FractionalKnapsack {  
    public static ArrayList<Item> knapsack(Item[] I,int num,int C){  
  
        int w=0; // 무게의 합과  
 		int v=0; // 가치의 합을 0으로 초기화한다.
  		ArrayList<Item> S=new ArrayList<Item>(); // 정렬된 물건 리스트  
 		ArrayList<Item> L=new ArrayList<Item>(); // 배낭에 담을 물건 리스트  
   for(int i=0;i<num;i++)  
            S.add(I[i]);  
        Collections.sort(S); //배열 I에 입력된 물건들을 배열 S에 내림차순으로 입력한다.
 
```

```java

        Item x=S.get(0);  
        while(w+x.weight<C){  
            x=S.get(0);  
            L.add(x);  
            w=w+x.weight;  
            v=v+x.price;  
            S.remove(0);  
        }  
  
```

`Item 변수 x`에 S의 0번째에 있는 *단위 무게 당 가치가 가장 높은 물건* 을 대입한다.

`배낭의 무게w` 에 *x의 무게를 더한 값* 이 배낭의 용량 C 보다 작은 동안

배낭에 담을 물건 `리스트 L`에 *물건 x*를 넣는다. 

`배낭의 가치 v`는 현재 가치 v에 *x의 가치를 누적하여 더한다.*

그리고 S의 0번째 값을 *지운다*.

```Java
  if((C-w)>0){  
            x=S.get(0);  
            L.add(new Item(x.name,C-w,(C-w)*(x.price/x.weight)));  
        }  
        return L;  
    }  
  
```

물건의 전부가 배낭의 현재 용량보다 커서 전부 들어가지 못한다면
물건의 무게를 남은 가방의 공간만큼 나누어 넣는다.
가치 또한 나눠진 가치를 추가한다.



## 3. Main

```java
 public static void main(String[] args) {  
  
        Scanner sc=new Scanner(System.in);  
        int num=sc.nextInt();  
        Item[] I = new Item[num+1];  
  
        for(int i=0;i<num;i++)  
            I[i]=new Item(sc.next(),sc.nextInt(),sc.nextInt());//각 물건의 이름과 무게와 가치 
     
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
```



## **입력**

> 물건의 개수 n을 설정한다.
>
> 물건의 정보 Item을 물건의 개수만큼 입력한다. 
>
> 차례로 물건의 이름, 무게, 가치를 입력한다.
>
> 배낭의 용량을 입력한다.
>
> > **배열 L**은 knapsack 메소드에 의해 정보(배열 I와 물건의 개수, 배낭의 용량)가 입력된다.
> >
> > w는 main 메소드에서 가치를 저장할 변수이다.

## **출력**

> L의 사이즈만큼 반복되는 for 문에서 배열 L의 물건 이름이 출력되고 
>
> for문 안에서 물건의 가치만큼 누적되었던 가치 w가 출력된다. 

---

## 결과

![결과](https://user-images.githubusercontent.com/80513292/114697986-868d7600-9d59-11eb-9d88-a6254649d07a.png)

## **시간복잡도**

> 1. n개의 물건 각각의 단위 무게 당 가치를 계산하는 데는 O(n) 시간이 걸린다.
> 2. 물건의 단위 무게 당 가격에 대해서 내림차순으로 정렬하기 위해  O(nlogn) 시간이 걸린다.
> 3. while-루프의 수행은 n번을 넘지 않으며, 루프 내부의 수행은 O(1) 시간이 걸린다.
> 4. 부분만 담는 계산의 수행은 각각 O(1)시간이 걸린다.


***따라서, 시간 복잡도는 O(n) +O(nlogn)+nxO(1)+O(1) = O(nlogn)이다.***
