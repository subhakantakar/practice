// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

package v3;

public class LongestSubstringWithoutRepeatingChar {

  public int lengthOfLongestSubstring(String s) {
    int[] index = new int[128];
    for (int i = 0 ; i < 128 ; i++) {
      index[i] = -1;
    }
    int i = 0;
    int max = 0;
    int curr = 0;
    while(curr < s.length()) {
      char ch = s.charAt(curr);
      if (index[ch] != -1 && index[ch] >= i) {
        if (curr-i > max) {
          max = curr-i;
        }
        i = index[ch]+1;
      }
      index[ch] = curr;
      curr++;
    }

    if (curr - i > max) {
      max = curr-i;
    }
    return max;
  }

  public static void main (String[] argv) {
    LongestSubstringWithoutRepeatingChar lswrc = new LongestSubstringWithoutRepeatingChar();
    System.out.println(lswrc.lengthOfLongestSubstring("abba"));
  }

}
