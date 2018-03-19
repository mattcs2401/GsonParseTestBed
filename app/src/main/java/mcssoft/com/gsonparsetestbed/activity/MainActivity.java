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
                reader = new JsonReader( new InputStreamReader(is, "UTF-8"));

                parse();

                is.close();
            }
        } catch(Exception ex) {
            bp = "";
        } finally {
        }
    }

    private void parse() {
        JsonToken token;

        try {
            reader.beginObject();
            while (reader.hasNext()) {
                token = reader.peek();
                if(!otherToken(token)) {
                    switch(token) {
                        case NAME:
                            if(reader.nextName().equals("RaceDay")) {
                                parseRaceDay();
                            }
                        break;
//                        case BOOLEAN:
//                            reader.nextBoolean();
//                            break;
//                        case NUMBER:
//                            reader.nextLong();
//                            break;
//                        case STRING:
//                            reader.nextString();
//                            break;
//                        case NULL:
//                            reader.nextNull();
//                            break;
                        case END_DOCUMENT:
                            break;
                        default:
                            reader.skipValue();
                    }
                }
            }
        } catch (Exception ex) {
            String bp = "";
        }
    }

    private void parseRaceDay() throws IOException {
        String name;
        JsonToken token;
        raceDay = new RaceDay();

        reader.beginObject();

        while(reader.hasNext()) {
            token = reader.peek();
            if(!otherToken(token)) {
                switch (token) {
                    case NAME:
                        name = reader.nextName();
                        if (name.equals("MeetingDate")) {
                            raceDay.setMeetingDate(reader.nextString());
                        } else if (name.equals("Meetings")) {
                            lMeetings = new ArrayList<>();
                            parseMeetings();
                        }
                        break;
                    default:
                        reader.skipValue();
                }
            }
        }
    }

    private void parseMeetings() throws IOException {
        String name;
        JsonToken token;

        reader.beginArray();
        reader.beginObject();

        while(reader.hasNext()) {
            token = reader.peek();
            if(!otherToken(token)) {
                switch (token) {
                    case NAME:
                        name = reader.nextName(); // debug
                        switch (name) {
                            case "Abandoned":
                                meeting = new Meeting();
                                meeting.setAbandoned(reader.nextBoolean());
                                break;
                            case "MeetingId":
                                meeting.setMeetingId(reader.nextLong());
                                break;
                            case "MeetingCode":
                                meeting.setMeetingCode(reader.nextString());
                                break;
                            case "VenueName":
                                meeting.setVenueName(reader.nextString());
                                break;
                            case "Races":
                                // get the Race info for this meeting.
                                parseRaces(meeting);
                                // add to the list.
                                lMeetings.add(meeting);
                                break;
                        }
                        break;
                    default:
                        reader.skipValue();
                }
            }
        }
    }

    /**
     * Parse the Race information.
     * @param meeting The Meeting associated with the racing information.
     */
    private void parseRaces(Meeting meeting) throws IOException {
        String name;
        JsonToken token;
        boolean haveRaces = false;

        reader.beginArray();
        reader.beginObject();

        try {
            while (reader.hasNext() && haveRaces == false) {
                token = reader.peek();
                if (!otherToken(token)) {
                    switch (token) {
                        case NAME:
                            name = reader.nextName(); // debug
                            switch (name) {
                                case "StatusDescription":  // without this, was throwing IllegalStateException ??
                                    reader.nextString();   //
                                    reader.endObject();    //
                                    break;
                                case "RaceNumber":
                                    race = new Race();
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
                                    race.setWeatherCondition(reader.nextString());
                                    break;
                                case "TrackCondition":
                                    race.setTrackCondition(reader.nextString());
                                    break;
                                case "TrackRating":
                                    race.setTrackRating(reader.nextLong());
                                    break;
                                case "Pools":
                                    // got all the Race info we want.
                                    meeting.addRace(race);
                                    // TODO - something to indicate last Race.
                                    //haveRaces = true;
                            }
                            break;
                        default:
                            reader.skipValue();
                    }
                }
            }
        } catch(Exception ex) {
            String bp = "";
        }
    }

    private boolean otherToken(JsonToken token) throws IOException {
        switch(token) {
            case BEGIN_OBJECT:
                reader.beginObject();
                return true;
            case END_OBJECT:
                reader.endObject();
                return true;
            case BEGIN_ARRAY:
                reader.beginArray();
                return true;
            case END_ARRAY:
                reader.endArray();
                return true;
            case BOOLEAN:
                reader.nextBoolean();
                return true;
            case NUMBER:
                reader.nextLong();
                return true;
            case STRING:
                reader.nextString();
                return true;
            case NULL:
                reader.nextNull();
                return true;
        }
        return false;
    }

//    private String name;
    private JsonReader reader;
    private RaceDay raceDay;
    private Meeting meeting;
    private Race race;
    private List<Meeting> lMeetings;
}
