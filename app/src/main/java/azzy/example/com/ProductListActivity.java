package azzy.example.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProductListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        String cat_id = getIntent().getStringExtra("cat_id");

    }
}
