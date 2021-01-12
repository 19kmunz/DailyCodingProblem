package kjmunz;

public class NextLargest {
  int size;
  int[] content;
  int biggest;
  int smallest;
  boolean hasContent;
  public NextLargest(int size){
    this.size = size;
    content = new int[size];
    hasContent = false;
  }

  public void insert(int n){
    if(!hasContent) {
      hasContent = true;
      content[0] = n;
      biggest = 0;
      smallest = 0;
    } else { // code can be simplier, but this garuntees fewest compares as possible (for this method)
      if(n > content[biggest]){ // bigger than biggest in queue
        content[0] = n;
        biggest = 0;
        smallest = 0;
      } else if (n <= content[smallest]){ // smaller or equal to smallest in queue
        smallest = (smallest + 1 == content.length) ? 0 : smallest + 1;
        content[smallest] = n;
      } else { // somewhere in the middle
        int end = (smallest + 1 == content.length) ? 0 : smallest + 1;
        for (int i = biggest; i != end; i++) {
          if (i >= content.length) {
            if(0 == end){
              break;
            }
            i = 0; // this is okay cause im doing a circular queue kinda
          }
          if (n > content[i]){
            content[i] = n;
            smallest = i;
          }
        }
      }
    }
  }

  public int popLargest(){
    if (hasContent) {
      int toReturn = content[biggest];
      if(biggest == smallest){
        hasContent = false;
      } else {
        biggest = (biggest + 1 == content.length) ? 0 : biggest + 1;
      }
      return toReturn;
    } else {
      throw new IllegalStateException("Cannot pop largest from a NextLargest with no content");
    }
  }

  public boolean hasContent(){
    return hasContent;
  }

  public void resetContent(){
    hasContent = false;
    biggest = 0;
    smallest = 0;
  }
}

