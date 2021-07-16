package se.lexicon;

public class Reverse {

    String stringReverse;

    public Reverse(String string){
        StringBuilder stringBuilder  = new StringBuilder(string.toUpperCase());
        this.stringReverse = stringBuilder.reverse().toString();



    }

    public String getStringReverse() {
        return stringReverse;
    }

    public void setStringReverse(String stringReverse) {
        this.stringReverse = stringReverse;
    }


}
