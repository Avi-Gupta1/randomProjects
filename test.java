import java.util.*;
class Test {
    public static int restValue(HashMap<Integer,Integer> map, int[] parent, int avoid,int[] files_size) {
        int sum = 0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] != avoid) {
                sum += files_size[i];
            }
        }

        return sum;
    }
    public static int dfs(HashMap<Integer,Set<Integer>> map, int src,HashSet<Integer> set,int[] files_size) {
        int val = files_size[src];
        set.add(src);
        if(map.containsKey(src)) {
            ArrayList<Integer> list = new ArrayList<>(map.get(src));
            for (int i: list) {
                if(!set.contains(i)) {
                 val += dfs(map,i,set,files_size);
                }
            }

        }
        

        return val;
        
    }

    public static int min(int[] parent,int[] files_size) {
        HashMap<Integer,Set<Integer>> map = new HashMap<>();

        for (int i = 1; i < parent.length; i++) {
            if(map.containsKey(parent[i])) {
                Set<Integer> set = map.get(parent[i]);
                set.add(i);
                map.put(parent[i],set); 
            }else{
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(parent[i], set);
            }
        }
        // System.out.println(map);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < parent.length; i++) {
             int subtree = 0;
             int subtree2 = 0;

            // if(map.containsKey(i)) {
            HashSet<Integer> set = new HashSet<>();
             subtree = dfs(map,i,set,files_size);
               System.out.println("Set 1 : "+ set+" With sum : "+ subtree);
             subtree2 = dfs(map,0,set,files_size);
               System.out.println("Set 2 : "+ set+" With sum : "+ subtree2);
            
            min = Math.min(min,Math.abs(subtree-subtree2));    
            if(min == 0) {
                return min;
            }

        }
// 
        // }
        
       
        return min;

    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] parents = new int[n];
        int[] files_size = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = s.nextInt();
        }
        for (int i = 0; i < n; i++) {
            files_size[i] = s.nextInt();
        }
        System.out.println(min(parents,files_size));
    }



}