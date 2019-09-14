
public class Prob733 {
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    void floodFill(int [][] image, int sr, int sc, int newColor, int startingColor) {
        if(sr == -1 || sr == image.length || sc == -1 || sc == image[0].length || image[sr][sc] != startingColor || image[sr][sc] == newColor) return;
        
        if(image[sr][sc] == startingColor)
            image[sr][sc] = newColor;
        
        floodFill(image, sr - 1, sc, newColor, startingColor);
        floodFill(image, sr + 1, sc, newColor, startingColor);
        floodFill(image, sr, sc - 1, newColor, startingColor);
        floodFill(image, sr, sc + 1, newColor, startingColor);
    }
}
