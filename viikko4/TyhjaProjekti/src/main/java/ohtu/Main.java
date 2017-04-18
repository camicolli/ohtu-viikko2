package ohtu;


import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014485938";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String kurssinettisivu="https://ohtustats2017.herokuapp.com/courses/1.json";
        String bodyTexti2=Request.Get(kurssinettisivu).execute().returnContent().asString();
        
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        System.out.println("kurssi-Json");
        System.out.println(bodyTexti2);

        Gson mapper = new Gson();
        
         LectureCourse kurssi = mapper.fromJson(bodyTexti2, LectureCourse.class);
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        System.out.println(kurssi);
         System.out.println("opiskelijanro: " + subs[0].getStudent_number());
        int tunnit =0;
        int tehtavat=0;
         for (Submission submission : subs) {
          submission.setLectureCourse(kurssi);
          System.out.println(submission);
          tunnit +=submission.getHours();
          tehtavat+=submission.amountOfExercises();
          
        }
         System.out.println("yhteensä: " +tehtavat + " tehtävää " + tunnit + " tuntia");

    }
}