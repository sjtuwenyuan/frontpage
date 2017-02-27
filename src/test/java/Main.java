import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Wen on 17/2/26.
 */
public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        Date date = sdf.parse("2017-02-26-16:14:09");
        System.out.println(date);
    }
}
