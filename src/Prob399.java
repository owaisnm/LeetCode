import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Prob399 {
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        double[] sol = new double[queries.size()];
        
        // create adjacency list
        Map<String, List<String>> adjacencyMap = new HashMap<>();
        Map<String, Double> edgesMap = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            List<String> vertices = adjacencyMap.get(eq.get(0));
            if(vertices == null) {
                vertices = new ArrayList<>();
            }
            vertices.add(eq.get(1));
            adjacencyMap.put(eq.get(0), vertices);
            vertices = adjacencyMap.get(eq.get(1));
            if(vertices == null) {
                vertices = new ArrayList<>();
            }
            vertices.add(eq.get(0));
            adjacencyMap.put(eq.get(1), vertices);
            
            edgesMap.put(eq.get(0) + eq.get(1), values[i]);
            edgesMap.put(eq.get(1) + eq.get(0), 1/ values[i]);
        }
        
        Stack<String> stringStack = new Stack<>();
        Stack<Double> valuesStack = new Stack<>();
        
        for(int i = 0; i < queries.size(); i++) { 
            
            List<String> query = queries.get(i);
            String startString = query.get(0);
            String endString = query.get(1);
            String currentString;
            Double currentValue;
            String combinedString;
            boolean solved = false;
            Set<String> visited = new HashSet<>();
            if(!adjacencyMap.containsKey(startString) || !adjacencyMap.containsKey(endString)) {
                sol[i] = -1.0;
                continue;
            } else if(startString.equals(endString)) {
                sol[i] = 1.0;
                continue;
            } else {
                stringStack.clear();
                valuesStack.clear();
                visited.clear();
                
                stringStack.push(startString);
                valuesStack.push(1.0);
                while(!stringStack.isEmpty())  {
                    currentString = stringStack.pop();
                    currentValue = valuesStack.pop();
                    visited.add(currentString);
                    for(String nextString : adjacencyMap.get(currentString)) {
                        if(!visited.contains(nextString)) {
                            combinedString = currentString+nextString;
                            Double nextValue = edgesMap.get(combinedString);
                            if(nextString.equals(endString)) {
                                sol[i] = currentValue * nextValue;
                                solved = true;
                            } else if(nextValue == null) {
                                continue;
                            } else {
                                stringStack.push(nextString);
                                valuesStack.push(currentValue*nextValue);
                            }
                        }
                    }
                }
                if(!solved) {
                    sol[i] = -1;
                }
            }
        }
        return sol;
    }
}
