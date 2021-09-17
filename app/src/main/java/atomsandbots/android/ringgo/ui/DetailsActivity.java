package atomsandbots.android.ringgo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import atomsandbots.android.ringgo.R;
import atomsandbots.android.ringgo.databinding.ActivityDetailsBinding;
import atomsandbots.android.ringgo.model.Vehicles;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // View Binding in use
        atomsandbots.android.ringgo.databinding.ActivityDetailsBinding binding =
                ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //receive data from bundle via intent
        Vehicles vehicle = (Vehicles) getIntent().getExtras().getParcelable("Bundle");

        //set data to views
        binding.vehicleID.setText(String.valueOf(vehicle.getVehicleId()));
        binding.vrn.setText(vehicle.getVrn());
        binding.country.setText(vehicle.getCountry());
        binding.color.setText(vehicle.getColor());
        binding.type.setText(vehicle.getType());
        binding.deFault.setText(String.valueOf(vehicle.get_default()));

    }
}