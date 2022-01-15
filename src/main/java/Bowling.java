public class Bowling {
    private String str;
    private int totalPt;

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
            if (str.charAt(i) == '-'){
                ch[i] = 0; //handle 0 point
            } else {
                ch[i] = Character.getNumericValue(str.charAt(i));
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
