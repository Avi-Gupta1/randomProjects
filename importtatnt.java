public static List<String> mostActive(List<String> customers) {
    // Write your code here
      HashMap<String,Integer> map = new HashMap<>();
      Collections.sort(customers);
      for (int i = 0; i < customers.size(); i++) {
          if(map.containsKey(customers.get(i))) {
              int val = map.get(customers.get(i));
              map.put(customers.get(i),val+1);
          }else{
                map.put(customers.get(i),1);
          }
      }
       HashSet<String> set = new HashSet<>();
       List<String> list = new ArrayList<>(); 
      int total = customers.size();
        for (int i = 0; i < customers.size(); i++) {
            if(!set.contains(customers.get(i))) {
                int val = map.get(customers.get(i));
                double ans = (double) val/total; 
                ans *= 100;
                if(ans >= 5.0) {
                    list.add(customers.get(i));
                }
                set.add(customers.get(i));
            }
        }
    return list;
    }