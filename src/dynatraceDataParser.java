import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class dynatraceDataParser {

    private JSONObject allData;
    private JSONArray numberArray;
    private ArrayList<Integer> numberList;

    dynatraceDataParser(String json){
        this.allData = new JSONObject(json);
        this.numberArray = allData.getJSONArray("data");

        int len = this.numberArray.length();
        this.numberList = new ArrayList<Integer>();
        for (int i=0;i<len;i++){
            this.numberList.add((Integer)this.numberArray.get(i));
        }
    }

    public ArrayList<Integer> getNumberList() {
        return numberList;
    }

    public void eliminateDuplicates(){
        Set<Integer> list = new HashSet<Integer>(this.numberList);

        this.numberList.clear();
        this.numberList = new ArrayList<Integer>(list);

    }

    public void sortList(){
        Collections.sort(this.numberList);
    }

    public ArrayList<Integer> getPrimeNumbers(){
        ArrayList<Integer> temp = this.numberList;
        temp.removeIf(s -> !isPrime(s));
        return temp;
    }

    public boolean isPrime(int number){
        if(number % 2 == 0)
            return false;
        else if(number % 3 == 0)
            return false;
        else if(number == 2)
            return true;
        else if(number == 3)
            return true;

        int i = 5;
        int w = 2;

        while(i*i <= number) {
            if (number % i == 0)
                return false;

            i += w;
            w = 6 - w;
        }

        return true;
    }



}
