package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityEnvironmental3Choice__2;
import iso20022.auth030.fca.AssetClassProductType3Code;
import iso20022.auth030.fca.EnvironmentCommodityOther2;
import iso20022.auth030.fca.EnvironmentalCommodityCarbonRelated2__1;
import iso20022.auth030.fca.EnvironmentalCommodityEmission3__1;
import iso20022.auth030.fca.EnvironmentalCommodityWeather2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityEnvironmental3Choice__2DeepPathUtil {
    public AssetClassProductType3Code chooseBasePdct(AssetClassCommodityEnvironmental3Choice__2 assetClassCommodityEnvironmental3Choice__2) {
        final MapperS<EnvironmentalCommodityEmission3__1> emssns = MapperS.of(assetClassCommodityEnvironmental3Choice__2).<EnvironmentalCommodityEmission3__1>map("getEmssns", _assetClassCommodityEnvironmental3Choice__2 -> _assetClassCommodityEnvironmental3Choice__2.getEmssns());
        if (exists(emssns).getOrDefault(false)) {
            return emssns.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityEmission3__1 -> environmentalCommodityEmission3__1.getBasePdct()).get();
        }
        final MapperS<EnvironmentalCommodityWeather2__1> wthr = MapperS.of(assetClassCommodityEnvironmental3Choice__2).<EnvironmentalCommodityWeather2__1>map("getWthr", _assetClassCommodityEnvironmental3Choice__2 -> _assetClassCommodityEnvironmental3Choice__2.getWthr());
        if (exists(wthr).getOrDefault(false)) {
            return wthr.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityWeather2__1 -> environmentalCommodityWeather2__1.getBasePdct()).get();
        }
        final MapperS<EnvironmentalCommodityCarbonRelated2__1> crbnRltd = MapperS.of(assetClassCommodityEnvironmental3Choice__2).<EnvironmentalCommodityCarbonRelated2__1>map("getCrbnRltd", _assetClassCommodityEnvironmental3Choice__2 -> _assetClassCommodityEnvironmental3Choice__2.getCrbnRltd());
        if (exists(crbnRltd).getOrDefault(false)) {
            return crbnRltd.<AssetClassProductType3Code>map("getBasePdct", environmentalCommodityCarbonRelated2__1 -> environmentalCommodityCarbonRelated2__1.getBasePdct()).get();
        }
        final MapperS<EnvironmentCommodityOther2> othr = MapperS.of(assetClassCommodityEnvironmental3Choice__2).<EnvironmentCommodityOther2>map("getOthr", _assetClassCommodityEnvironmental3Choice__2 -> _assetClassCommodityEnvironmental3Choice__2.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType3Code>map("getBasePdct", environmentCommodityOther2 -> environmentCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
