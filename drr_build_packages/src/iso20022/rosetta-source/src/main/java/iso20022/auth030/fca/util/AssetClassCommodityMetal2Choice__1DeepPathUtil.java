package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityMetal2Choice__1;
import iso20022.auth030.fca.AssetClassProductType7Code;
import iso20022.auth030.fca.MetalCommodityNonPrecious2__1;
import iso20022.auth030.fca.MetalCommodityPrecious2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityMetal2Choice__1DeepPathUtil {
    public AssetClassProductType7Code chooseBasePdct(AssetClassCommodityMetal2Choice__1 assetClassCommodityMetal2Choice__1) {
        final MapperS<MetalCommodityNonPrecious2__1> nonPrcs = MapperS.of(assetClassCommodityMetal2Choice__1).<MetalCommodityNonPrecious2__1>map("getNonPrcs", _assetClassCommodityMetal2Choice__1 -> _assetClassCommodityMetal2Choice__1.getNonPrcs());
        if (exists(nonPrcs).getOrDefault(false)) {
            return nonPrcs.<AssetClassProductType7Code>map("getBasePdct", metalCommodityNonPrecious2__1 -> metalCommodityNonPrecious2__1.getBasePdct()).get();
        }
        final MapperS<MetalCommodityPrecious2__1> prcs = MapperS.of(assetClassCommodityMetal2Choice__1).<MetalCommodityPrecious2__1>map("getPrcs", _assetClassCommodityMetal2Choice__1 -> _assetClassCommodityMetal2Choice__1.getPrcs());
        if (exists(prcs).getOrDefault(false)) {
            return prcs.<AssetClassProductType7Code>map("getBasePdct", metalCommodityPrecious2__1 -> metalCommodityPrecious2__1.getBasePdct()).get();
        }
        return null;
    }

}
