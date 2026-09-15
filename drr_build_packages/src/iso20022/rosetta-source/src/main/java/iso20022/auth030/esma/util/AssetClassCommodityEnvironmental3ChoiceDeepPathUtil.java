package iso20022.auth030.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.AssetClassCommodityEnvironmental3Choice;
import iso20022.auth030.esma.AssetClassProductType3Code;
import iso20022.auth030.esma.EnvironmentCommodityOther2;
import iso20022.auth030.esma.EnvironmentalCommodityCarbonRelated2;
import iso20022.auth030.esma.EnvironmentalCommodityEmission3;
import iso20022.auth030.esma.EnvironmentalCommodityWeather2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityEnvironmental3ChoiceDeepPathUtil {
    public AssetClassProductType3Code chooseBasePdct(AssetClassCommodityEnvironmental3Choice assetClassCommodityEnvironmental3Choice) {
        final MapperS<EnvironmentalCommodityEmission3> emssns = MapperS.of(assetClassCommodityEnvironmental3Choice).<EnvironmentalCommodityEmission3>map("getEmssns", _assetClassCommodityEnvironmental3Choice -> _assetClassCommodityEnvironmental3Choice.getEmssns());
        if (exists(emssns).getOrDefault(false)) {
            return emssns.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityEmission3 -> environmentalCommodityEmission3.getBasePdct()).get();
        }
        final MapperS<EnvironmentalCommodityWeather2> wthr = MapperS.of(assetClassCommodityEnvironmental3Choice).<EnvironmentalCommodityWeather2>map("getWthr", _assetClassCommodityEnvironmental3Choice -> _assetClassCommodityEnvironmental3Choice.getWthr());
        if (exists(wthr).getOrDefault(false)) {
            return wthr.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityWeather2 -> environmentalCommodityWeather2.getBasePdct()).get();
        }
        final MapperS<EnvironmentalCommodityCarbonRelated2> crbnRltd = MapperS.of(assetClassCommodityEnvironmental3Choice).<EnvironmentalCommodityCarbonRelated2>map("getCrbnRltd", _assetClassCommodityEnvironmental3Choice -> _assetClassCommodityEnvironmental3Choice.getCrbnRltd());
        if (exists(crbnRltd).getOrDefault(false)) {
            return crbnRltd.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityCarbonRelated2 -> environmentalCommodityCarbonRelated2.getBasePdct()).get();
        }
        final MapperS<EnvironmentCommodityOther2> othr = MapperS.of(assetClassCommodityEnvironmental3Choice).<EnvironmentCommodityOther2>map("getOthr", _assetClassCommodityEnvironmental3Choice -> _assetClassCommodityEnvironmental3Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType3Code>map("getBasePdct", environmentCommodityOther2 -> environmentCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
