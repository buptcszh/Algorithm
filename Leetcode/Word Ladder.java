class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 图的层序遍历（权重非1时就需要用dijkstra算法了）
        Set<String> set = new HashSet<>();  // 记录未遍历过的节点
        for (String s : wordList) {
            set.add(s);
        }
        
        Queue<String> q = new LinkedList<>();  // 记录即将遍历的下一层节点
        q.add(beginWord);
        
        int level = 1;
        while (!q.isEmpty()) {
            int len = q.size();  // 记录这一层的节点数
            
            for (int i = 0; i < len; i++) {
                String temp = q.poll();
                if (temp.equals(endWord)) return level;
                
                // 寻找邻居节点
                for (int j = 0; j < temp.length(); j++) {
                    char[] chs = temp.toCharArray();

                    for (int k = 0; k < 26; k++) {
                        chs[j] = (char) ('a' + k);
                        String s = String.valueOf(chs);
                        
                        if (set.contains(s)) {
                            q.offer(s);
                            set.remove(s);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}