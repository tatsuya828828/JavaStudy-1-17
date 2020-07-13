import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// 文法エラーや論理エラーとは違い
		// メモリが足りなくなった、存在すべきファイルが見つからないまたは消されている、など
		// プログラムの実行中に起こる想定外のエラーを例外(exception)と呼ぶ
		// 例外的状況にはtry-catch分を使うことで処理しやすくなる
		// tryブロックを実行中に、例外的状況が発生したことをJVMが検知すると、処理は直ちにcatchブロックに移行する
		try {
			FileWriter fw = new FileWriter("data.txt");
			fw.write("hello");
			fw.close();
			System.out.println("書き込みが成功しました");
		// catchブロックには、例外的状況が起こった際に処理する内容を記述する
		} catch(IOException e) {
			System.out.println("エラーです。中断します");
		}
	}
}
