
package mcssoft.com.gsonparsetestbed.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RaceDay {

//    @SerializedName("CurrentDay")
//    private Boolean mCurrentDay;
//    @SerializedName("ErrorInfo")
//    private Object mErrorInfo;
    @SerializedName("MeetingDate")
    private String mMeetingDate;
    @SerializedName("Meetings")
    private List<Meeting> mMeetings;
//    @SerializedName("RaceDay")
//    private RaceDay mRaceDay;
//    @SerializedName("Success")
//    private Boolean mSuccess;

//    public Boolean getCurrentDay() {
//        return mCurrentDay;
//    }
//
//    public void setCurrentDay(Boolean CurrentDay) {
//        mCurrentDay = CurrentDay;
//    }
//
//    public Object getErrorInfo() {
//        return mErrorInfo;
//    }
//
//    public void setErrorInfo(Object ErrorInfo) {
//        mErrorInfo = ErrorInfo;
//    }

    public String getMeetingDate() {
        return mMeetingDate;
    }

    public void setMeetingDate(String MeetingDate) {
        mMeetingDate = MeetingDate;
    }

    public List<Meeting> getMeetings() {
        return mMeetings;
    }

    public void setMeetings(List<Meeting> Meetings) {
        mMeetings = Meetings;
    }

//    public RaceDay getRaceDay() {
//        return mRaceDay;
//    }
//
//    public void setRaceDay(RaceDay RaceDay) {
//        mRaceDay = RaceDay;
//    }
//
//    public Boolean getSuccess() {
//        return mSuccess;
//    }
//
//    public void setSuccess(Boolean Success) {
//        mSuccess = Success;
//    }

}
