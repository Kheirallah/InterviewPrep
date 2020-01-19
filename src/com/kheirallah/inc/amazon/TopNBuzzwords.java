package com.kheirallah.inc.amazon;

/*
You work on a team whose job is to understand the most sought after toys for the holiday season. A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles. You need to take these quotes and identify which toys are mentioned most frequently. Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.

Your algorithm should output the top N toys mentioned most frequently in the quotes.

Input:
The input to the function/method consists of five arguments:

numToys, an integer representing the number of toys
topToys, an integer representing the number of top toys your algorithm needs to return;
toys, a list of strings representing the toys,
numQuotes, an integer representing the number of quotes about toys;
quotes, a list of strings that consists of space-sperated words representing articles about toys

Output:
Return a list of strings of the most popular N toys in order of most to least frequently mentioned

Note:
The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.

Example 1:

Input:
numToys = 6
topToys = 2
toys = ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"]
numQuotes = 6
quotes = [
"Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
"The new Elmo dolls are super high quality",
"Expect the Elsa dolls to be very popular this year, Elsa!",
"Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
"For parents of older kids, look into buying them a drone",
"Warcraft is slowly rising in popularity ahead of the holiday season"
];

Output:
["elmo", "elsa"]

Explanation:
elmo - 4
elsa - 4
"elmo" should be placed before "elsa" in the result because "elmo" appears in 3 different quotes and "elsa" appears in 2 different quotes.
 */

import java.util.*;

public class TopNBuzzwords {

    //Time Complexity O(NLOG(K)) where K is the size of toys you want to search for
    private static List<String> returnTopToys(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {
        Map<String, int[]> toysToOccurences = new HashMap<>();
        List<String> topToysListed = new ArrayList<>();

        for (String toy : toys) {
            toysToOccurences.put(toy, new int[]{0, 0});
        }

        for (String quote : quotes) {
            Set<String> used = new HashSet<>();
            String[] words = quote.split("\\W+");
            for (String word : words) {
                String lcWord = word.toLowerCase();

                if (!toysToOccurences.containsKey(lcWord)) {
                    continue;
                }

                int[] nums = toysToOccurences.get(lcWord);
                nums[0]++;

                if (!used.contains(lcWord)) {
                    nums[1]++;
                }
                used.add(lcWord);
            }
        }

        Queue<String> sortedToysPriority = new PriorityQueue<>((t1, t2) -> {
            if (toysToOccurences.get(t1)[0] != toysToOccurences.get(t2)[0]) {
                return toysToOccurences.get(t1)[0] - toysToOccurences.get(t2)[0];
            }
            if (toysToOccurences.get(t1)[1] != toysToOccurences.get(t2)[1]) {
                return toysToOccurences.get(t1)[1] - toysToOccurences.get(t2)[1];
            }
            return t2.compareTo(t1);
        });

        if (topToys > numToys) {
            for (String toy : toysToOccurences.keySet()) {
                if (toysToOccurences.get(toy)[0] > 0) {
                    sortedToysPriority.add(toy);
                }
            }
        } else {
            for (String toy : toys) {
                sortedToysPriority.add(toy);

                if (sortedToysPriority.size() > topToys) {
                    sortedToysPriority.poll();
                }
            }
        }

        while (!sortedToysPriority.isEmpty()) {
            topToysListed.add(sortedToysPriority.poll());
        }

        Collections.reverse(topToysListed);

        return topToysListed;
    }

    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};
        List<String> result = returnTopToys(numToys, topToys, toys, numQuotes, quotes);
        System.out.println(result.toString());
    }
}
