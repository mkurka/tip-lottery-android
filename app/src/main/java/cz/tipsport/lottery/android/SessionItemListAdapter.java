package cz.tipsport.lottery.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.tipsport.lottery.android.databinding.SessionItemsViewLayoutBinding;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SessionItemListAdapter extends ArrayAdapter<SessionItemModel> {

    public  SessionItemListAdapter(@NonNull @NotNull Context context, int resource, @NonNull @NotNull List<SessionItemModel> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        convertView = inflater.inflate(R.layout.session_items_view_layout, parent, false);
////        TextView txtIssueName = (TextView) convertView.findViewById(R.id.textViewIssueName);
//        TextView txtLogisticNumber = (TextView) convertView.findViewById(R.id.textViewLogisticNumber);
//        TextView txtTotalPrice = (TextView) convertView.findViewById(R.id.textViewTotalPrice);
//
//        SessionItemsViewLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.session_items_view_layout, parent, false);
//        binding.setSessionItem(item);
//
////        txtIssueName.setText(item.getDescription());
//        txtLogisticNumber.setText(item.getAdditionalDescription());
//        txtTotalPrice.setText(item.getTotalPrice().toPlainString() + " Kč");
        SessionItemsViewLayoutBinding binding;
        if(convertView == null) {
            binding = SessionItemsViewLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            convertView = binding.getRoot();
        }
        else {
            binding = (SessionItemsViewLayoutBinding) convertView.getTag();
        }

        binding.setSessionItem(this.getItem(position));
        convertView.setTag(binding);
        return convertView;

//        return convertView;
    }
}
