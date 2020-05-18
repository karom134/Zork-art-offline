package ooc.hw2;

public class Command {
    private String word1;
    private String word2;
//work with command word that come from Parser class.
    public Command(String a,String b){
        word1=a;
        word2=b;
    }
    public boolean executeCommand(){
        return false;
    }
}
