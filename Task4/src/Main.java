import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/texts/12.txt"));
        Map<Character,Integer> symbols = new HashMap<>();

        int count = 0;
        while (sc.hasNextLine()){
            String line = sc.nextLine().toLowerCase();
            for(int i = 0; i < line.length(); i ++){
                if (line.charAt(i) >= 'a' && line.charAt(i) <= 'я' || line.charAt(i) == ' ') {
                    if(symbols.containsKey(line.charAt(i))){
                        symbols.put(line.charAt(i),symbols.get(line.charAt(i))+ 1);
                        count++;
                    }else{
                        symbols.put(line.charAt(i), 1);
                        count++;
                    }
                }
            }
        }
        Object[] values = Arrays.stream(symbols.keySet().toArray()).sorted().toArray();

        FileWriter fw = new FileWriter("src/texts/res.txt");
        for (Object value : values){
            fw.write(value + ":" + (double) symbols.get(value) / count + "\n");

        }
        fw.close();

    }
}