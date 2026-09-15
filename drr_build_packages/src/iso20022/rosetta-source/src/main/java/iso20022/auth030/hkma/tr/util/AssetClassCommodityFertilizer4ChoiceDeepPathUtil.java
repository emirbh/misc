package iso20022.auth030.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.tr.AssetClassCommodityFertilizer4Choice;
import iso20022.auth030.hkma.tr.AssetClassProductType5Code;
import iso20022.auth030.hkma.tr.FertilizerCommodityAmmonia2;
import iso20022.auth030.hkma.tr.FertilizerCommodityDiammoniumPhosphate2;
import iso20022.auth030.hkma.tr.FertilizerCommodityOther2;
import iso20022.auth030.hkma.tr.FertilizerCommodityPotash2;
import iso20022.auth030.hkma.tr.FertilizerCommoditySulphur2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUrea2;
import iso20022.auth030.hkma.tr.FertilizerCommodityUreaAndAmmoniumNitrate2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityFertilizer4ChoiceDeepPathUtil {
    public AssetClassProductType5Code chooseBasePdct(AssetClassCommodityFertilizer4Choice assetClassCommodityFertilizer4Choice) {
        final MapperS<FertilizerCommodityAmmonia2> ammn = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityAmmonia2>map("getAmmn", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getAmmn());
        if (exists(ammn).getOrDefault(false)) {
            return ammn.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityAmmonia2 -> fertilizerCommodityAmmonia2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityDiammoniumPhosphate2> dmmnmPhspht = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityDiammoniumPhosphate2>map("getDmmnmPhspht", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getDmmnmPhspht());
        if (exists(dmmnmPhspht).getOrDefault(false)) {
            return dmmnmPhspht.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityDiammoniumPhosphate2 -> fertilizerCommodityDiammoniumPhosphate2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityPotash2> ptsh = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityPotash2>map("getPtsh", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getPtsh());
        if (exists(ptsh).getOrDefault(false)) {
            return ptsh.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityPotash2 -> fertilizerCommodityPotash2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommoditySulphur2> slphr = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommoditySulphur2>map("getSlphr", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getSlphr());
        if (exists(slphr).getOrDefault(false)) {
            return slphr.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommoditySulphur2 -> fertilizerCommoditySulphur2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityUrea2> urea = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityUrea2>map("getUrea", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getUrea());
        if (exists(urea).getOrDefault(false)) {
            return urea.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityUrea2 -> fertilizerCommodityUrea2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityUreaAndAmmoniumNitrate2> ureaAndAmmnmNtrt = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityUreaAndAmmoniumNitrate2>map("getUreaAndAmmnmNtrt", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getUreaAndAmmnmNtrt());
        if (exists(ureaAndAmmnmNtrt).getOrDefault(false)) {
            return ureaAndAmmnmNtrt.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityUreaAndAmmoniumNitrate2 -> fertilizerCommodityUreaAndAmmoniumNitrate2.getBasePdct()).get();
        }
        final MapperS<FertilizerCommodityOther2> othr = MapperS.of(assetClassCommodityFertilizer4Choice).<FertilizerCommodityOther2>map("getOthr", _assetClassCommodityFertilizer4Choice -> _assetClassCommodityFertilizer4Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType5Code>map("getBasePdct", fertilizerCommodityOther2 -> fertilizerCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
