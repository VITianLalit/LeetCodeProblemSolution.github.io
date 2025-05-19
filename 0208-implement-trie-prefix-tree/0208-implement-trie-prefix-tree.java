class Trie {

    class Node{
        int countEqual;
        int countPrefix;
        Node[] trie;
        Node(){
            countEqual = 0;
            countPrefix = 0;
            trie = new Node[26];
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.trie[c-'a'] == null){
                curr.trie[c-'a'] = new Node();
            }
            curr = curr.trie[c-'a'];
            curr.countPrefix++;
        }
        curr.countEqual++;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.trie[c-'a'] == null) return false;
            curr = curr.trie[c-'a'];
        }
        return curr.countEqual > 0;

    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.trie[c-'a'] == null) return false;
            curr = curr.trie[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */