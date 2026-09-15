package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityFertilizer4Choice__1;
import iso20022.auth030.fca.AssetClassProductType5Code;
import iso20022.auth030.fca.FertilizerCommodityAmmonia2__1;
import iso20022.auth030.fca.FertilizerCommodityDiammoniumPhosphate2__1;
import iso20022.auth030.fca.FertilizerCommodityOther2__1;
import iso20022.auth030.fca.FertilizerCommodityPotash2__1;
import iso20022.auth030.fca.FertilizerCommoditySulphur2__1;
import iso20022.auth030.fca.FertilizerCommodityUrea2__1;
import iso20022.auth030.fca.FertilizerCommodityUreaAndAmmoniumNitrate2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityFertilizer4Choice__1DeepPathUtil {
    public AssetClassProductType5Code chooseBasePdct(AssetClassCommodityFertilizer4Choice__1 assetClassCommodityFertilizer4Choice__1) {
        final MapperS<FertilizerCommodityAmmonia2__1> ammn = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityAmmonia2__1>map("getAmmn", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getAmmn());
        if (exists(ammn).getOrDefault(false)) {
            return ammn.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityAmmonia2__1 -> fertilizerCommodityAmmonia2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityDiammoniumPhosphate2__1> dmmnmPhspht = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityDiammoniumPhosphate2__1>map("getDmmnmPhspht", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getDmmnmPhspht());
        if (exists(dmmnmPhspht).getOrDefault(false)) {
            return dmmnmPhspht.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityDiammoniumPhosphate2__1 -> fertilizerCommodityDiammoniumPhosphate2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityPotash2__1> ptsh = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityPotash2__1>map("getPtsh", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getPtsh());
        if (exists(ptsh).getOrDefault(false)) {
            return ptsh.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityPotash2__1 -> fertilizerCommodityPotash2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommoditySulphur2__1> slphr = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommoditySulphur2__1>map("getSlphr", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getSlphr());
        if (exists(slphr).getOrDefault(false)) {
            return slphr.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommoditySulphur2__1 -> fertilizerCommoditySulphur2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityUrea2__1> urea = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityUrea2__1>map("getUrea", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getUrea());
        if (exists(urea).getOrDefault(false)) {
            return urea.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityUrea2__1 -> fertilizerCommodityUrea2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityUreaAndAmmoniumNitrate2__1> ureaAndAmmnmNtrt = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityUreaAndAmmoniumNitrate2__1>map("getUreaAndAmmnmNtrt", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getUreaAndAmmnmNtrt());
        if (exists(ureaAndAmmnmNtrt).getOrDefault(false)) {
            return ureaAndAmmnmNtrt.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityUreaAndAmmoniumNitrate2__1 -> fertilizerCommodityUreaAndAmmoniumNitrate2__1.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityOther2__1> othr = MapperS.of(assetClassCommodityFertilizer4Choice__1).<FertilizerCommodityOther2__1>map("getOthr", _assetClassCommodityFertilizer4Choice__1 -> _assetClassCommodityFertilizer4Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityOther2__1 -> fertilizerCommodityOther2__1.getBasePdct()).get();
        }
        return null;
    }

}
