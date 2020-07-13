import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		// tryブロックの中で記述するとスコープの範囲の問題でファイルを閉じることができないためブロック外で定義
		// また何も代入しないと、初期化が行われておらず、内容が不明な状態で使われる可能性があり、finallyブロックで使うことができない
		// なので、nullを代入しておく
		FileWriter fw = null;
		try {
			fw = new FileWriter("data.txt");
			fw.write("hello");
		// ざっくりとException系例外全体を範囲指定することもできる
		} catch(Exception e) {
			System.out.println("何らかの例外が発生しました");
		// もしファイルに書き込む際に、エラーが起こった場合その後のファイルを閉じる処理は無視されてしまう
		// そういったことが起きても対処できるように
		// 例外が起きても起きなくても必ず実行しなければならない処理は、finallyブロック内に記述する
		// もしtryブロックの中にreturnがありそれ以降の処置が中断されたとしても、finallyブロックは必ず実行される
		} finally {
			// fwの中身がもしnullのままであればそもそも閉じる必要がないため
			// fwの中身がnull出ない時だけ処理を試みる
			if(fw != null) {
				try {
					// closeもIOExceptionを発生させる可能性があるメソッドのため、try-catch文で囲まなければいけない
					fw.close();
				} catch (IOException e) {
					// ここでは何もしないということを明示するために「;」を使う、これを空文字という
					// このようにコメントアウトでコメントを記述しておくだけでも良い
					;
				}
			}
		}

		// 上の記述はtry-with-resource分を使うことで簡潔に書くことができる
		// tryのあとの()内に、後片付け処理が必要な変数の宣言を行う
		try(FileWriter fw2 = new FileWriter("data.txt");){
			fw.write("hello!");
		} catch(Exception e) {
			System.out.println("何らかの例外が発生しました");
		}
		// finallyブロックを記述しなくてもJVMによって自動的にcloseメソッドが呼び出される
	}
}
