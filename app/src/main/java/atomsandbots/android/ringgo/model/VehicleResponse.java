package atomsandbots.android.ringgo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VehicleResponse {
    @SerializedName("count")
    int count;
    @SerializedName("vehicles")
    List<Vehicles> vehicles;
    @SerializedName("currentPage")
    int currentPage;
    @SerializedName("nextPage")
    int nextPage;
    @SerializedName("totalPages")
    int totalPages;

    public VehicleResponse(int count, List<Vehicles> vehicles, int currentPage, int nextPage, int totalPages) {
        this.count = count;
        this.vehicles = vehicles;
        this.currentPage = currentPage;
        this.nextPage = nextPage;
        this.totalPages = totalPages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
