import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



import java.util.*;
import java.util.regex.*;

public class Main {
  public static void main(String[] args) {
    String line = "";
    String splitBy = ",";

    CSVHeap heap = new CSVHeap();
    try {
      // parsing a CSV file into BufferedReader class constructor
      BufferedReader br = new BufferedReader(new FileReader("BuildingsData.csv"));
      String[] headerLine = br.readLine().split(splitBy); 
      while ((line = br.readLine()) != null)
      {
        String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); 
        heap.insert(data);
      }

      // displays the Heap as an object 
      for(int i=0; i<heap.getHeapLength()-1; i++){
        List<String> record = heap.getRecord(i);
        System.out.println("{");
        for(int x=0; x < record.size(); x++){
          System.out.print("  " + headerLine[x]+ ":");
          System.out.println(record.get(x));
        } 
        System.out.println("}");
      }

      
      System.out.println("TextSearch: \n" );
      List<String> search= heap.textSearch("2003");
      System.out.println(search);
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}