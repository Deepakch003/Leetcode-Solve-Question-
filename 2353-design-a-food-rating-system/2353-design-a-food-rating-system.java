import java.util.*;

class FoodRatings {

    class Food {
        String name;
        String cuisine;
        int rating;

        Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    
    private Map<String, Food> foodMap;

    
    private Map<String, TreeSet<Food>> cuisineMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

        foodMap = new HashMap<>();
        cuisineMap = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {

            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], food);

            cuisineMap.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
                if (a.rating != b.rating)
                    return b.rating - a.rating;      
                return a.name.compareTo(b.name);     
            }));

            cuisineMap.get(cuisines[i]).add(food);
        }
    }

    public void changeRating(String food, int newRating) {

        Food curr = foodMap.get(food);

        TreeSet<Food> set = cuisineMap.get(curr.cuisine);

        
        set.remove(curr);

        
        curr.rating = newRating;

        
        set.add(curr);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */