import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// 文法エラーや論理エラーとは違い
		// メモリが足りなくなった、存在すべきファイルが見つからないまたは消されている、など
		// プログラムの実行中に起こる想定外のエラーを例外(exception)と呼ぶ
		// 例外的状況にはtry-catch分を使うことで処理しやすくなる
		// tryブロックを実行中に、例外的状況が発生したことをJVMが検知すると、処理は直ちにcatchブロックに移行する
		// IOExceptionが発生する可能性があるときには、
		// try-catch分を用いて例外が発生したときの代替処理を用意しておかないとコンパイルエラーになる
		// そのように、例外発生時の対策が用意されているかをコンパイルの時点でチェックされるため
		// Exception系例外は、チェック例外と呼ばれることもある
		try {
			FileWriter fw = new FileWriter("data.txt");
			fw.write("hello");
			fw.close();
			System.out.println("書き込みが成功しました");
		// catchブロックには、例外的状況が起こった際に処理する内容を記述する
		// IOExceptionとは、
		// Exception系例外という、発生を十分に想定して対処を考える必要がある例外的状況を表すクラスの中の一つ
		// 例えば、ファイルなどが読み書きできない(IOException)、ネットワークに接続できない(ConnectException)など
		// 想定しておくべき事態を処理する際に用いられる
		} catch(IOException e) {
			// getMessageはエラーメッセージを取得するメソッド
			System.out.println("エラー:"+ e.getMessage());
			e.printStackTrace();
		}

		// 他の例外処理クラス
		// Error系例外
		// メモリ不足(OutOfMemoryError)やクラスファイルが壊れている(ClassFormatError)など
		// catchをしても、回復の見込みがない致命的な状況に用いられる、また、この際は、catchをする必要はない

		// RuntimeException系例外
		// 変数がnull(NullPointerException)や配列の添字が不正(ArrayIndexOutOfBoundsException)など
		// いちいち想定していてはキリがないようなもの、など、必ずしも常に発生を想定すべきとまでは言えない例外的状況をに用いられる
		// catchするかは任意

		// どのクラスのどのメソッドが、どのような例外を発生させる可能性があるかは、APIリファレンスに載っている

	}
}
