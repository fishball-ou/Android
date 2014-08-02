package oukq.example.TestApp;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static int[] MAIN_FRAME_COUNT = new int[3];
    private static String[] MAIN_FRAME_ITEM = new String []{"歌手","歌曲","唱片"};
    private static int[] MAIN_FRAME_ICON = new int[]{R.drawable.icon_artist,R.drawable.icon_music,R.drawable.icon_album};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView g =(GridView)findViewById(R.id.item1);
        g.setAdapter(new GridViewItemAdapter());


    }
    class GridViewItemAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return MAIN_FRAME_COUNT.length;
        }

        @Override
        public Object getItem(int i) {
            return MAIN_FRAME_ITEM[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            if (view == null){
                view = getLayoutInflater().inflate(R.layout.grid_item,null);
                view.setTag(view);
            }
            TextView tvMenuItem  = (TextView)view;
            BitmapDrawable bd = (BitmapDrawable)getResources().getDrawable(MAIN_FRAME_ICON[position]);
            bd.setBounds(0,0,bd.getIntrinsicWidth(),bd.getIntrinsicHeight());
            tvMenuItem.setCompoundDrawables(null,bd,null,null);
            tvMenuItem.setText(MAIN_FRAME_ITEM[position]+"("+MAIN_FRAME_COUNT[position]+")");
            tvMenuItem.setGravity(Gravity.CENTER);
            return tvMenuItem;
        }
    }
}
