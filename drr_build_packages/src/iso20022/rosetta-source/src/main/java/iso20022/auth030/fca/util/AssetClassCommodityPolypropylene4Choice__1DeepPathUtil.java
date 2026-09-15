package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityPolypropylene4Choice__1;
import iso20022.auth030.fca.AssetClassProductType9Code;
import iso20022.auth030.fca.PolypropyleneCommodityOther2__1;
import iso20022.auth030.fca.PolypropyleneCommodityPlastic2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityPolypropylene4Choice__1DeepPathUtil {
    public AssetClassProductType9Code chooseBasePdct(AssetClassCommodityPolypropylene4Choice__1 assetClassCommodityPolypropylene4Choice__1) {
        final MapperS<PolypropyleneCommodityPlastic2__1> plstc = MapperS.of(assetClassCommodityPolypropylene4Choice__1).<PolypropyleneCommodityPlastic2__1>map("getPlstc", _assetClassCommodityPolypropylene4Choice__1 -> _assetClassCommodityPolypropylene4Choice__1.getPlstc());
        if (exists(plstc).getOrDefault(false)) {
            return plstc.<AssetClassProductType9Code>map("getBasePdct", polypropyleneCommodityPlastic2__1 -> polypropyleneCommodityPlastic2__1.getBasePdct()).get();
        }
        final MapperS<PolypropyleneCommodityOther2__1> othr = MapperS.of(assetClassCommodityPolypropylene4Choice__1).<PolypropyleneCommodityOther2__1>map("getOthr", _assetClassCommodityPolypropylene4Choice__1 -> _assetClassCommodityPolypropylene4Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType9Code>map("getBasePdct", polypropyleneCommodityOther2__1 -> polypropyleneCommodityOther2__1.getBasePdct()).get();
        }
        return null;
    }

}
