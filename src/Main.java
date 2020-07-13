import java.io.FileWriter;
import java.io.IOException;

public class Main {
	// 例外はキャッチされない限り、メソッドの呼び出し元まで処置をたらい回しにする。
	// この現象を処理の伝播と呼ぶ
	// だがException系例外は、try-catch文によるcatchが必須なため、例外の伝播は発生しない
	// しかしthrows 例外クラス というスロー宣言を行うことで発生するチェック例外をキャッチせずに呼び出し元へ伝播することができる
	public static void subsub() throws IOException {
		// スロー宣言をしているためtry-catch文がなくてもコンパイルエラーにならない
		FileWriter fw = new FileWriter("data.txt");
	}
	// さらにスロー宣言をして伝播させることもできる
	public static void sub() throws IOException {
		subsub();
	}

	public static void main(String[] args) {
		// スロー宣言で例外をキャッチする義務が生まれているため、呼び出し元で定義する必要がある
		try {
			sub();
			System.out.println("処理が成功しました");
		// 変数名は自由だが基本的にはeなどが用いられる
		} catch (IOException e) {
			System.out.println("何らかの例外が発生しました");
			e.printStackTrace();
		}
	}
}
