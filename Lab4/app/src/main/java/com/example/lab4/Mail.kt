package com.example.lab4

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.RequiresApi

data class Mail(
    var sender: User,
    var title: String,
    var body: String,
    var date: String,
    var starred: Boolean,
    var tags: String
) :
    Parcelable {
    @RequiresApi(Build.VERSION_CODES.Q)
    constructor(parcel: Parcel) : this(
        parcel.readParcelable<User>(null)!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readBoolean(),
        parcel.readString()!!
    ) {
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun writeToParcel(parcel: Parcel?, flags: Int) {
        parcel?.writeParcelable(sender, 0)
        parcel?.writeString(title)
        parcel?.writeString(date)
        parcel?.writeString(body)
        parcel?.writeBoolean(starred)
        parcel?.writeString(tags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mail> {
        @RequiresApi(Build.VERSION_CODES.Q)
        override fun createFromParcel(parcel: Parcel): Mail {
            return Mail(parcel)
        }

        override fun newArray(size: Int): Array<Mail?> {
            return arrayOfNulls(size)
        }
    }

}