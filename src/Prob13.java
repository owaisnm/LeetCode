
public class Prob13 {
	 public int romanToInt(String s) {
	        
	        int total = 0;
	        int i = 0; 
	        char currChar, nextChar;
	        while(i < s.length())  {
	            currChar = s.charAt(i);
	            nextChar = i+1<s.length() ? s.charAt(i+1) : '\u0000';
	            if(currChar == 'I') {
	                if(nextChar == 'V') {
	                    total+=4;
	                    i+=2;
	                } else if(nextChar == 'X') {
	                    total+=9;
	                    i+=2;
	                }else {
	                    total+=1;
	                    i++;
	                }
	            } else if(currChar == 'V') {
	                total+=5;
	                i++;
	            }
	            else if(currChar == 'X') {
	                if(nextChar == 'L') {
	                    total+=40;
	                    i+=2;
	                } else if(nextChar == 'C') {
	                    total+=90;
	                    i+=2;
	                } else {
	                    total+=10;
	                    i++;
	                }
	            }
	            else if(currChar == 'L') {
	                total+=50;
	                i++;
	                
	            }
	            else if(currChar == 'C') {
	                if(nextChar == 'D') {
	                    total+=400;
	                    i+=2;
	                } else if(nextChar == 'M') {
	                    total+=900;
	                    i+=2;
	                } else {
	                    total+=100;
	                    i++;
	                }
	            }
	            else if(currChar == 'D') {
	                total+=500;
	                i++;
	            }
	            else if(currChar == 'M') {
	                total+=1000;
	                i++;
	            }
	        }
	            
	        return total;
	    }
}
