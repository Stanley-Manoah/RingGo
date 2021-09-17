package atomsandbots.android.ringgo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import atomsandbots.android.ringgo.ui.DetailsActivity;
import atomsandbots.android.ringgo.R;
import atomsandbots.android.ringgo.model.Vehicles;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {

    //initialize data set
    Context context;
    List<Vehicles> vehiclesList;

    public VehicleAdapter(Context context, List<Vehicles> vehiclesList) {
        this.context = context;
        this.vehiclesList = vehiclesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // define layout of the list item (of which vehicle_item.xml)
        View view = LayoutInflater.from(context).inflate(R.layout.vehicle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String ID = String.valueOf(vehiclesList.get(position).getVrn());
        holder.vrn.setText(ID);

        //load holder with data in a bundle for detail activity (onclick) and open detail activity
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("Bundle",vehiclesList.get(position));
            context.startActivity(intent);
        });
    }

    // Return size of arraylist
    @Override
    public int getItemCount() {
        return vehiclesList.size();
    }

    // new views in View Holder (invoked by the layout manager)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView vrn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vrn= itemView.findViewById(R.id.vrn);
        }
    }
}
