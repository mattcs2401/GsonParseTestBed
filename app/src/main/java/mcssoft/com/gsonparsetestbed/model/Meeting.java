
package mcssoft.com.gsonparsetestbed.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {

    public Meeting() {
        lRaces = new ArrayList<>();
    }

    private Boolean abandoned;
    private String meetingCode;
    private Long meetingId;
    private String meetingType;
    private List<Race> lRaces;
    private Boolean trackChanged;
    private String venueName;
    private Boolean weatherChanged;

    public Boolean getAbandoned() {
        return abandoned;
    }

    public void setAbandoned(Boolean Abandoned) {
        abandoned = Abandoned;
    }

    public String getMeetingCode() {
        return meetingCode;
    }

    public void setMeetingCode(String MeetingCode) {
        meetingCode = MeetingCode;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long MeetingId) {
        meetingId = MeetingId;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String MeetingType) {
        meetingType = MeetingType;
    }

    public List<Race> getRaces() {
        return lRaces;
    }

    public void setRaces(List<Race> Races) {
        lRaces = Races;
    }

    public void addRace(Race race) { lRaces.add(race); }

    public Race getRace(int ndx) { return lRaces.get(ndx); }

    public Boolean getTrackChanged() {
        return trackChanged;
    }

    public void setTrackChanged(Boolean TrackChanged) {
        trackChanged = TrackChanged;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String VenueName) {
        venueName = VenueName;
    }

    public Boolean getWeatherChanged() {
        return weatherChanged;
    }

    public void setWeatherChanged(Boolean WeatherChanged) {
        weatherChanged = WeatherChanged;
    }

}
