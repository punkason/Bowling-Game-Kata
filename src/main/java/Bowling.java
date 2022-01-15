public class Bowling {
    private String str;
    private int totalPt;
    private static final int NOPOINT = 0;
    private static final int FULLPOINT = 10;

    public Bowling(){
        totalPt = 0;
    }

    public void setInput(String s) {
        str = s;
    }

    private void updateStr(){
        str = str.replace(" ","");// remove space in the String
        //str = str.replace("-","0");// Replace - to 0
    }

    private int[] strConvertInt(){
        int[] ch = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp == '-'){//handle 0 point
                ch[i] = NOPOINT;
            }else if(tmp == 'X'){//handle strike
                ch[i] = FULLPOINT;
            }else if(tmp == '/'){//handle spare
                ch[i] = FULLPOINT - ch[i-1];
            } else {
                ch[i] = Character.getNumericValue(tmp);
            }
        }
        return ch;

    }
    public void calculation() {
        updateStr();

        int[] ch = strConvertInt();
        for (int c : ch) {

            totalPt += c;
        }

    }

    public int getPoint() {
        return totalPt;
    }
}
