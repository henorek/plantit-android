package com.henorek.plantit.data.net.helper;

import com.henorek.plantit.data.disk.entity.Tactic;
import com.henorek.plantit.data.net.TacticsEntityApi;
import com.mobandme.android.transformer.Transformer;
import java.util.ArrayList;

public class TransformHelper {

  public static <T extends Object> ArrayList<?> asArrayList(T[] fromEntitiesArray) {
    //        Class<T> expectedReturnType
    Transformer transformer = new Transformer.Builder().build(TacticsEntityApi.class);
    ArrayList arrayList = new ArrayList();
    for (T fromEntity : fromEntitiesArray) {
      Object transformed = transformer.transform(fromEntity);
      arrayList.add(transformed);
    }
    return arrayList;
  }

  //    public static ChapterForSku asArrayList2(ApiChapter[] apiChapters) {
  //        Transformer transformer = new Transformer.Builder().build(ApiChapter.class);
  ////        ArrayList arrayList = new ArrayList<>();
  //        ChapterForSku transformed = transformer.transform(apiChapters[0], ChapterForSku.class);
  ////        for (ApiChapter fromEntity : apiChapters) {
  ////        ChapterForSku transformed = transformer.transform(fromEntity, ChapterForSku.class);
  ////            arrayList.add(transformed);
  ////        }
  //        return transformed;
  //    }

  public static ArrayList<Tactic> apiArrayToModelArrayList(TacticsEntityApi[] apiChapters) {
    // FIXME zamiast tego docelowo implementacja oparta na Android Transformer jeśli uda się znaleźć bug z ClassNotFoundException (pewnie AT gryzie się z innymi annotation processorami)
    ArrayList arrayList = new ArrayList<Tactic>();
    for (TacticsEntityApi apiChapter : apiChapters) {
      Tactic chapter = new Tactic();
      //            chapter.setSample(apiChapter.isSample());
      //            chapter.setChapterTitle(apiChapter.getChapterTitle());
      arrayList.add(chapter);
    }
    return arrayList;
  }
}
