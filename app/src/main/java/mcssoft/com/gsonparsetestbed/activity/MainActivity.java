package mcssoft.com.gsonparsetestbed.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import mcssoft.com.gsonparsetestbed.R;
import mcssoft.com.gsonparsetestbed.model.Meeting;
import mcssoft.com.gsonparsetestbed.model.Race;
import mcssoft.com.gsonparsetestbed.model.RaceDay;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();
        String bp;
        InputStream is = null;
        try {
            is = getResources().getAssets().open("test_data.txt");

            if(is != null) {
                Gson gson = new Gson();
                reader = new JsonReader( new InputStreamReader(is, "UTF-8"));
//                RaceDay raceDay = gson.fromJson(reader, RaceDay.class);
                parse();

                is.close();
            }
        } catch(Exception ex) {
            bp = "";
        } finally {
        }
    }

    private void parse() {
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                token = reader.peek();
                switch(token) {
                    case BEGIN_OBJECT:
                        reader.beginObject();
                        break;
                    case END_OBJECT:
                        reader.endObject();
                        break;
                    case BEGIN_ARRAY:
                        reader.beginArray();
                        break;
                    case END_ARRAY:
                        reader.endArray();
                        break;
                    case NAME:
                        name = reader.nextName();
                        if(name.equals("RaceDay")) {
                            parseRaceDay();
                        }
                        break;
                    case BOOLEAN:
                        boolean b = reader.nextBoolean();
                        break;
                    case NUMBER:
                        long l = reader.nextLong();
                        break;
                    case STRING:
                        String s = reader.nextString();
                        break;
                    case NULL:
                        reader.nextNull();
                        break;
                    case END_DOCUMENT:
                        break;
                    default:
                        reader.skipValue();
                }
            }
        } catch (Exception ex) {
            bp = "";
        }
    }

    private void parseRaceDay() throws IOException {
        raceDay = new RaceDay();

        reader.beginObject();

        while(reader.hasNext()) {
            token = reader.peek();
            switch(token) {
                case NAME:
                    name = reader.nextName();
                    if(name.equals("MeetingDate")) {
                        raceDay.setMeetingDate(reader.nextString());
                    } else if(name.equals("Meetings")) {
                        parseMeetings();
                    }
                    break;
                default:
                    reader.skipValue();
            }
        }
    }

    private void parseMeetings() throws IOException {
        lMeetings = new ArrayList<Meeting>();
//        String[] names = new String[] {"Abandoned","MeetingId","MeetingCode","VenueName"};
        reader.beginArray();
        reader.beginObject();

        while(reader.hasNext()) {
            token = reader.peek();
            switch(token) {
                case NAME:
                    name = reader.nextName();
                    if(name.equals("Abandoned")) {
                        // begining of Meeting info.
                        meeting = new Meeting();
                    }
                    switch(name) {
                        case "Abandoned":
                            meeting.setAbandoned(reader.nextBoolean());
                            break;
                        case "MeetingId":
                            meeting.setMeetingId(reader.nextLong());
                            break;
                        case "MeetingCode":
                            meeting.setMeetingCode(reader.nextString());
                            break;
                        case "VenueName":
                            meeting.setMeetingCode(reader.nextString());
                            break;
                        case "Races":
                            parseRaces(meeting);
                            break;
                    }
                    break;
                default:
                    reader.skipValue();
            }
        }
    }

    /**
     * Parse the Race information.
     * @param meeting The Meeting associated with the racing information.
     */
    private void parseRaces(Meeting meeting) throws IOException {

        reader.beginArray();
        reader.beginObject();

        while(reader.hasNext()) {
            token = reader.peek();
            switch (token) {
                case NAME:
                    name = reader.nextName();
                    if(name.equals("RaceNumber")) {
                        race = new Race();
                    }
                    switch(name) {
                        case "RaceNumber":
                            race.setRaceNumber(reader.nextLong());
                            break;
                        case "RaceTime":
                            race.setRaceTime(reader.nextString());
                            break;
                        case "RaceName":
                            race.setRaceName(reader.nextString());
                            break;
                        case "RaceDistance":
                            race.setDistance(reader.nextLong());
                            break;
                        case "WeatherCondition":
                            race.setRaceName(reader.nextString());
                            break;
                        case "TrackCondition":
                            race.setRaceName(reader.nextString());
                            break;
                        case "TrackRating":
                            race.setDistance(reader.nextLong());
                            break;
                    }
                    break;
                default:
                    reader.skipValue();
            }
        }
    }

    private String bp;
    private String name;
    private JsonToken token;
    private JsonReader reader;
    private RaceDay raceDay;
    private Meeting meeting;
    private Race race;
    private List<Meeting> lMeetings;
}
