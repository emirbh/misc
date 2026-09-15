package iso20022.auth030.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.AssetClassCommodityFreight4Choice;
import iso20022.auth030.esma.AssetClassProductType4Code;
import iso20022.auth030.esma.FreightCommodityContainerShip2;
import iso20022.auth030.esma.FreightCommodityDry3;
import iso20022.auth030.esma.FreightCommodityOther2;
import iso20022.auth030.esma.FreightCommodityWet3;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityFreight4ChoiceDeepPathUtil {
    public AssetClassProductType4Code chooseBasePdct(AssetClassCommodityFreight4Choice assetClassCommodityFreight4Choice) {
        final MapperS<FreightCommodityDry3> dry = MapperS.of(assetClassCommodityFreight4Choice).<FreightCommodityDry3>map("getDry", _assetClassCommodityFreight4Choice -> _assetClassCommodityFreight4Choice.getDry());
        if (exists(dry).getOrDefault(false)) {
            return dry.<AssetClassProductType4Code>map("getBasePdct", freightCommodityDry3 -> freightCommodityDry3.getBasePdct()).get();
        }
        final MapperS<FreightCommodityWet3> wet = MapperS.of(assetClassCommodityFreight4Choice).<FreightCommodityWet3>map("getWet", _assetClassCommodityFreight4Choice -> _assetClassCommodityFreight4Choice.getWet());
        if (exists(wet).getOrDefault(false)) {
            return wet.<AssetClassProductType4Code>map("getBasePdct", freightCommodityWet3 -> freightCommodityWet3.getBasePdct()).get();
        }
        final MapperS<FreightCommodityContainerShip2> cntnrShip = MapperS.of(assetClassCommodityFreight4Choice).<FreightCommodityContainerShip2>map("getCntnrShip", _assetClassCommodityFreight4Choice -> _assetClassCommodityFreight4Choice.getCntnrShip());
        if (exists(cntnrShip).getOrDefault(false)) {
            return cntnrShip.<AssetClassProductType4Code>map("getBasePdct", freightCommodityContainerShip2 -> freightCommodityContainerShip2.getBasePdct()).get();
        }
        final MapperS<FreightCommodityOther2> othr = MapperS.of(assetClassCommodityFreight4Choice).<FreightCommodityOther2>map("getOthr", _assetClassCommodityFreight4Choice -> _assetClassCommodityFreight4Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType4Code>map("getBasePdct", freightCommodityOther2 -> freightCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
