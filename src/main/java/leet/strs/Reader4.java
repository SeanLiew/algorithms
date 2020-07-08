package leet.strs;

/**
 * desc: 读取字符串
 * author: liuxiaozheng
 * time: 2020/7/7  16:58
 **/
public class Reader4 {
    private String file;

    int pointer = 0;

    Reader4(String input){
        this.file = input;
    }

    public int read4(char[] buf){
        int readCount = 0;
        for (int i = pointer; i < file.length(); i++){
            if (readCount == buf.length){
                return readCount;
            }
            buf[readCount] = file.charAt(i);
            readCount++;
            pointer++;
        }
        return readCount;
    }

    public int read(char[] buf, int n) {
        int readCount = 0;
        char[] temp = new char[4];
        while (n > readCount){
            int copyLength = read4(temp);
            if (copyLength == 0){
                break;
            }
            if (copyLength + readCount > n){
                copyLength = n - readCount;
            }
            System.arraycopy(temp, 0, buf, readCount, copyLength);
            readCount +=  copyLength;
        }
        return readCount;

    }

    public static void main(String[] args) {
        Reader4 read4 = new Reader4("abc");
        char[] buf = new char[4];
        int read = read4.read(buf, 4);
        System.out.println(read);
        System.out.println(buf);

    }
}
