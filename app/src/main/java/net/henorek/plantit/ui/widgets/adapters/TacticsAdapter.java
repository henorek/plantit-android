package net.henorek.plantit.ui.widgets.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;
import com.squareup.picasso.Picasso;

import net.henorek.plantit.R;
import net.henorek.plantit.data.models.TacticsEntity;

import java.util.List;

import javax.inject.Inject;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jarek Jankowski on 2016-01-22.
 * jarosz1994@gmail.com
 */
public class TacticsAdapter extends SupportAnnotatedAdapter implements TacticsAdapterBinder {

    @ViewType(
            layout = R.layout.tactics_list_element,
            views = {
                    @ViewField(id = R.id.avatar, type = ImageView.class, name = "avatar"),
                    @ViewField(id = R.id.name, type = TextView.class, name = "name"),
                    @ViewField(id = R.id.description, type = TextView.class, name = "description")
            })

    public final int tactic = 0;

    @Getter
    @Setter
    List<TacticsEntity> tactics;

    Picasso picasso;

    @Inject
    public TacticsAdapter(Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
    }

    @Override
    public int getItemCount() {
        return tactics == null ? 0 : tactics.size();
    }

    @Override
    public void bindViewHolder(TacticsAdapterHolders.TacticViewHolder vh, int position) {
        TacticsEntity tactic = tactics.get(position);

        vh.name.setText(tactic.getTitle());
        vh.description.setText(tactic.getAuthor());

        picasso.load(tactic.getIconUrl())
                .placeholder(R.color.plantit_dark_gray)
                .error(R.color.plantit_black)
                .into(vh.avatar);
    }
}

