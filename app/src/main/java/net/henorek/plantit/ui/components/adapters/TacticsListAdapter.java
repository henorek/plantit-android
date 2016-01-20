//package net.henorek.plantit.ui.components.adapters;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import net.henorek.plantit.R;
//import net.henorek.plantit.data.models.TacticsEntity;
//
//import java.util.ArrayList;
//
///**
// * Created by Jarek Jankowski on 2016-01-20.
// * jarosz1994@gmail.com
// */
//public class TacticsListAdapter extends ArrayAdapter<TacticsEntity> {
//
//    public TacticsListAdapter(Context context, ArrayList<TacticsEntity> data) {
//        super(context, R.layout.fragment_promoted_collections_tile, data);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View collectionView = convertView;
//        if (collectionView == null) {
//            LayoutInflater vi = LayoutInflater.from(getContext());
//            collectionView = vi.inflate(R.layout.fragment_promoted_collections_tile, parent, false);
//        }
//
//        TacticsEntity singleItemData = getItem(position);
//        ImageLoaderView backgroundImage = (ImageLoaderView) collectionView.findViewById(R.id.fpc_tile_image);
//        backgroundImage.loadBitmap(singleItemData.getImageUrl());
//        TextView name = (TextView) collectionView.findViewById(R.id.fpc_tile_name);
//        name.setText(singleItemData.getTitle() + " (" + String.valueOf(singleItemData.getProductsCount()) + ")");
//
//        return collectionView;
//    }
//}
//
//}
