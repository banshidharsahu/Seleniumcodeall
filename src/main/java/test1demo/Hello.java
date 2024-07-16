package test1demo;

import java.util.HashMap;
import java.util.Map;

class Hello {

	public static void main(String[] args)

	{
		String s = "India is a country in South Asia. It is the world’s largest democracy. New Delhi is the capital of India.";
		char ch[] = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>();

		for (char c : ch)

		{
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))

			{
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet())

		{
			System.out.println(entry.getKey() + "== " + entry.getValue());
		}
	}

}
