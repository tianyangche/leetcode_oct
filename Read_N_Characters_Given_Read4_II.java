/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    private int begin = 0;
    private int remained = 0;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int currRead = 0;
        boolean eof = false;

        while (!eof && currRead < n) {
            int size = remained > 0 ? remained : read4(buffer);
            if (remained == 0 && size < 4) {
                eof = true;
            }
            int len = Math.min(size, n - currRead);
            System.arraycopy(buffer, begin, buf, currRead, len);
            currRead += len;
            remained = size - len;
            begin = (begin + len) % 4;  
        }
        return currRead;
    }
}