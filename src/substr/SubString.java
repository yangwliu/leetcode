package substr;

import java.util.HashMap;

public class SubString {

  public static int lengthOfLongestSubstring(String s) {

    char[] chars = s.toCharArray();
    HashMap<Character, Integer> charToIndexMap = new HashMap<>();
    int startIndex = 0;
    int maxLength = 0;
    for (int i = 0; i < chars.length; i++) {
      if (charToIndexMap.containsKey(chars[i])) {
        Integer previousIndex = charToIndexMap.get(chars[i]);
        if (previousIndex >= startIndex) {
          maxLength = maxLength > i - startIndex ? maxLength : i - startIndex;
          startIndex = previousIndex + 1;
        }
      }
      charToIndexMap.put(chars[i], i);
    }

    return Math.max(chars.length - startIndex, maxLength);
  }

  public static int lengthOfLongestSubstring_1(String s) {

    int[] last = new int[128];
    for(int i = 0; i < 128; i++) {
      last[i] = -1;
    }
    int n = s.length();

    int res = 0;
    int start = 0;
    for(int i = 0; i < n; i++) {
      int index = s.charAt(i);
      start = Math.max(start, last[index] + 1);
      res   = Math.max(res, i - start + 1);
      last[index] = i;
    }

    return res;
  }

}
