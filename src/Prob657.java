
public class Prob657 {
	public boolean judgeCircle(String moves) {
        int x, y;
        x = y = 0;
        char c;
        for(int i = 0; i < moves.length(); i++) {
            c = moves.charAt(i);
            switch(c) {
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'L':
                    y--;
                    break;
                case 'R':
                    y++;
                    break;
                default:
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}
