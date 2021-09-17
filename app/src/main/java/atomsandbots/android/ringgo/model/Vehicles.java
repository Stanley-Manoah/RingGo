package atomsandbots.android.ringgo.model;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Vehicles implements Parcelable {
    @SerializedName("vehicleId")
    int vehicleId;
    @SerializedName("vrn")
    String vrn;
    @SerializedName("country")
    String country;
    @SerializedName("color")
    String color;
    @SerializedName("type")
    String type;

    @SerializedName("default")
    String _default;


    public Vehicles(int vehicleId, String vrn, String country, String color, String type, String _default) {
        this.vehicleId = vehicleId;
        this.vrn = vrn;
        this.country = country;
        this.color = color;
        this.type = type;
        this._default = _default;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String get_default() {
        return _default;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVrn() {
        return vrn;
    }

    public void setVrn(String vrn) {
        this.vrn = vrn;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(vehicleId);
        parcel.writeString(vrn);
        parcel.writeString(country);
        parcel.writeString(color);
        parcel.writeString(type);
        parcel.writeString(_default);


    }

    public static final Parcelable.Creator<Vehicles> CREATOR
            = new Parcelable.Creator<Vehicles>() {
        public Vehicles createFromParcel(Parcel in) {
            return new Vehicles(in);
        }

        public Vehicles[] newArray(int size) {
            return new Vehicles[size];
        }
    };

    private Vehicles(Parcel in) {
        vehicleId = in.readInt();
        vrn = in.readString();
        country = in.readString();
        color = in.readString();
        type = in.readString();
        _default = in.readString();

    }
}