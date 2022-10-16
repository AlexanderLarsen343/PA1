import java.io.*;
import java.util.*;


public class PA1_main {

    public static void main(String args[]){
        
        ArrayList<String> allKeys = new ArrayList<String>();
        ArrayList<String> totals = new ArrayList<String>();
        LinearHashTable<String, String> grades = new LinearHashTable<>(new SimpleStringHasher());

        for(String fileName : args){
            File file = new File(fileName);
            System.out.println(file.getName());
            organizeFile(file, allKeys, grades);
        }

        allKeys.remove(2);
        System.out.println(allKeys);
       // for(int i = 0; i < allKeys.size() - 1; i++){
       //     System.out.print(grades.getElement(allKeys.get(i)) + " ");
       // }

    }

    public static void organizeFile(File file, ArrayList<String> ak, LinearHashTable<String, String> g){
        try {

            //Gets the first line and breaks up the labels which will be used as keys
            Scanner scan = new Scanner(new FileReader(file));
            String keysS = scan.nextLine();
            StringTokenizer st = new StringTokenizer(keysS, ",", false);
            
            //Creates a list of keys while also adding to big list of all keys
            ArrayList<String> keys = new ArrayList<String>();
            while(st.hasMoreTokens()){
                String token = st.nextToken();
                keys.add(token);
                if(!ak.contains(token) && !token.equals("Total")){
                    ak.add(token); //Keeps track of all total keys
                }
                if(token.equals("Total")){

                }
            }
            //System.out.println(keys.get(0));

            //Adds to the grades hashTable to keep track of Overalls and totals
            String gradeTotals = scan.nextLine();
            StringTokenizer str = new StringTokenizer(gradeTotals, ",", false);
            int Counter = 0;
            while(str.hasMoreTokens()){
                String token = str.nextToken();
                g.addElement(keys.get(Counter), token); //Adds to hashtable for future print
                Counter++;
            }

            System.out.println(keys);

           // do(String line = )
           //     System.out.println(firstLine);
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
           
    
}
