class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        int k = s1.length();

        // Count frequencies
        for (int i = 0; i < k; i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(s1Freq, windowFreq)) {
            return true;
        }

        // Slide window
        for (int right = k; right < s2.length(); right++) {

            // Remove outgoing character
            windowFreq[s2.charAt(right - k) - 'a']--;

            // Add incoming character
            windowFreq[s2.charAt(right) - 'a']++;

            if (Arrays.equals(s1Freq, windowFreq)) {
                return true;
            }
        }

        return false;
    }
}