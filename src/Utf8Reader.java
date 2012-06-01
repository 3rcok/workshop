

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.PushbackInputStream;
import java.nio.charset.Charset;

/**
 * Given an input stream, if the encoding used to read chars from it is UTF-8, removes the starting BOM (if any).
 * @author lucian.ciufudean
 * @since 8.0 (Mar 16, 2010)
 */
public class Utf8Reader extends Reader {

    private InputStream in;
    private InputStreamReader isr;
    private String encoding;
    public static final byte[] UTF8_BOM = new byte[] {(byte) 0xEF, (byte) 0xBB, (byte) 0xBF};

    public static void main(String[] args){
        InputStream is = null;
        try {
            is = new FileInputStream("c://tmp//sample-utf8.json");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        Utf8Reader reader = null;
        try {
            reader = new Utf8Reader(is , "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            String jsonString = readFile(reader, false);
            System.out.println("json string " + jsonString);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    /*
            Utf8Reader in;
            if (encoding == null) {
                in = new Utf8Reader(new FileInputStream(file));
            } else {
                in = new Utf8Reader(new FileInputStream(file), encoding);
            }
            String contents = CommonUtils.readFile(in, false);    
     */
    
    public static String readFile(Reader in, boolean newlineTerminate) throws IOException {
        char buff[] = new char[1024];
        BufferedReader in2 = new BufferedReader(in);
        StringBuffer sb = new StringBuffer();
        int n;
        while ((n = in2.read(buff)) > 0) {
            sb.append(buff, 0, n);
        }
        in2.close();
        String newline = System.getProperty("line.separator");
        String s = sb.toString();
        if (newlineTerminate && !s.endsWith("\n")) {
            s += newline;
        }
        return s;
    }
    
    public Utf8Reader(InputStream in) {
        this.in = in;
        encoding = Charset.defaultCharset().name();
    }

    public Utf8Reader(InputStream in, String encoding) throws UnsupportedEncodingException {
        this.in = in;
        this.encoding = encoding;
    }

    public int read(char cbuf[], int off, int len) throws IOException {
        init();
        return isr.read(cbuf, off, len);
    }

    public void close() throws IOException {
        isr.close();
    }

    private void init() throws IOException {
        if (isInited()) return;

        if (encoding.equals("UTF-8")) {
            byte maybeBom[] = new byte[UTF8_BOM.length];
            PushbackInputStream pis = new PushbackInputStream(in, 3);
            int n = pis.read(maybeBom, 0, UTF8_BOM.length);
            // n != -1  condition added due to QC131424
            if (!isUtf8Bom(maybeBom, n) && (n != -1)) {
                pis.unread(maybeBom, 0, n);
            }
            isr = new InputStreamReader(pis, encoding);
        }
        else {
            isr = new InputStreamReader(in, encoding);
        }
    }

    /**
     * Checks if a byte array is a UTF-s BOM.
     * @param maybeBom a 3-byte array.
     * @param n the number of bytes from the start of the byte array to check.
     * Most easily, pass here the value returned by the various input stream read methods.
     * @return true if the byte array represents a utf8 bom.
     */
    public static boolean isUtf8Bom(byte[] maybeBom, int n) {
        return (n == UTF8_BOM.length && maybeBom[0] == UTF8_BOM[0] && maybeBom[1] == UTF8_BOM[1]
                && maybeBom[2] == UTF8_BOM[2]);
    }

    private boolean isInited() {
        return isr != null;
    }

}

