import java.util.*;

class CSVHeap {
  ArrayList<List<String>> heap;

  CSVHeap() {
    heap = new ArrayList<List<String>>();
  }

  public void insert(String[] record) {
    this.heap.add(Arrays.asList(record));
  }

  public List<String> getRecord(int i) {
    return this.heap.get(i);
  }

  public void displayRecord(int index) {
    for (String ele : this.heap.get(index)) {
      System.out.print(ele + " | ");
    }
  }

  public void displayHeap() {
    for (int i = 0; i < this.heap.size(); i++) {
      this.displayRecord(i);
    }
  }

  public void removeRecord(int index) {
    this.heap.remove(index);
  }

  public int getHeapLength() {
    return this.heap.size();
  }

  // returns the record containing the string
  public List<String> textSearch(String text) {
    for (List<String> s : this.heap) {
      for (int i = 0; i < s.size(); i++) {
        if (s.get(i).contains(text))
          return s;
      }
    }

    List<String> l = new ArrayList<String>();
    return l;
  }
}