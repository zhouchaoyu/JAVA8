package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaMain{

	public static void main(String args[]) {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		
		System.out.println("Languages which starts with J :");
		filter(languages, (str) -> ((String) str).startsWith("J"));

		System.out.println("Languages which ends with a ");
		filter(languages, (str) -> ((String) str).endsWith("a"));

		System.out.println("Print all languages :");
		filter(languages, (str) -> true);

		System.out.println("Print no language : ");
		filter(languages, str -> true);

		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str) -> ((String) str).length() > 4);
		// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
		Predicate<String> startsWithJ = n -> n.startsWith("J");
		Predicate<String> fourLetterLong = n -> n.length() == 4;
		languages.stream().filter(startsWithJ.and(fourLetterLong))
				.forEach(n -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));
	}

	public static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}
}
