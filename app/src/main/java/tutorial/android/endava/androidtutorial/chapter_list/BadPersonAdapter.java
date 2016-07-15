package tutorial.android.endava.androidtutorial.chapter_list;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tutorial.android.endava.androidtutorial.R;

/**
 * Created by radpopescu on 7/15/2016.
 */
public class BadPersonAdapter extends ArrayAdapter<Person> {
    private LayoutInflater mInflater;

    public BadPersonAdapter(Context context, ArrayList<Person> list) {
        super(context, R.layout.item_list_person, list);
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_list_person, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView nameView = (TextView) view.findViewById(R.id.name_view);
        TextView companyView = (TextView) view.findViewById(R.id.company_view);
        TextView positionView = (TextView) view.findViewById(R.id.position_view);
        Person person = getItem(position);
        nameView.setText(Html.fromHtml(person.getName()));
        companyView.setText(Html.fromHtml(person.getCompanyName()));
        positionView.setText(Html.fromHtml(person.getPosition()));
        return view;

    }
}
