import java.util.*;

class Spreadsheet {

    private Map<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell);
    }

    public int getValue(String formula) {
    
        formula = formula.substring(1);

        String[] parts = formula.split("\\+");

        return get(parts[0]) + get(parts[1]);
    }

    private int get(String s) {
        
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }

        
        return map.getOrDefault(s, 0);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell, value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */