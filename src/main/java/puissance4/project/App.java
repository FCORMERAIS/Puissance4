package puissance4.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {   
        InputStreamReader bis = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(bis);
        int what = Integer.parseInt(br.readLine());
        if (what == 2) {Server.LunchServeur(2);}else {Client.LunchClient(2);}
    }

}
