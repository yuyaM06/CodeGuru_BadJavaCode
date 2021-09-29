import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author yyM06
 *
 */
class TryFinally {

  protected void tryFinallyCopy(String src, String dest) throws IOException {
    InputStream in = new FileInputStream(src);
    try {
        OutputStream out = new FileOutputStream(dest);
        try {
            byte[] buf = new byte[100];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        } finally {
            out.close();
        }
    } finally {
        if (in != null)
	        try {
	            in.close();
	        } catch (IOException e) {
	            // 例外処理
	        }
	}
  }
  
  
  protected void tryWithResourceCopy(String src, String dest) throws IOException {
    try (InputStream inputStream = new FileInputStream(src); OutputStream outputStream = new FileOutputStream(dest)) {
        byte[] buf = new byte[100];
        int n;
        while ((n = inputStream.read(buf)) >= 0) {
            outputStream.write(buf, 0, n);
        }
    }
  }
  
}