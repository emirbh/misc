package iso20022.auth030.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.tr.AssetClassCommodityMetal2Choice;
import iso20022.auth030.hkma.tr.AssetClassProductType7Code;
import iso20022.auth030.hkma.tr.MetalCommodityNonPrecious2;
import iso20022.auth030.hkma.tr.MetalCommodityPrecious2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityMetal2ChoiceDeepPathUtil {
    public AssetClassProductType7Code chooseBasePdct(AssetClassCommodityMetal2Choice assetClassCommodityMetal2Choice) {
        final MapperS<MetalCommodityNonPrecious2> nonPrcs = MapperS.of(assetClassCommodityMetal2Choice).<MetalCommodityNonPrecious2>map("getNonPrcs", _assetClassCommodityMetal2Choice -> _assetClassCommodityMetal2Choice.getNonPrcs());
        if (exists(nonPrcs).getOrDefault(false)) {
            return nonPrcs.<AssetClassProductType7Code>map("getBasePdct", metalCommodityNonPrecious2 -> metalCommodityNonPrecious2.getBasePdct()).get();
        }
        final MapperS<MetalCommodityPrecious2> prcs = MapperS.of(assetClassCommodityMetal2Choice).<MetalCommodityPrecious2>map("getPrcs", _assetClassCommodityMetal2Choice -> _assetClassCommodityMetal2Choice.getPrcs());
        if (exists(prcs).getOrDefault(false)) {
            return prcs.<AssetClassProductType7Code>map("getBasePdct", metalCommodityPrecious2 -> metalCommodityPrecious2.getBasePdct()).get();
        }
        return null;
    }

}
