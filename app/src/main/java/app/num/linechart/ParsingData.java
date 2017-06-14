package app.num.linechart;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static app.num.linechart.MainActivityAdmin.json_data;

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
        try {
            Map<String, String> lineData = new TreeMap<>();
            JSONArray source = new JSONArray(json_data);

            for (int i = 0; i < source.length(); ++i) {
                lineData.put("value", source.getJSONObject(i).getString("value"));
                lineData.put("month", getMonth(source.getJSONObject(i).getString("date")));
                lineData.put("year",getYear(source.getJSONObject(i).getString("date"))
                        .concat("-").concat(source.getJSONObject(i).getString("value")));
                lineData.put("hour", getHeure(source.getJSONObject(i).getString("date"))
                        .concat("-").concat(source.getJSONObject(i).getString("value")));
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
        String heure = date.concat("h");
        return heure;
    }

    public String getYear(String date) {
        date = between(date,", "," ");
        date = before(date," ");
        return date;
    }


}
