package atomsandbots.android.ringgo.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static final String BASE_URL = "http://private-6d86b9-vehicles5.apiary-mock.com";
    private static Retrofit retrofit = null;


    // Creating builder and passing our base url
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // convert Json data with GSON converter factory.
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
