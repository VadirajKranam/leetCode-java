class MyHashSet {
    Map<Integer,Integer> m;
    public MyHashSet() {
        m=new HashMap<>();
    }
    
    public void add(int key) {
        m.put(key,0);
    }
    
    public void remove(int key) {
        m.remove(key);
    }
    
    public boolean contains(int key) {
        return m.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */