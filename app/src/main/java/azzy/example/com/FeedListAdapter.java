package azzy.example.com;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;
import java.util.Objects;

/**
 * Created by Siddhant on 31-05-2018.
 */

public class FeedListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<FeedItem> feedItems;

    public FeedListAdapter(Activity activity, List<FeedItem> feedItems) {
        this.activity = activity;
        this.feedItems = feedItems;
    }

    @Override
    public int getCount() {
        return feedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return feedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.feed_item, null);


        TextView name = (TextView) convertView.findViewById(R.id.cat_name);

        ImageView imageView = (ImageView) convertView
                .findViewById(R.id.cat_img);


        FeedItem item = feedItems.get(position);
        final String cat_type =item.getCat_type();
        name.setText(item.getName()+" "+cat_type);
        String catId = String.valueOf(item.getId());
        convertView.setTag(catId);

        Glide.with(parent.getContext()).load(item.getImge())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);




            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String id = (String) v.getTag();
                    if(Objects.equals(cat_type, "m") || Objects.equals(cat_type, "s")) {
                        Intent intent = new Intent(parent.getContext(), SubCatActivity.class);
                        intent.putExtra("cat_id", id);
                        parent.getContext().startActivity(intent);
                    }else{
                        Intent intent = new Intent(parent.getContext(), ProductListActivity.class);
                        intent.putExtra("cat_id", id);
                        parent.getContext().startActivity(intent);
                    }
                }
            });

        return convertView;
    }

}
