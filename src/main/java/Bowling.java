public class Bowling {
    private String str;
    private int totalPt;
    private boolean spare[];
    private boolean strike[];
    private int point[];
    private static final int NOPOINT = 0;
    private static final int FULLPOINT = 10;

    public Bowling(){
        totalPt = 0;
    }

    public void setInput(String s) {
        str = s;
    }

    public void calculation() {
        str = str.replace(" ","");// remove space in the String

        int length = str.length();
        point = new int[length];
        spare = new boolean[length];
        strike = new boolean[length];

        for (int i = 0; i < length; i++) {
            char tmp = str.charAt(i);
            if (tmp == '-'){//handle 0 point
                point[i] = NOPOINT;
            }else if(tmp == 'X'){//handle strike
                point[i] = FULLPOINT;
                strike[i] = true;
            }else if(tmp == '/'){//handle spare
                point[i] = FULLPOINT - point[i-1];
                spare[i] = true;
            } else {
                point[i] = Character.getNumericValue(tmp);
            }
        }

        for (int i = 0; i < length; i++) {
            int lastRound = length - 3;
            if (i == lastRound && point[lastRound] == 10)
                break;
            else
                totalPt += point[i];
        }

        handleStrike();

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
