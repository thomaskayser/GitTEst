package ch.tkayser.gittest.f1c;


public class Feature1992 {


    private String p1;
    private String p2;

    public Feature1992() {

    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }


    public void showMeTheInf() {
        System.out.println("Feature "+getClass().getName());
    }


}

