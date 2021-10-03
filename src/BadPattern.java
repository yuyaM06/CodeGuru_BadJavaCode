import java.io.File;

public class BadPattern {
	
	// 文字列であることしかわからない
	String str;  
	// 何のコードかわからない
	String code; 
	// 何を指しているかわからない
	int a;       
	//連番
	File file1;
	File file2;
	// 定数名に値が入っている
	static final String MSGID_E0001 = "E0001"; 
	// どういう場合にtrue/falseとなるのかが不明瞭
	private boolean writeFlg = false; 
	
	boolean isPrimeNumber(int num) {
	    boolean ret;
	    if (num < 2) {
	        ret = false; // 2未満は素数でない
	    } else if (num == 2) {
	        ret = true;  // 2は素数
	    } else if (num % 2 == 0) {
	        ret = false; // 2以外の偶数は素数でない
	    } else {
	        ret = true; // 割り切れなかったら素数
	        double sqrtNum = Math.sqrt(num);
	        for (int i = 3; i <= sqrtNum; i+=2) {
	            if (num % i == 0) {
	                ret = false;   // 割り切れたら素数でない
	                break;
	            }
	        }
	    }
	    return ret; 
	}

}
