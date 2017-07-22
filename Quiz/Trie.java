public class Trie {

    private Node root;

    public Trie() {

        root = new Node();
    }

    public void insert(String str) {

        Node n = root;
        for (int i = 0; i < str.length(); i++) {

            int index = str.charAt(i) - 'a';
            if (n.nodes[index] == null) {

                n.nodes[index] = new Node();
            }
            n = n.nodes[index];
        }
        n.isStr = true;
    }

    public boolean find(String str) {

        Node n = root;
        for (int i = 0; i < str.length() && n != null; i++ ){

            int index = str.charAt(i) - 'a';
            n = n.nodes[index];
        }

        return (n != null && n.isStr);
    }

    public void delete(String str) {

        delete(root, str, 0);
    }

    private Node delete(Node n, String str, int i) {

        if (n == null) return null;
        if (i == str.length()) n.isStr = false;

        if (i < str.length() && delete(n.nodes[str.charAt(i) - 'a'], str, i+1) == null)
            n.nodes[str.charAt(i) - 'a'] = null;

        for (int k = 0; k < n.nodes.length; k++) {

            if (n.nodes[k] != null) return n;
        }
        if (n.isStr) return n;

        return null;
    }

    public static void main(String[] args) {

        Trie t = new Trie();
        t.insert("i");
        t.insert("am");
        t.insert("henson");

        System.out.println(t.find("henson"));
        t.delete("henson");
        System.out.println(t.find("henson"));
    }
}

class Node {

    boolean isStr;
    Node[] nodes;

    Node() {

        isStr = false;
        nodes = new Node[26];
    }
}
