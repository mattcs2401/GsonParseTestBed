
package mcssoft.com.gsonparsetestbed.model;

import com.google.gson.annotations.SerializedName;

public class Race {

    @SerializedName("Distance")
    private Long mDistance;
    @SerializedName("FeatureRaceBonusActive")
    private String mFeatureRaceBonusActive;
    @SerializedName("RaceName")
    private String mRaceName;
    @SerializedName("RaceNumber")
    private Long mRaceNumber;
    @SerializedName("RaceTime")
    private String mRaceTime;
    @SerializedName("Status")
    private String mStatus;
    @SerializedName("TrackChanged")
    private Boolean mTrackChanged;
    @SerializedName("TrackCondition")
    private String mTrackCondition;
    @SerializedName("TrackConditionLevel")
    private Long mTrackConditionLevel;
    @SerializedName("TrackRating")
    private Long mTrackRating;
    @SerializedName("TrackRatingChanged")
    private Boolean mTrackRatingChanged;
    @SerializedName("WeatherChanged")
    private Boolean mWeatherChanged;
    @SerializedName("WeatherCondition")
    private String mWeatherCondition;
    @SerializedName("WeatherConditionLevel")
    private Long mWeatherConditionLevel;

    public Long getDistance() {
        return mDistance;
    }

    public void setDistance(Long Distance) {
        mDistance = Distance;
    }

    public String getFeatureRaceBonusActive() {
        return mFeatureRaceBonusActive;
    }

    public void setFeatureRaceBonusActive(String FeatureRaceBonusActive) {
        mFeatureRaceBonusActive = FeatureRaceBonusActive;
    }

    public String getRaceName() {
        return mRaceName;
    }

    public void setRaceName(String RaceName) {
        mRaceName = RaceName;
    }

    public Long getRaceNumber() {
        return mRaceNumber;
    }

    public void setRaceNumber(Long RaceNumber) {
        mRaceNumber = RaceNumber;
    }

    public String getRaceTime() {
        return mRaceTime;
    }

    public void setRaceTime(String RaceTime) {
        mRaceTime = RaceTime;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String Status) {
        mStatus = Status;
    }

    public Boolean getTrackChanged() {
        return mTrackChanged;
    }

    public void setTrackChanged(Boolean TrackChanged) {
        mTrackChanged = TrackChanged;
    }

    public String getTrackCondition() {
        return mTrackCondition;
    }

    public void setTrackCondition(String TrackCondition) {
        mTrackCondition = TrackCondition;
    }

    public Long getTrackConditionLevel() {
        return mTrackConditionLevel;
    }

    public void setTrackConditionLevel(Long TrackConditionLevel) {
        mTrackConditionLevel = TrackConditionLevel;
    }

    public Long getTrackRating() {
        return mTrackRating;
    }

    public void setTrackRating(Long TrackRating) {
        mTrackRating = TrackRating;
    }

    public Boolean getTrackRatingChanged() {
        return mTrackRatingChanged;
    }

    public void setTrackRatingChanged(Boolean TrackRatingChanged) {
        mTrackRatingChanged = TrackRatingChanged;
    }

    public Boolean getWeatherChanged() {
        return mWeatherChanged;
    }

    public void setWeatherChanged(Boolean WeatherChanged) {
        mWeatherChanged = WeatherChanged;
    }

    public String getWeatherCondition() {
        return mWeatherCondition;
    }

    public void setWeatherCondition(String WeatherCondition) {
        mWeatherCondition = WeatherCondition;
    }

    public Long getWeatherConditionLevel() {
        return mWeatherConditionLevel;
    }

    public void setWeatherConditionLevel(Long WeatherConditionLevel) {
        mWeatherConditionLevel = WeatherConditionLevel;
    }

}
