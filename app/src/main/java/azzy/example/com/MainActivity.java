package azzy.example.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String URL_FEED = "http://findbest.co.in/admin/Webservice_Controller/get_all_main_product_category";
    private ListView listView;
    private ArrayList<FeedItem> feedItems;
    private FeedListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        feedItems = new ArrayList<FeedItem>();

        listAdapter = new FeedListAdapter(this, feedItems);
        listView.setAdapter(listAdapter);

        webRequest();
    }

    private void webRequest(){

        JsonArrayRequest req = new JsonArrayRequest(URL_FEED,
                new Response.Listener<JSONArray>() {

        @Override
        public void onResponse(JSONArray response) {
            VolleyLog.d("asd", "Response: " + response.toString());
            if (response != null) {
                /*Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_SHORT).show();*/
                parseJsonFeed(response);
            }
        }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {
            VolleyLog.d("qwe", "Error: " + error.getMessage());
        }
    });

    // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(req);
    }

    private void parseJsonFeed(JSONArray feedArray) {
        try {

            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                FeedItem item = new FeedItem();
                item.setId(feedObj.getInt("cat_id"));
                item.setName(feedObj.getString("cat_name"));
                item.setImge(feedObj.getString("cat_img"));
                item.setMain_cat_id(feedObj.getString("main_cat"));
                item.setCat_type(feedObj.getString("cat_type"));

                feedItems.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
