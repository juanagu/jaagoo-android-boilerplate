package co.jagu.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by juanagu on 13/8/17.
 */
@Entity(tableName = "persons")
public class PersonEntity {

    /*--
    Fields
    --*/
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long mId;

    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @ColumnInfo(name = "last_name")
    private String mLastName;

    @ColumnInfo(name = "avatar")
    private String mAvatar;

    /*--
    Getters and setters
    --*/

    public long getId() {
        return mId;
    }

    public void setId(long mId) {
        this.mId = mId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String mAvatar) {
        this.mAvatar = mAvatar;
    }
}
