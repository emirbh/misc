package iso20022.auth030.hkma.dtcc.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityPolypropylene4Choice;
import iso20022.auth030.hkma.dtcc.AssetClassProductType9Code;
import iso20022.auth030.hkma.dtcc.PolypropyleneCommodityOther2;
import iso20022.auth030.hkma.dtcc.PolypropyleneCommodityPlastic2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityPolypropylene4ChoiceDeepPathUtil {
    public AssetClassProductType9Code chooseBasePdct(AssetClassCommodityPolypropylene4Choice assetClassCommodityPolypropylene4Choice) {
        final MapperS<PolypropyleneCommodityPlastic2> plstc = MapperS.of(assetClassCommodityPolypropylene4Choice).<PolypropyleneCommodityPlastic2>map("getPlstc", _assetClassCommodityPolypropylene4Choice -> _assetClassCommodityPolypropylene4Choice.getPlstc());
        if (exists(plstc).getOrDefault(false)) {
            return plstc.<AssetClassProductType9Code>map("getBasePdct", polypropyleneCommodityPlastic2 -> polypropyleneCommodityPlastic2.getBasePdct()).get();
        }
        final MapperS<PolypropyleneCommodityOther2> othr = MapperS.of(assetClassCommodityPolypropylene4Choice).<PolypropyleneCommodityOther2>map("getOthr", _assetClassCommodityPolypropylene4Choice -> _assetClassCommodityPolypropylene4Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType9Code>map("getBasePdct", polypropyleneCommodityOther2 -> polypropyleneCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
