package appwork.almayce.balloonpuzzle.model.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import appwork.almayce.balloonpuzzle.R;

/**
 * Created by almayce on 22.06.17.
 */

public class Markers {

    private Map<String, List<Integer>> map;
    private List<Integer> markersId;

    public Markers() {
        map = new HashMap<>();
        markersId = new ArrayList<>();
        init();
    }

    private void init() {
        markersId.add(R.id.v1);
        markersId.add(R.id.v2);
        markersId.add(R.id.v3);
        markersId.add(R.id.v4);
        markersId.add(R.id.v5);
        markersId.add(R.id.v6);
        markersId.add(R.id.v7);
        markersId.add(R.id.v8);
        markersId.add(R.id.v9);
        markersId.add(R.id.v10);
        markersId.add(R.id.v11);
        markersId.add(R.id.v12);
        markersId.add(R.id.v13);
        markersId.add(R.id.v14);
        markersId.add(R.id.v15);
        markersId.add(R.id.v16);
        markersId.add(R.id.v17);
        markersId.add(R.id.v18);
        markersId.add(R.id.v19);
        markersId.add(R.id.v20);
        markersId.add(R.id.v21);
        markersId.add(R.id.v22);
        markersId.add(R.id.v23);


        map.put("А", createArray(13));
        map.put("Ф", createArray(20));
        map.put("Д", createArray(17));
        map.put("З", createArray(12));
        map.put("С", createArray(13));
        map.put("Е", createArray(15));
        map.put("Ж", createArray(18));
        map.put("Ь", createArray(13));
        map.put("Ъ", createArray(14));
        map.put("У", createArray(10));
        map.put("В", createArray(18));
        map.put("Т", createArray(10));
        map.put("Х", createArray(12));
        map.put("Л", createArray(11));
        map.put("Я", createArray(15));
        map.put("Ё", createArray(17));
        map.put("Щ", createArray(23));
        map.put("М", createArray(23));
        map.put("О", createArray(16));
        map.put("Н", createArray(14));
        map.put("Ы", createArray(19));
        map.put("Р", createArray(13));
        map.put("Э", createArray(15));
        map.put("Ч", createArray(12));
        map.put("Ш", createArray(22));
        map.put("П", createArray(14));
        map.put("Б", createArray(16));
        map.put("Г", createArray(9));
        map.put("К", createArray(12));
        map.put("И", createArray(16));
        map.put("Й", createArray(19));
        map.put("Ю", createArray(23));
        map.put("Ц", createArray(16));
    }

private List<Integer> createArray(int count) {
    List<Integer> target = new ArrayList<>();
    for (int o = 0; o < count; o++) {
        target.add(markersId.get(o));
    }
    return target;
}

    public List<Integer> getMarkers(String name) {
        return map.get(name);
    }
}
