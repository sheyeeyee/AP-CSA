package laterClass;

public class WordList {
	String[] words;
	int count;

	public WordList() {
		String[] newWords = {"", ""};
		words = newWords;
		count = 0;
	}

	public int addWord(String w) {		
		//case 2
		if (findWord(w) == -1) { //if w isn't in the array
			if (count < words.length) {
				words[count] = w; //set the string at the count index of the word array (the next blank space)
				count++;
			}
			else {
				String[] temp = new String[2 * words.length];
				
				//set temporary array equal to words array
				for (int i = 0; i < words.length; i++) {
					temp[i] = words[i];
				}
				
				//fill empty spaces at the end
				for (int j = count; j < temp.length; j++) {
					temp[j] = "";
				}
				words = temp; //set words array equal to the new temp word array that's double the size
				words[count] = w; //set the string at the count index of the word array (the next blank space)
				count++;
			}
		}
		return count;
	 /*** TODO: Check which case the word, w, presents to your current list
	               (1) w is in the list - do not add
	               (2) words is not full and w is not in the list - add w, increment count
	               (3) words is full - create new String array with two times the space,
	                                   copy data from words to new array, set words equal
	                                   to new array and then add w, increment count
	               For all cases, return the current value of count ***/
	 }

	 public void removeWord(String w) {
	    /*** TODO: Find w in words. If found, move all elements to right of w one space to
	               the left and decrement count. Otherwise, do nothing ***/
		 int index = findWord(w) + 1;
		 String current = words[index];
		 
		 if (findWord(w) != -1) {
			 for (int i = findWord(w); i < words.length - 1; i++) {
				 words[i] = current;
				 current = words[i + 1];
				 index++;
			 }
			 count--;
		 }
	 }

	 public int findWord(String w) {
		 int foundWord = -1;
		 
		 for (int i = 0; i < words.length; i++) {
			 if (words[i] == w) {
				 foundWord = i;
			 }
		 }
		 return foundWord;
		 
		 /*** TODO: Loop over all words until w is found. Return index of w, or -1 if not
         found ***/
	 }

	 public boolean equals(WordList other) {
		 if (words.length != other.count) {
			 return false;
		 }
		 else {
			 for (int i = 0; i < words.length; i++) {
				 if (words[i] != other.words[i]) {
					 return false;
				 }
			 }
		 }
		 return true;
	  }

	  public String toString() {
		  String s = "There are " + count + " word" + ((words.length == 1)?"":"s") + " in the word list:\n";
		  for (String w : words) {
			  s = s + w + "\n";
		  }
		  return s;
	  }

	  public static void main(String[] args) {
		  WordList wl = new WordList();
		  wl.addWord("Dog");
		  System.out.print(wl);
		  wl.addWord("Dog");
		  System.out.print(wl);
		  wl.removeWord("Dog");
		  wl.addWord("Cat");
		  wl.addWord("Fish");
		  wl.addWord("Horse");
		  System.out.print(wl);
		  if (wl.findWord("Cat") >= 0)
		      System.out.println("Cat is in the word list");
		  if (wl.findWord("Dog") >= 0)
		      System.out.println("Dog is in the word list");
		  WordList myList = new WordList();
		  myList.addWord("Cat");
		  myList.addWord("Horse");
		  myList.addWord("Fish");
		  if (wl.equals(myList))
		      System.out.println("The two lists are the same");
	  }
}