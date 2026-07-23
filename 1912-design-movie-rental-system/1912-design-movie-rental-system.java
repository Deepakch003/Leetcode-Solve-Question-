import java.util.*;

class MovieRentingSystem {

    class Available {
        int price, shop;

        Available(int price, int shop) {
            this.price = price;
            this.shop = shop;
        }
    }

    class Rented {
        int price, shop, movie;

        Rented(int price, int shop, int movie) {
            this.price = price;
            this.shop = shop;
            this.movie = movie;
        }
    }


    private Map<Integer, TreeSet<Available>> available;

    
    private Map<Long, Integer> priceMap;


    private TreeSet<Rented> rented;

    public MovieRentingSystem(int n, int[][] entries) {

        available = new HashMap<>();
        priceMap = new HashMap<>();

        rented = new TreeSet<>((a, b) -> {
            if (a.price != b.price)
                return a.price - b.price;
            if (a.shop != b.shop)
                return a.shop - b.shop;
            return a.movie - b.movie;
        });

        for (int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];

            available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                if (a.price != b.price)
                    return a.price - b.price;
                return a.shop - b.shop;
            }));

            available.get(movie).add(new Available(price, shop));
            priceMap.put(getKey(shop, movie), price);
        }
    }

    public List<Integer> search(int movie) {

        List<Integer> ans = new ArrayList<>();

        if (!available.containsKey(movie))
            return ans;

        int cnt = 0;

        for (Available a : available.get(movie)) {
            ans.add(a.shop);
            if (++cnt == 5)
                break;
        }

        return ans;
    }

    public void rent(int shop, int movie) {

        int price = priceMap.get(getKey(shop, movie));

        available.get(movie).remove(new Available(price, shop));
        rented.add(new Rented(price, shop, movie));
    }

    public void drop(int shop, int movie) {

        int price = priceMap.get(getKey(shop, movie));

        rented.remove(new Rented(price, shop, movie));
        available.get(movie).add(new Available(price, shop));
    }

    public List<List<Integer>> report() {

        List<List<Integer>> ans = new ArrayList<>();

        int cnt = 0;

        for (Rented r : rented) {
            ans.add(Arrays.asList(r.shop, r.movie));
            if (++cnt == 5)
                break;
        }

        return ans;
    }

    private long getKey(int shop, int movie) {
        return (((long) shop) << 32) | movie;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop, movie);
 * obj.drop(shop, movie);
 * List<List<Integer>> param_4 = obj.report();
 */