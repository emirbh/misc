package iso20022.auth030.hkma.dtcc.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityDairy2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityForestry2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityGrain3;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityLiveStock2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOilSeed2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOliveOil3;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityOther2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommodityPotato2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommoditySeafood2;
import iso20022.auth030.hkma.dtcc.AgriculturalCommoditySoft2;
import iso20022.auth030.hkma.dtcc.AssetClassCommodityAgricultural6Choice;
import iso20022.auth030.hkma.dtcc.AssetClassProductType1Code;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityAgricultural6ChoiceDeepPathUtil {
    public AssetClassProductType1Code chooseBasePdct(AssetClassCommodityAgricultural6Choice assetClassCommodityAgricultural6Choice) {
        final MapperS<AgriculturalCommodityOilSeed2> grnOilSeed = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityOilSeed2>map("getGrnOilSeed", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getGrnOilSeed());
        if (exists(grnOilSeed).getOrDefault(false)) {
            return grnOilSeed.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOilSeed2 -> agriculturalCommodityOilSeed2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommoditySoft2> soft = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommoditySoft2>map("getSoft", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getSoft());
        if (exists(soft).getOrDefault(false)) {
            return soft.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommoditySoft2 -> agriculturalCommoditySoft2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityPotato2> ptt = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityPotato2>map("getPtt", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getPtt());
        if (exists(ptt).getOrDefault(false)) {
            return ptt.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityPotato2 -> agriculturalCommodityPotato2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityOliveOil3> olvOil = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityOliveOil3>map("getOlvOil", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getOlvOil());
        if (exists(olvOil).getOrDefault(false)) {
            return olvOil.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOliveOil3 -> agriculturalCommodityOliveOil3.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityDairy2> dairy = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityDairy2>map("getDairy", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getDairy());
        if (exists(dairy).getOrDefault(false)) {
            return dairy.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityDairy2 -> agriculturalCommodityDairy2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityForestry2> frstry = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityForestry2>map("getFrstry", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getFrstry());
        if (exists(frstry).getOrDefault(false)) {
            return frstry.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityForestry2 -> agriculturalCommodityForestry2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommoditySeafood2> sfd = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommoditySeafood2>map("getSfd", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getSfd());
        if (exists(sfd).getOrDefault(false)) {
            return sfd.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommoditySeafood2 -> agriculturalCommoditySeafood2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityLiveStock2> liveStock = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityLiveStock2>map("getLiveStock", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getLiveStock());
        if (exists(liveStock).getOrDefault(false)) {
            return liveStock.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityLiveStock2 -> agriculturalCommodityLiveStock2.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityGrain3> grn = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityGrain3>map("getGrn", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getGrn());
        if (exists(grn).getOrDefault(false)) {
            return grn.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityGrain3 -> agriculturalCommodityGrain3.getBasePdct()).get();
        }
        final MapperS<AgriculturalCommodityOther2> othr = MapperS.of(assetClassCommodityAgricultural6Choice).<AgriculturalCommodityOther2>map("getOthr", _assetClassCommodityAgricultural6Choice -> _assetClassCommodityAgricultural6Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType1Code>map("getBasePdct", agriculturalCommodityOther2 -> agriculturalCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
