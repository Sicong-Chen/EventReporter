package com.laioffer.eventreporter;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
// import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {
    ListView listView;
    OnItemSelectListener mCallback;


    public void onItemSelected(int position){
        for (int i = 0; i < listView.getChildCount(); i++){
            if (position == i) {
                listView.getChildAt(i).setBackgroundColor(Color.BLUE);
            } else {
                listView.getChildAt(i).setBackgroundColor(Color.parseColor("#EEEEEE"));
            }
        }
    }


    // Container Activity must implement this interface
    public interface OnItemSelectListener {
        public void onItemSelected(int position);


    }





    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_event, container, false);
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        ListView listView = (ListView) view.findViewById(R.id.event_list);
        // listView.setAdapter(new EventAdapter(getActivity()));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getEventNames());

        // Assign adapter to ListView.
        listView.setAdapter(adapter);


        return view;
    }

    private String[] getEventNames() {
        String[] names = {
                "Event1", "Event2", "Event3",
                "Event4", "Event5", "Event6",
                "Event7", "Event8", "Event9",
                "Event10", "Event11", "Event12"};
        return names;

    }


}
