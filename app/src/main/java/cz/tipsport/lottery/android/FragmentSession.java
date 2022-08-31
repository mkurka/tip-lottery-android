package cz.tipsport.lottery.android;

import android.os.Bundle;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSession#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSession extends Fragment {

    private List<SessionItemModel> sessionItems = new ArrayList<>();


    public FragmentSession() {
        // Required empty public constructor

        sessionItems.add(new SessionItemModel(1, "Prodej losu Veselá zvířátka 8", "1234-56789-001", BigDecimal.valueOf(50), true));
        sessionItems.add(new SessionItemModel(1, "Prodej losu Zlatá Korunka", "1235-56789-001", BigDecimal.valueOf(100), false));
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentSession.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSession newInstance() {
        FragmentSession fragment = new FragmentSession();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_session, container, false);
        ListView itemsView = (ListView) rootView.findViewById(R.id.listItems);
        SessionItemListAdapter adapter = new SessionItemListAdapter(getContext(), R.layout.session_items_view_layout, sessionItems);
        itemsView.setAdapter(adapter);
        return rootView;
    }
}