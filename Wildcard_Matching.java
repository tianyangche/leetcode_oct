public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        assert(s!=null && p!=null);    
        if(p.length()==0) return s.length()==0;
        
        //deal with head
        int i=0;
        while(i<p.length() && i<s.length() && p.charAt(i)!='*'){
            if(p.charAt(i)!=s.charAt(i) && p.charAt(i)!='?')
                return false;
            i++;
        }
        if(i==s.length()){
              while(i<p.length())
                if(p.charAt(i++)!='*') return false;
            return true;
        }
        else if(i==p.length()) 
            return false;
        else{
           s=s.substring(i);
           p=p.substring(i);
        }
        
        //deal with tail 
        i=p.length()-1;
        int j = s.length()-1;
        while(i>=0 && j>=0 && p.charAt(i)!='*'){
            if(p.charAt(i)!=s.charAt(j) && p.charAt(i)!='?')
                return false;
            i--;
            j--;
        }
        if(j<0){
            while(i>=0)
                if(p.charAt(i--)!='*') return false;
            return true;
        }
        else if(i<0)
            return false;
        else{
            s=s.substring(0,j+1);
            p=p.substring(0,i+1);
        }
        
        String[] pattern = p.split("[*]");
        for(String temp:pattern){
            if(temp.length()>0){
                int index = getFirstIndex(s,temp);
                if(index<0) 
                    return false;
                else
                    s=s.substring(index+temp.length());
            }    
        }   
        return true;
    }
    
    
    public int getFirstIndex(String s, String p){
        if(s.length()<p.length()) return -1;
        int i=0;
        while(i<=s.length()-p.length()){
            while(i<s.length() && p.charAt(0)!='?' && p.charAt(0)!=s.charAt(i))
                i++;
            if(s.length()-i<p.length()) return -1;
            
            int j=i;
            while(j-i<p.length() && (p.charAt(j-i)=='?'||p.charAt(j-i)==s.charAt(j)))
                j++;
            if(j-i==p.length()) return i;
            i++;
        }
        return -1;
    }
}