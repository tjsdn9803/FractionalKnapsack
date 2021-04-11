import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class thing implements Comparable<thing>{
    int weight;
    int value;
    int valueperweight;

    public thing(int weight,int value){
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
        for(i=0;(weight+thingList.get(0).weight<capacity);i++){
            L.add(thingList.get(0));
            weight = weight + L.get(i).weight;
            value = value + L.get(i).value;
            thingList.remove(0);
        }
        if((capacity-weight) > 0){
            double ratio = ((double)(capacity-weight)/(double)(thingList.get(0).weight));
            System.out.println(ratio);
            double restweight = thingList.get(0).weight;
            double restvalue = thingList.get(0).value;
            restweight = restweight*ratio;
            restvalue = restvalue*ratio;
            L.add(new thing((int)restweight,(int)restvalue));
            value = value + (int)restvalue;
        }
        System.out.println(value);
        return L;
    }

    public static void main(String[] args) {
        int n=4;
        List<thing> ThingArray = new ArrayList<thing>();
        thing platinum = new thing(10,600000);
        thing gold = new thing(15,750000);
        thing silver = new thing(25,100000);
        thing tin = new thing(50,50000);
        ThingArray.add(platinum);
        ThingArray.add(gold);
        ThingArray.add(silver);
        ThingArray.add(tin);
        for(int i=0;i<4;i++){
            ThingArray.get(i).getvalueperweight();
        }
        Collections.sort(ThingArray);
        for(int i=0;i<4;i++){
            System.out.println(ThingArray.get(i).valueperweight);
        }
        int capacity = 40;
        FractionalKnapsack f = new FractionalKnapsack(n,ThingArray,capacity);
        f.putthings();

    }
}
