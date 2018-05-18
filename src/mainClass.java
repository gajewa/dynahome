import java.io.*;
import java.util.*;

public class mainClass {



    public static void main(String[] args) throws IOException {

        getRequest DynatraceRequest = new getRequest("http://dt-gwitczak-recruitment.westeurope.cloudapp.azure.com:8080/rest/task");
        DynatraceRequest.setAuthData("candidate", "abc123");


        BufferedReader in = new BufferedReader(new InputStreamReader(DynatraceRequest.getInputStream()));
        dynatraceDataParser parser = new dynatraceDataParser(in.readLine());
        in.close();

        parser.eliminateDuplicates();
        parser.sortList();

        System.out.println(parser.getPrimeNumbers());

    }
}
