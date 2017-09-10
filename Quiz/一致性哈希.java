import java.util.*;

public class ConsistentHash {
    private static final int VIRTUAL_NODES = 100;  // 虚拟节点数量

    private static String[] servers = {
            "192.168.0.0:111",
            "192.168.0.1:111",
            "192.168.0.2:111",
            "192.168.0.3:111",
            "192.168.0.4:111"
    };

    private static List<String> realNodes = new LinkedList<>();                // 真实节点
    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();  // 虚拟节点，0~2^32-1的hash环

    static {
        realNodes.addAll(Arrays.asList(servers));

        for (String str : realNodes) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                String virtualNodeName = str + "&&VN" + String.valueOf(i);
                int hash = getHash(virtualNodeName);
                virtualNodes.put(hash, virtualNodeName);
            }
        }
    }

    // 计算hashcode有很多算法
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }

    private static String getServer(String node) {
        int hash = getHash(node);

        SortedMap<Integer, String> subMap = virtualNodes.tailMap(hash);  // 得到大于等于该Hash值的Map的视图
        Integer i = subMap.firstKey();  // 第一个Key就是顺时针过去离node最近的那个结点

        String virtualNode = subMap.get(i);
        return virtualNode.substring(0, virtualNode.indexOf("&&"));  // 返回对应的虚拟节点名称，这里字符串截取一下
    }
}