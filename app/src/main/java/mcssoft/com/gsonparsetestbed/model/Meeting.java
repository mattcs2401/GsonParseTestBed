
package mcssoft.com.gsonparsetestbed.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Meeting {

    @SerializedName("Abandoned")
    private Boolean mAbandoned;
    @SerializedName("BoxChallengeAvailable")
    private Boolean mBoxChallengeAvailable;
    @SerializedName("DriverChallengeAvailable")
    private Boolean mDriverChallengeAvailable;
    @SerializedName("JockeyChallengeAvailable")
    private Boolean mJockeyChallengeAvailable;
    @SerializedName("MeetingCode")
    private String mMeetingCode;
    @SerializedName("MeetingId")
    private Long mMeetingId;
    @SerializedName("MeetingType")
    private String mMeetingType;
    @SerializedName("Races")
    private List<Race> mRaces;
    @SerializedName("TrackChanged")
    private Boolean mTrackChanged;
    @SerializedName("VenueName")
    private String mVenueName;
    @SerializedName("WeatherChanged")
    private Boolean mWeatherChanged;

    public Boolean getAbandoned() {
        return mAbandoned;
    }

    public void setAbandoned(Boolean Abandoned) {
        mAbandoned = Abandoned;
    }

    public Boolean getBoxChallengeAvailable() {
        return mBoxChallengeAvailable;
    }

    public void setBoxChallengeAvailable(Boolean BoxChallengeAvailable) {
        mBoxChallengeAvailable = BoxChallengeAvailable;
    }

    public Boolean getDriverChallengeAvailable() {
        return mDriverChallengeAvailable;
    }

    public void setDriverChallengeAvailable(Boolean DriverChallengeAvailable) {
        mDriverChallengeAvailable = DriverChallengeAvailable;
    }

    public Boolean getJockeyChallengeAvailable() {
        return mJockeyChallengeAvailable;
    }

    public void setJockeyChallengeAvailable(Boolean JockeyChallengeAvailable) {
        mJockeyChallengeAvailable = JockeyChallengeAvailable;
    }

    public String getMeetingCode() {
        return mMeetingCode;
    }

    public void setMeetingCode(String MeetingCode) {
        mMeetingCode = MeetingCode;
    }

    public Long getMeetingId() {
        return mMeetingId;
    }

    public void setMeetingId(Long MeetingId) {
        mMeetingId = MeetingId;
    }

    public String getMeetingType() {
        return mMeetingType;
    }

    public void setMeetingType(String MeetingType) {
        mMeetingType = MeetingType;
    }

    public List<Race> getRaces() {
        return mRaces;
    }

    public void setRaces(List<Race> Races) {
        mRaces = Races;
    }

    public Boolean getTrackChanged() {
        return mTrackChanged;
    }

    public void setTrackChanged(Boolean TrackChanged) {
        mTrackChanged = TrackChanged;
    }

    public String getVenueName() {
        return mVenueName;
    }

    public void setVenueName(String VenueName) {
        mVenueName = VenueName;
    }

    public Boolean getWeatherChanged() {
        return mWeatherChanged;
    }

    public void setWeatherChanged(Boolean WeatherChanged) {
        mWeatherChanged = WeatherChanged;
    }

}
