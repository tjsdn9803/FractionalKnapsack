import java.util.Vector;

class KnapSack{
    int n; int m; //용량
    String[][] L; //담은 물건
    int w; //무게
    int v; //가치
    String [][]info; //물건정보

    public void input (String x, String y, String z){ //x=이름 y=무게 z=가격
        for(int i=0;i<m;i++){
            info[i][0] = x;
            info[i][1] = y;
            info[i][2] = z;
        }
        Vector<String> S = new Vector<String>(); //단위 무게당 최고 가치순 물건 저장 배열 벡터
        Vector <Vector<String>> S;
        for(int i=0;i<m;i++){
            int va = Integer.parseInt(info[i][2])/Integer.parseInt(info[i][1]);//가격 나누기 무게
            String vaa = Integer.toString(va); //무게를 문자열로 바꿔야 배열에 입력가능

            //0:이름 1:단위당 가격
        }

    }
    public void FKsack(int n,int m){ //배낭의 용량, 물건의 개수
        this.n = n;
        L = new String[n][n];//0:이름 1:무게 3:가격격
       w = 0; v=0; //초기화
        while (w+x<n && w+x == n){


        }







    }
}
public class Knap {
    public static void main(String[] args) {

        String info [][]= {{"주석", "백금", "은", "금"},//4열 3행 이름
                {"50", "10", "25", "15"},//무게(g)
                {"50000", "600000", "100000", "750000"}};//가치(원)

        }
    }

