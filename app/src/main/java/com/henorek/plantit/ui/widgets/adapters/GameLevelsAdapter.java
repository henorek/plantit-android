package com.henorek.plantit.ui.widgets.adapters;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.hannesdorfmann.annotatedadapter.annotation.ViewField;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;
import com.henorek.plantit.R;
import com.henorek.plantit.data.net.GameLevelApi;
import com.squareup.picasso.Picasso;
import java.util.List;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;

public class GameLevelsAdapter extends SupportAnnotatedAdapter implements GameLevelsAdapterBinder {

  @ViewType(
      layout = R.layout.game_level_element,
      views = {
          @ViewField(id = R.id.icon, type = ImageView.class, name = "icon"),
          @ViewField(id = R.id.background, type = ImageView.class, name = "background"),
          @ViewField(id = R.id.name, type = TextView.class, name = "name")
      })

  public final int gameLevel = 0;

  @Getter @Setter List<GameLevelApi> gameLevelApis;

  Picasso picasso;

  @Inject public GameLevelsAdapter(Context context, Picasso picasso) {
    super(context);
    this.picasso = picasso;
  }

  @Override public int getItemCount() {
    return gameLevelApis == null ? 0 : gameLevelApis.size();
  }

  @Override
  public void bindViewHolder(GameLevelsAdapterHolders.GameLevelViewHolder vh, int position) {
    GameLevelApi gameLevelApi = gameLevelApis.get(position);

    vh.name.setText(gameLevelApi.getName());

    picasso.load(gameLevelApi.getIconUrl())
        .placeholder(R.color.plantit_dark_gray)
        .error(R.color.plantit_black)
        .into(vh.icon);

    picasso.load(gameLevelApi.getBackgroundUrl())
        .placeholder(R.color.plantit_dark_gray)
        .error(R.color.plantit_black)
        .into(vh.background);
  }
}
