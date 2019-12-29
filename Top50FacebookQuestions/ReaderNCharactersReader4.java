/*
https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
The read4 API is defined in the parent class Reader4.
int read4(char[] buf);
Given a file and assume that you can only read the file using a given method read4, implement a method read to read n characters. Your method read may be called multiple times.

Method read4:
The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.
The return value is the number of actual characters read.
Note that read4() has its own file pointer, much like FILE *fp in C.
Definition of read4:

    Parameter:  char[] buf
    Returns:    int

Note: buf[] is destination not source, the results from read4 will be copied to buf[]
Below is a high level example of how read4 works:
File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
Method read:
By using the read4 method, implement the method read that reads n characters from the file and store
it in the buffer array buf. Consider that you cannot manipulate the file directly.
The return value is the number of actual characters read.
Definition of read:
    Parameters:	char[] buf, int n
    Returns:	int
Note: buf[] is destination not source, you will need to write the results to buf[]
 Example 1:
File file("abc");
Solution sol;
// Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
 */
package Top50FacebookQuestions;

import java.util.ArrayList;
import java.util.List;

public class ReaderNCharactersReader4
{
    List<Character> list;
    int index;
    public ReaderNCharactersReader4(){
        list = new ArrayList<>();
        index = 0;
        int count = -1;
        while(count != 0){
            char[] buf = new char[4];
            count = read4(buf);
            for(int i = 0 ; i < count; i++){
                list.add(buf[i]);
            }
        }
    }

    private int read4(char[] buf)
    {
        // file read
        return 0;
    }

    public int read(char[] buf, int n) {

        int i = 0;
        while(index < list.size() && i < n){
            buf[i++] = list.get(index++);
        }
        return i;
    }
}
