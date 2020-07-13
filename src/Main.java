import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("プログラムを起動しました");
		// 例外を発生させ、mainメソッドにも例外をたらい回しにさせている
		throw new IOException();
		Person person = new Person();
		person.setAge(10);
		System.out.println(person.age);

		System.out.println();
		String s = null;
		try{
			System.out.println(s.length());
		} catch(RuntimeException e) {
			System.out.println("NullPointerException例外をcatchしました");
			System.out.println("-- スタックトレース(ここから) --");
			e.printStackTrace();
			System.out.println("-- スタックトレース(ここまで) --");
		}

		try{
			int i = Integer.parseInt("三");
			System.out.println(i);
		} catch(NumberFormatException e) {
			System.out.println("NumberFormatException例外をcatchしました");
			System.out.println("-- エラーメッセージ --");
			e.printStackTrace();
			System.out.println("-------------------");
		}

	}
}
