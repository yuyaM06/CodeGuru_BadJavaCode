import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yyM06
 *
 */
class TryFinally {

  protected void tryFinallyCopy(String src, String dest) throws IOException {
	  BufferedReader br = null;
      try {
          br = new BufferedReader(new FileReader("test.txt"));
          String line = null;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          if (br != null)
              try {
                  br.close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
      }
  }
  
  
  protected void tryWithResourceCopy(String src, String dest) throws IOException {
	  try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
          String line = null;
          while ((line = br.readLine()) != null) {
              System.out.println(line);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
}