/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    int res = 0;
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        
        for(Employee e : employees) 
            map.put(e.id, e);
        
        dfs(id);
        return res;
    }
    
    private void dfs(int id) {
        res += map.get(id).importance;
        for(int sid : map.get(id).subordinates)
            dfs(sid);
    }
}