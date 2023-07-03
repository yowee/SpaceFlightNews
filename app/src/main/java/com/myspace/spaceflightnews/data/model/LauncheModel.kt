package com.myspace.spaceflightnews.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class LauncheModel(
    @SerializedName("launch_id")
    val launchId: String,
    @SerializedName("provider")
    val provider: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(launchId)
        parcel.writeString(provider)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LauncheModel> {
        override fun createFromParcel(parcel: Parcel): LauncheModel {
            return LauncheModel(parcel)
        }

        override fun newArray(size: Int): Array<LauncheModel?> {
            return arrayOfNulls(size)
        }
    }
}
