class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) return ans;

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Count frequency of p
        for (int i = 0; i < m; i++) {
            pFreq[p.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(pFreq, windowFreq)) {
            ans.add(0);
        }

        // Slide the window
        for (int right = m; right < n; right++) {

            // Add new character
            windowFreq[s.charAt(right) - 'a']++;

            // Remove old character
            windowFreq[s.charAt(right - m) - 'a']--;

            // Compare frequencies
            if (Arrays.equals(pFreq, windowFreq)) {
                ans.add(right - m + 1);
            }
        }

        return ans;
    }
}