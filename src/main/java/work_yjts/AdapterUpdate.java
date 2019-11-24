package work_yjts;

import java.util.*;

public class AdapterUpdate {

    static final String is_merge = "isMerge";
    static final String is_update = "isUpdate";


    public static void main(String[] args) {

        Iterator<String> sources = getStringIterator();

        String assetMap = sources.next();
        List<String> assets = new ArrayList<>();
        Map<String, Boolean> cache = new HashMap<>();



        while (sources.hasNext()){
            if(isAlreadyExists()){
                assets.add(assetMap);
                cache.put("entityNo", true);
            }else {
                if(assetMap == is_merge && !isExistsInDB()){
                    assets.add(assetMap);
                }

                if(assetMap == is_update){

                }

                System.out.println("数据库中以存在该记录");
            }

        }

        if("assetDefine" == "isMerge"){
            assets = merge(assets);
        }

        for (String asset : assets) {
            generateAssetRelation(asset);
        }


    }

    static void generateAssetRelation(String asset){}

    static List<String> merge(List<String> assets){
        return null;
    }

    private static Iterator<String> getStringIterator() {
        return new Iterator<String>() {
                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public String next() {
                    return null;
                }
            };
    }

    static boolean isExistsInDB(){
        return true;
    }

    static boolean isAlreadyExists(){
        return true;
    }

}
