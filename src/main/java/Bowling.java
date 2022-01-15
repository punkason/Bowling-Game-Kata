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
        str = str.replace(" ","");// remove space in the String

        // Convert string to points
        int length = str.length();
        int[] point = new int[length];
        boolean[] spare = new boolean[length];
        boolean[] strike = new boolean[length];

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
        }
    }

    public int getPoint() {
        return totalPt;
    }
}
