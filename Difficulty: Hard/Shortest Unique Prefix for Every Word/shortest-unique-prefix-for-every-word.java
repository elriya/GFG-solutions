import java.util.ArrayList;

class Solution {
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int count = 0; // Tracks how many words pass through this node
    }

    private void insert(TrieNode root, String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.count++;
        }
    }

    private String getUniquePrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder prefix = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            curr = curr.children[idx];
            prefix.append(ch);

            // Once the count drops to 1, this prefix is unique to the current word
            if (curr.count == 1) {
                break;
            }
        }
        return prefix.toString();
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        // Insert all words into the Trie
        for (String word : arr) {
            insert(root, word);
        }

        // Find the shortest unique prefix for each word
        ArrayList<String> result = new ArrayList<>();
        for (String word : arr) {
            result.add(getUniquePrefix(root, word));
        }

        return result;
    }
}