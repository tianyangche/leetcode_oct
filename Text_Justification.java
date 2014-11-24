public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();

		int currLen = 0, num = 0, index = 0, start = 0;
		StringBuffer temp;
		while (index < words.length) {
			if (currLen + num + words[index].length() <= L) {
				num++;
				currLen += words[index].length();
			} else {
				temp = new StringBuffer();
                int count = 0;
				if (num != 1) {
					for (int i = start; i < index - 1; i++) {
						temp.append(words[i]);
						if (count < (L - currLen) % (num - 1)) {
							for (int j = 0; j < Math.ceil((double)(L - currLen)
									/ (num - 1)); j++) {
								temp.append(" ");
							}
						} else {
							for (int j = 0; j < Math.floor((double)(L - currLen)
									/ (num - 1)); j++) {
								temp.append(" ");
							}
						}
                        count ++;
					}

					temp.append(words[index - 1]);
					result.add(temp.toString());
				} else {
					temp.append(words[index - 1]);
					for (int i = 0; i < L - words[index - 1].length(); i++)
						temp.append(" ");
					result.add(temp.toString());
				}
				start = index;
				num = 1;
				currLen = words[index].length();
			}
			index++;
		}
		temp = new StringBuffer();
        if(num != 1){
            currLen = 0;
            for(int i = start; i < index; i ++){
                temp.append( words[i]);
                temp.append(" ");
                currLen += words[i].length() + 1;
            }
            
            for(int i = currLen; i < L; i ++){
                temp.append(" ");
            }
            
        } else{
		    temp.append(words[index - 1]);
		    for (int i = 0; i < L - words[index - 1].length(); i++) {
			    temp.append(" ");
	    	}
        }
		result.add(temp.toString());
		return result;
    }
}