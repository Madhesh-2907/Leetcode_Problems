class Solution {
    public String reverseVowels(String s) {

        StringBuilder sb = new StringBuilder(s);

        int left = 0;
        int right = sb.length() - 1;

        while (left < right) {

            // Skip consonants from the left
            while (left < right &&
                   !isVowel(sb.charAt(left))) {
                left++;
            }

            // Skip consonants from the right
            while (left < right &&
                   !isVowel(sb.charAt(right))) {
                right--;
            }

            // Swap the vowels
            char temp = sb.charAt(left);

            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);

            left++;
            right--;
        }

        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}