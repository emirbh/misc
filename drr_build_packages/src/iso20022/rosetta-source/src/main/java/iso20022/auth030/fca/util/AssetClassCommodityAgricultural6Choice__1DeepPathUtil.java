package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AgriculturalCommodityDairy2__1;
import iso20022.auth030.fca.AgriculturalCommodityForestry2__1;
import iso20022.auth030.fca.AgriculturalCommodityGrain3__1;
import iso20022.auth030.fca.AgriculturalCommodityLiveStock2__1;
import iso20022.auth030.fca.AgriculturalCommodityOilSeed2__1;
import iso20022.auth030.fca.AgriculturalCommodityOliveOil3__1;
import iso20022.auth030.fca.AgriculturalCommodityOther2__1;
import iso20022.auth030.fca.AgriculturalCommodityPotato2__1;
import iso20022.auth030.fca.AgriculturalCommoditySeafood2__1;
import iso20022.auth030.fca.AgriculturalCommoditySoft2__1;
import iso20022.auth030.fca.AssetClassCommodityAgricultural6Choice__1;
import iso20022.auth030.fca.AssetClassProductType1Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityAgricultural6Choice__1DeepPathUtil {
    public AssetClassProductType1Code chooseBasePdct(AssetClassCommodityAgricultural6Choice__1 assetClassCommodityAgricultural6Choice__1) {
        final MapperS<AgriculturalCommodityOilSeed2__1> grnOilSeed = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityOilSeed2__1>map("getGrnOilSeed", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getGrnOilSeed());
        if (exists(grnOilSeed).getOrDefault(false)) {
            return grnOilSeed.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOilSeed2__1 -> agriculturalCommodityOilSeed2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommoditySoft2__1> soft = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommoditySoft2__1>map("getSoft", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getSoft());
        if (exists(soft).getOrDefault(false)) {
            return soft.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommoditySoft2__1 -> agriculturalCommoditySoft2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityPotato2__1> ptt = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityPotato2__1>map("getPtt", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getPtt());
        if (exists(ptt).getOrDefault(false)) {
            return ptt.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityPotato2__1 -> agriculturalCommodityPotato2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityOliveOil3__1> olvOil = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityOliveOil3__1>map("getOlvOil", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getOlvOil());
        if (exists(olvOil).getOrDefault(false)) {
            return olvOil.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOliveOil3__1 -> agriculturalCommodityOliveOil3__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityDairy2__1> dairy = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityDairy2__1>map("getDairy", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getDairy());
        if (exists(dairy).getOrDefault(false)) {
            return dairy.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityDairy2__1 -> agriculturalCommodityDairy2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityForestry2__1> frstry = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityForestry2__1>map("getFrstry", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getFrstry());
        if (exists(frstry).getOrDefault(false)) {
            return frstry.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityForestry2__1 -> agriculturalCommodityForestry2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommoditySeafood2__1> sfd = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommoditySeafood2__1>map("getSfd", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getSfd());
        if (exists(sfd).getOrDefault(false)) {
            return sfd.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommoditySeafood2__1 -> agriculturalCommoditySeafood2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityLiveStock2__1> liveStock = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityLiveStock2__1>map("getLiveStock", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getLiveStock());
        if (exists(liveStock).getOrDefault(false)) {
            return liveStock.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityLiveStock2__1 -> agriculturalCommodityLiveStock2__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityGrain3__1> grn = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityGrain3__1>map("getGrn", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getGrn());
        if (exists(grn).getOrDefault(false)) {
            return grn.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityGrain3__1 -> agriculturalCommodityGrain3__1.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityOther2__1> othr = MapperS.of(assetClassCommodityAgricultural6Choice__1).<AgriculturalCommodityOther2__1>map("getOthr", _assetClassCommodityAgricultural6Choice__1 -> _assetClassCommodityAgricultural6Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOther2__1 -> agriculturalCommodityOther2__1.getBasePdct()).get();
        }
        return null;
    }

}
