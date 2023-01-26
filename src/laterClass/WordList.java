package laterClass;

public class WordList {
	String[] words;
	int count;

	public WordList() {
		String[] newWords = new String[2];
		words = newWords;
		count = 0;
	}

	public int addWord(String w) {		
		//case 1
		if (findWord(w) != -1) {
			return count;
		}
		for (int i = 0; i < words.length; i++) {
			//case 2
			if (words[i] == " ") {
				words[i] = w;
				count++;
				return count;
			}
			
			//case 3
			else {
				String[] temp = new String[2 * words.length];
				for (int n = 0; n < words.length; n++) {
					temp[n] = words[n];
					count++;
					
					if (count == words.length) {
						temp[n + 1] = w;
					}
				}
				return count;
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
		 for (int i = 0; i < words.length; i++) {
			 if (findWord(w) != -1) {
				 if (i > 0) {
					 words[i] = words[i - 1];
				 }
			 }
		 }
	 }

	 public int findWord(String w) {
		 for (int i = 0; i < words.length; i++) {
			 if (words[i] != null) {
				 if (words[i].equals(w)) {
					 return i;
				 } 
			 }
		 }
		 return -1;
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