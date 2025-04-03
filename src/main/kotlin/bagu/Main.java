package bagu;

interface Mama {
    void jiao();
}

class Dongwu {
    public void jiao(
            Mama mama
    ) {
        System.out.println("wo shi dong wu");
    }
}


public class Main {


    public static void main(String[] args) throws InterruptedException {
        Dongwu dongwu = new Dongwu();
        dongwu.jiao(new Mama() {
            @Override
            public void jiao() {
                System.out.println("wo shi mama");
            }
        });
    }


}
