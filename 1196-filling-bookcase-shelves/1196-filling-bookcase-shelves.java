class Solution {
  int[][] memo = new int[1001][1001];

  public int minHeightShelves(int[][] books, int shelfWidth) {
    return minHeight(books, shelfWidth, 0, 0, 0);
  }

  int minHeight(int[][] books, int shelfWidth, int i, int curWidth, int maxHeightInShelf) {
    if (i == books.length) return maxHeightInShelf;
    if (memo[i][curWidth] != 0) return memo[i][curWidth];
    int width = books[i][0], height = books[i][1];
    memo[i][curWidth] = maxHeightInShelf + minHeight(books, shelfWidth, i + 1, width, height); // Start a new shelf
    if (width + curWidth <= shelfWidth) {
      int newHeight = Math.max(maxHeightInShelf, height);
      memo[i][curWidth] = Math.min(memo[i][curWidth], minHeight(books, shelfWidth, i + 1, width + curWidth, newHeight));
    }
    return memo[i][curWidth];
  }
}