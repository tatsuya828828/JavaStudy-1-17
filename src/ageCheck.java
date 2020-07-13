import java.io.IOException;
//既存の例外クラスを継承してオリジナルの継承クラスを作ることもできる
public class ageCheck extends IOException {
	public static int checkAgeInt(int age) {
		// 引数をチェックしてthrowを使って自分で例外をJVMに投げることもできる
		if(age < 0) {
			throw new IllegalArgumentException("年齢は正の数を指定してください。指定値="+ age);
		}
		// 問題ないならフィールドに値をセット
		return age;
	}
}
