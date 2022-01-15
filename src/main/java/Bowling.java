public class Bowling {
    private String str;
    private int totalPt;
    private boolean spare[];
    private boolean strike[];
    private int point[];
    private int round;
    private static final int ZEROPOINT = 0;
    private static final int TENPOINT = 10;
    //private static final int TENGAME = 10;

    public Bowling(String str){
        this.str = str;
        totalPt = 0;
        round = 1;
    }

    public void calculation() {
        //round = str.count(' ');
        //str.
        str = str.replace(" ","");// remove space in the String

        // Convert string to points
        int length = str.length();
        point = new int[length];
        spare = new boolean[length];
        strike = new boolean[length];

        for (int i = 0; i < length; i++) {
            char tmp = str.charAt(i);
            if (tmp == '-'){//handle 0 point
                point[i] = ZEROPOINT;
            }else if(tmp == 'X'){//handle strike
                point[i] = TENPOINT;
                strike[i] = true;
            }else if(tmp == '/'){//handle spare
                point[i] = TENPOINT - point[i-1];
                spare[i] = true;
            } else if (tmp == ' '){ // can delete
                round++;
            } else {
                point[i] = Character.getNumericValue(tmp);
            }
        }

        //calculate points
        boolean skip = false;
        for (int i = 0; i < length && !skip; i++) {
            if (strike[i] || spare[i]){
                //double next round for strike and spare
                totalPt += point[i+1];
                if(strike[i]){//double next two round for strike
                    totalPt += point[i+2];
                }
                if (i == length - 2 && spare[i]){
                    skip = true;
                }else if (i == length - 3 && strike[i]){
                    skip = true;
                }
            }
            totalPt += point[i];
            System.out.print(totalPt + ", ");
            /*int lastRound = length - 3;
            if ( i == lastRound && round > 10 && point[lastRound] == 10)
                continue;
            else
                totalPt += point[i];

             */
        }

        //handleStrike();

    }

    private void handleStrike() {
        int length = strike.length;
        for (int i = 0; i < length;i++) {
            if (strike[i]) {
                if (i + 1 < length) totalPt += point[i + 1];
                if (i + 2 < length) totalPt += point[i + 2];
            // strike[i] = false;
            }
        }
    }

    public int getPoint() {
        return totalPt;
    }
}
