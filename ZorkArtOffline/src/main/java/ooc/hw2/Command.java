package ooc.hw2;

public class Command {
    private String word1;
    private String word2;

    public Command(String a,String b){
        word1=a;
        word2=b;
    }
    public boolean executeCommand(){
        return false;
    }
}
