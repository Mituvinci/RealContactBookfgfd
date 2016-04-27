package com.example.mitu.realcontactbook;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by mitu on 4/26/16.
 */
public class ContactModel extends RealmObject {

    private int mId;
    @Required
    public String mName;
    @Required
    public String mPhone;

    public ContactModel() {
    }

    public ContactModel(int mId, String mName, String mPhone) {
        this.mId = mId;
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public ContactModel(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}
