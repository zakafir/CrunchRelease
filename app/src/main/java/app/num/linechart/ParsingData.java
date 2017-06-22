package app.num.linechart;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by zakaria_afir on 13/06/2017.
 */

class ParsingData {

    List<Map<String, String>> listData = new LinkedList<>();

    public ParsingData() {

    }

    public static String after(String value, String a) {
        // Returns a substring containing all characters after a string.
        int posA = value.lastIndexOf(a);
        if (posA == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= value.length()) {
            return "";
        }
        return value.substring(adjustedPosA);
    }

    public static String before(String value, String a) {
        // Return substring containing all characters before a string.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        return value.substring(0, posA);
    }

    public static String between(String value, String a, String b) {
        // Return a substring between the two strings.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        int posB = value.lastIndexOf(b);
        if (posB == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= posB) {
            return "";
        }
        return value.substring(adjustedPosA, posB);
    }

    public List<Map<String, String>> retrieve() {

        //essential to download data properly
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        try {
            Map<String, String> lineData = new TreeMap<>();
            JSONArray source = new JSONArray("[{\"id\":1,\"date\":\"Jun 22, 2017 3:29:13 AM\",\"value\":17.0},{\"id\":2,\"date\":\"Jun 22, 2017 3:29:14 AM\",\"value\":1024.0},{\"id\":3,\"date\":\"Jun 22, 2017 3:29:14 AM\",\"value\":816.0},{\"id\":4,\"date\":\"Jun 22, 2017 3:29:15 AM\",\"value\":325.0},{\"id\":5,\"date\":\"Jun 22, 2017 3:29:15 AM\",\"value\":143.0},{\"id\":6,\"date\":\"Jun 22, 2017 3:29:16 AM\",\"value\":64.0},{\"id\":7,\"date\":\"Jun 22, 2017 3:29:17 AM\",\"value\":29.0},{\"id\":8,\"date\":\"Jun 22, 2017 3:29:17 AM\",\"value\":13.0},{\"id\":9,\"date\":\"Jun 22, 2017 3:29:25 AM\",\"value\":328.0},{\"id\":10,\"date\":\"Jun 22, 2017 3:29:25 AM\",\"value\":1024.0},{\"id\":11,\"date\":\"Jun 22, 2017 3:29:26 AM\",\"value\":964.0},{\"id\":12,\"date\":\"Jun 22, 2017 3:29:26 AM\",\"value\":353.0},{\"id\":13,\"date\":\"Jun 22, 2017 3:29:27 AM\",\"value\":151.0},{\"id\":14,\"date\":\"Jun 22, 2017 3:29:27 AM\",\"value\":68.0},{\"id\":15,\"date\":\"Jun 22, 2017 3:29:28 AM\",\"value\":31.0},{\"id\":16,\"date\":\"Jun 22, 2017 3:29:29 AM\",\"value\":14.0},{\"id\":17,\"date\":\"Jun 22, 2017 3:29:29 AM\",\"value\":5.0},{\"id\":18,\"date\":\"Jun 22, 2017 3:32:01 AM\",\"value\":9.0},{\"id\":19,\"date\":\"Jun 22, 2017 3:32:02 AM\",\"value\":918.0},{\"id\":20,\"date\":\"Jun 22, 2017 3:32:02 AM\",\"value\":368.0},{\"id\":21,\"date\":\"Jun 22, 2017 3:32:03 AM\",\"value\":152.0},{\"id\":22,\"date\":\"Jun 22, 2017 3:32:04 AM\",\"value\":67.0},{\"id\":23,\"date\":\"Jun 22, 2017 3:32:04 AM\",\"value\":27.0},{\"id\":24,\"date\":\"Jun 22, 2017 3:32:05 AM\",\"value\":12.0},{\"id\":25,\"date\":\"Jun 22, 2017 4:10:47 AM\",\"value\":891.0},{\"id\":26,\"date\":\"Jun 22, 2017 4:10:48 AM\",\"value\":1010.0},{\"id\":27,\"date\":\"Jun 22, 2017 4:10:48 AM\",\"value\":512.0},{\"id\":28,\"date\":\"Jun 22, 2017 4:10:49 AM\",\"value\":207.0},{\"id\":29,\"date\":\"Jun 22, 2017 4:10:49 AM\",\"value\":92.0},{\"id\":30,\"date\":\"Jun 22, 2017 4:10:50 AM\",\"value\":42.0},{\"id\":31,\"date\":\"Jun 22, 2017 4:10:50 AM\",\"value\":19.0},{\"id\":32,\"date\":\"Jun 22, 2017 4:10:51 AM\",\"value\":8.0}]");

            String a = "";
            String b = "";

            for (int i = 0; i < source.length(); ++i) {
                a = getMinutes(source.getJSONObject(i).getString("date"));
                b = getSecondes(source.getJSONObject(i).getString("date"));
                lineData.put("value", source.getJSONObject(i).getString("value"));
                lineData.put("minute", a);
                lineData.put("month", getMonth(source.getJSONObject(i).getString("date")));
                lineData.put("year",getYear(source.getJSONObject(i).getString("date"))
                        .concat("-").concat(source.getJSONObject(i).getString("value")));
                lineData.put("hour", getHeure(source.getJSONObject(i).getString("date"))
                        .concat("-").concat(source.getJSONObject(i).getString("value"))
                        .concat("-").concat(a)
                        .concat("min").concat(b));
                listData.add(new TreeMap<String, String>(lineData));
                lineData.clear();
            }
        } catch (JSONException e) {
            Log.d("", e.getMessage());
        } finally {
            //Log listData value
            //Log.d("Data:", listData.toString());
        }
        return listData;
    }

    public String getMonth(String date) {
        if (date.contains("Jan")) {
            date = "January";
        } else if (date.contains("Feb")) {
            date = "February";
        } else if (date.contains("Mar")) {
            date = "March";
        } else if (date.contains("Apr")) {
            date = "April";
        } else if (date.contains("Jun")) {
            date = "June";
        } else if (date.contains("Jul")) {
            date = "July";
        } else if (date.contains("Aug")) {
            date = "August";
        } else if (date.contains("Sep")) {
            date = "September";
        } else if (date.contains("Oct")) {
            date = "October";
        } else if (date.contains("Nov")) {
            date = "November";
        } else {
            date = "December";
        }
        return date;
    }

    public String getHeure(String date) {
        date = between(date, " ", " ");
        date = after(date, " ");
        date = before(date, ":");
        String heure = date;
        return heure;
    }

    public String getMinutes(String date) {
        date = between(date, " ", " ");
        date = after(date, " ");
        date = between(date, ":", ":");
        String minute = date;
        return minute;
    }

    public String getSecondes(String date) {
        date = after(date, ":");
        date = before(date, " ");
        String minute = date;
        return minute;
    }



    public String getYear(String date) {
        date = between(date,", "," ");
        date = before(date," ");
        return date;
    }


}
