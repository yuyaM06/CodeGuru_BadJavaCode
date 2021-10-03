import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author yyM06
 *
 */
class TryFinally {

  protected void tryFinallyCopy(String src, String dest) throws IOException {
	  String inFilePath = "D:\\foo.txt";
      String outFilePath = "D:\\bar.txt";

      FileInputStream in = null;
      FileOutputStream out = null;

      try {
          in = new FileInputStream(inFilePath);
          out = new FileOutputStream(outFilePath);
          int c;

          // データコピー
          while ((c = in.read()) != -1) {
              out.write(c);
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (in != null) {
              try {
                  in.close();	// 入力ストリームを閉じて、関連システムリソースを解放
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          if (out != null) {
              try {
                  out.close();	// 出力ストリームを閉じ、関連システムリソースを解放
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
  }

}
