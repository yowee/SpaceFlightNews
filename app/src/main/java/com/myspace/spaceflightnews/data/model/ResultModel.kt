package com.myspace.spaceflightnews.data.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("events")
    val events: List<EventModel>,
    @SerializedName("featured")
    val featured: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("launches")
    val launches: List<LauncheModel>,
    @SerializedName("news_site")
    val newsSite: String,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("url")
    val url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(EventModel.CREATOR) ?: emptyList(),
        parcel.readByte() != 0.toByte(),
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.createTypedArrayList(LauncheModel.CREATOR) ?: emptyList(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(events)
        parcel.writeByte(if (featured) 1 else 0)
        parcel.writeInt(id)
        parcel.writeString(imageUrl)
        parcel.writeTypedList(launches)
        parcel.writeString(newsSite)
        parcel.writeString(publishedAt)
        parcel.writeString(summary)
        parcel.writeString(title)
        parcel.writeString(updatedAt)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultModel> {
        override fun createFromParcel(parcel: Parcel): ResultModel {
            return ResultModel(parcel)
        }

        override fun newArray(size: Int): Array<ResultModel?> {
            return arrayOfNulls(size)
        }
    }
}
