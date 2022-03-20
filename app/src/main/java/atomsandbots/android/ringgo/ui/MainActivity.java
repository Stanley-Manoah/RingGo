package atomsandbots.android.ringgo.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import atomsandbots.android.ringgo.R;
import atomsandbots.android.ringgo.adapter.VehicleAdapter;
import atomsandbots.android.ringgo.data.Api;
import atomsandbots.android.ringgo.data.VehiclesApi;
import atomsandbots.android.ringgo.databinding.ActivityMainBinding;
import atomsandbots.android.ringgo.model.VehicleResponse;
import atomsandbots.android.ringgo.model.Vehicles;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // creating variables
    List<Vehicles> vehiclesList;
    VehicleAdapter adapter;
    //View Binding in use
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Configure Recyclerview
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.mainRecyclerView.setHasFixedSize(true);
        loadData();
    }

    private void loadData() {

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        VehiclesApi apiService =
                Api.getClient().create(VehiclesApi.class);

        Call<VehicleResponse> call = apiService.getVehicles();
        call.enqueue(new Callback<VehicleResponse>() {
            @Override
            public void onResponse(Call<VehicleResponse>call, Response<VehicleResponse> response) {

                //if successful, get response and set it to adapter
                assert response.body() != null;
                vehiclesList = response.body().getVehicles();
                adapter = new VehicleAdapter(MainActivity.this,vehiclesList);
                binding.mainRecyclerView.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<VehicleResponse>call, Throwable t) {
                // log error message to string on failure
                Log.e("failed to load data", t.toString());
                progressDialog.dismiss();
            }
        });

    }
}