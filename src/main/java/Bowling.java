public class Bowling {
    private String str;
    private int totalPt;
    private static final int ZEROPOINT = 0;
    private static final int TENPOINT = 10;

    public Bowling(String str){
        this.str = str;
        totalPt = 0;
    }

    public void calculation() {
        // remove space in the String
        str = str.replace(" ","");

        int length = str.length();
        int[] point = new int[length];
        boolean[] spare = new boolean[length];
        boolean[] strike = new boolean[length];
        // Convert string to points
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
            } else {
                point[i] = Character.getNumericValue(tmp);
            }
        }

        //calculate points
        boolean skip = false;
        for (int i = 0; i < length && !skip; i++) {
            if (strike[i] || spare[i]){
                //double points for next round when strike and spare
                totalPt += point[i+1];
                if(strike[i])//double points for next two round when strike
                    totalPt += point[i+2];
                if (i == length - 2 && spare[i])//last round when spare
                    skip = true;
                else if (i == length - 3 && strike[i])//last round when strike
                    skip = true;
            }
            totalPt += point[i];//add point for current round
        }
    }

    public int getPoint() {
        return totalPt;
    }
}
