import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int size = 7;

    public static void main(String[] args) {
        ArrayList<ArrayList> hashTable = createArray();
        for (int i = 0; i < size; i++){
            System.out.println("input a string: ");
            String string = inputString();
            int index = getIndex(string);
            hashTable.get(index).add(string);
        }
        for (int i = 0; i < size; i++){
            System.out.print(i+" - ");
            for (int j = 0; j < hashTable.get(i).size(); j++){
                System.out.print(hashTable.get(i).get(j)+", ");
            }
            System.out.println();
        }
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        String out = "";
        boolean valid = false;
        while (!valid){
            try{
                out = input.next();
                valid = true;
            }
            catch (Exception e){
                System.out.println("error "+e);
                input.next();
            }
        }
        return out;
    }

    public static int getIndex(String string){
        ArrayList<Character> chars = new ArrayList<>();
        for (char ch: string.toCharArray()){
            chars.add(ch);
        }
        int total = 0;
        for (int i = 0; i < chars.size(); i++){
            int add = (int) chars.get(i);
            total = total + add;
        }
        return total % size;
    }

    public static ArrayList<ArrayList> createArray(){
        ArrayList<ArrayList> hashTable = new ArrayList<>();
        for (int i  = 0; i < size; i++){
            ArrayList<String> temp = new ArrayList<>();
            hashTable.add(temp);
        }
        return hashTable;
    }
}