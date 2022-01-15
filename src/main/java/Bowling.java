public class Bowling {
    private String str;
    private int totalPt;
    private static final int ZERO_POINT = 0;
    private static final int TEN_POINT = 10;

    public Bowling(String str){
        this.str = str;
        totalPt = 0;
    }

    public void calculation() {
        // remove space in the String
        str = str.replace(" ","");

        final int LENGTH = str.length();
        int[] point = new int[LENGTH];
        boolean[] spare = new boolean[LENGTH];
        boolean[] strike = new boolean[LENGTH];
        // Convert string to points
        for (int i = 0; i < LENGTH; i++) {
            char tmp = str.charAt(i);
            if (tmp == '-') //handle 0 point
                point[i] = ZERO_POINT;
            else if(tmp == 'X'){ //handle strike
                point[i] = TEN_POINT;
                strike[i] = true;
            }else if(tmp == '/'){ //handle spare
                point[i] = TEN_POINT - point[i-1];
                spare[i] = true;
            } else
                point[i] = Character.getNumericValue(tmp);
        }

        //calculate points
        boolean lastRound = false;
        for (int i = 0; i < LENGTH && !lastRound; i++) {
            if (strike[i] || spare[i]){ //bonus points for strike and spare
                totalPt += point[i+1];
                if(strike[i]) //further bonus points for strike
                    totalPt += point[i+2];
                if ((i == LENGTH - 2 && spare[i]) || (i == LENGTH - 3 && strike[i]))//last round for spare and strike
                    lastRound = true;
            }
            totalPt += point[i]; //add point for current round
        }
    }

    public int getPoint() {
        return totalPt;
    }
}
