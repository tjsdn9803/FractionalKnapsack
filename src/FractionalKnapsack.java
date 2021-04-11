import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class thing implements Comparable<thing>{
    String name;
    int weight;
    int value;
    int valueperweight;

    public thing(String name,int weight,int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
    public void getvalueperweight(){
        this.valueperweight = value/weight;
    }
    @Override
    public int compareTo(thing t){
        if(this.valueperweight < t.valueperweight) {
            return 1;
        }
        else if(this.valueperweight == t.valueperweight){
            if(this.value < t.value) {
                return 1;
            }
            else return 0;
        }
        else return -1;
    }
}
public class FractionalKnapsack{
    //입력: 물건의 갯수 n/n개의 물건의 이름, 무게, 금액을 담은 배열/배낭의 용량 capacity
    //출력: 배낭에 담긴 물건의 배열 L,총 금액 value
    public int capacity;
    List<thing> thingList = new ArrayList<>();
    List<thing> L = new ArrayList<>();
    public int n;
    int i=0;
    public int weight=0;
    public int value=0;

    public FractionalKnapsack(int n,List<thing> thingList,int capacity){
        this.n = n;
        this.thingList = thingList;
        this.capacity = capacity;
    }

    public List<thing> putthings(){
        for(i=0;(weight+thingList.get(0).weight<capacity);i++){//
            L.add(thingList.get(0));
            weight = weight + L.get(i).weight;
            value = value + L.get(i).value;
            thingList.remove(0);
        }
        if((capacity-weight) > 0){
            //ratio변수에 (남은 저장공간) / (다음 물건의 무게) 저장
            double ratio = ((double)(capacity-weight)/(double)(thingList.get(0).weight));
            String restname = thingList.get(0).name;
            double restweight = thingList.get(0).weight;
            double restvalue = thingList.get(0).value;
            restweight = restweight*ratio;
            restvalue = restvalue*ratio;
            L.add(new thing(restname,(int)restweight,(int)restvalue));
            value = value + (int)restvalue;
        }
        for(int j=0;j<L.size();j++){
            System.out.println(L.get(j).name+" "+L.get(j).weight+"g "+L.get(j).value+"원");
        }
        System.out.println("총 "+value+" 원");
        return L;
    }

    public static void main(String[] args) {
        int n=4;
        List<thing> ThingArray = new ArrayList<thing>();
        thing tin = new thing("tin",50,50000);
        ThingArray.add(tin);
        thing platinum = new thing("platinum",10,600000);
        ThingArray.add(platinum);
        thing silver = new thing("silver",25,100000);
        ThingArray.add(silver);
        thing gold = new thing("gold",15,750000);
        ThingArray.add(gold);

        for(int j=0;j<ThingArray.size();j++){
            System.out.println(ThingArray.get(j).name+" "+ThingArray.get(j).weight+"g "+ThingArray.get(j).value+"원");
        }
        System.out.println("");

        for(int i=0;i<4;i++){
            ThingArray.get(i).getvalueperweight();
        }

        Collections.sort(ThingArray);

        for(int i=0;i<4;i++){
            System.out.println(ThingArray.get(i).name+"의 1g당 금액 "+ThingArray.get(i).valueperweight);
        }
        System.out.println("");

        int capacity = 40;
        FractionalKnapsack f = new FractionalKnapsack(n,ThingArray,capacity);
        f.putthings();
    }
}
