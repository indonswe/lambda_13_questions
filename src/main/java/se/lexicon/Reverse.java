package se.lexicon;

public class Reverse {

    String stringReverse;

    public Reverse(String string){
        //System.out.println(string);
        //String stringIgnoreCase = string.toUpperCase();
        StringBuilder stringBuilder  = new StringBuilder(string);
        String stringReverse = stringBuilder.reverse().toString();

        //System.out.println(stringReverse);
    }

    public String getStringReverse() {
        return stringReverse;
    }

    public void setStringReverse(String stringReverse) {
        this.stringReverse = stringReverse;
    }
}
