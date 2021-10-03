import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yyM06
 *
 */
class TryFinally {

  protected void tryFinallyCopy(String src, String dest) throws IOException {
	  String inFilePath = "D:\\A.txt";
      String outFilePath = "D:\\C.txt";

      FileInputStream in = null;
      FileOutputStream out = null;

      try {
          in = new FileInputStream(inFilePath);
          out = new FileOutputStream(outFilePath);
          int c;

          // データをコピーする
          while ((c = in.read()) != -1) {
              out.write(c);
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (in != null) {
              try {
                  in.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          if (out != null) {
              try {
                  out.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }
  
  
  protected void tryWithResourceCopy(String src, String dest) throws IOException {
	  String inFilePath = "D:\\A.txt";
      String outFilePath = "D:\\C.txt";

      try (FileInputStream in = new FileInputStream(inFilePath);
              FileOutputStream out = new FileOutputStream(outFilePath);) {
          int c;

          // データをコピーする
          while ((c = in.read()) != -1) {
              out.write(c);
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
}