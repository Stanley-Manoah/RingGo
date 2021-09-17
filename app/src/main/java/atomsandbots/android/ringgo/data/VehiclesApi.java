package atomsandbots.android.ringgo.data;

import atomsandbots.android.ringgo.model.VehicleResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface VehiclesApi {

    // url path.
    @GET("/vehicles")
    // call data from array with getVehicles.
    Call<VehicleResponse> getVehicles();

}
