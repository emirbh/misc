package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityFreight4Choice__1;
import iso20022.auth030.fca.AssetClassProductType4Code;
import iso20022.auth030.fca.FreightCommodityContainerShip2__1;
import iso20022.auth030.fca.FreightCommodityDry3__1;
import iso20022.auth030.fca.FreightCommodityOther2__1;
import iso20022.auth030.fca.FreightCommodityWet3__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityFreight4Choice__1DeepPathUtil {
    public AssetClassProductType4Code chooseBasePdct(AssetClassCommodityFreight4Choice__1 assetClassCommodityFreight4Choice__1) {
        final MapperS<FreightCommodityDry3__1> dry = MapperS.of(assetClassCommodityFreight4Choice__1).<FreightCommodityDry3__1>map("getDry", _assetClassCommodityFreight4Choice__1 -> _assetClassCommodityFreight4Choice__1.getDry());
        if (exists(dry).getOrDefault(false)) {
            return dry.<AssetClassProductType4Code>map("getBasePdct", freightCommodityDry3__1 -> freightCommodityDry3__1.getBasePdct()).get();
        }
        final MapperS<FreightCommodityWet3__1> wet = MapperS.of(assetClassCommodityFreight4Choice__1).<FreightCommodityWet3__1>map("getWet", _assetClassCommodityFreight4Choice__1 -> _assetClassCommodityFreight4Choice__1.getWet());
        if (exists(wet).getOrDefault(false)) {
            return wet.<AssetClassProductType4Code>map("getBasePdct", freightCommodityWet3__1 -> freightCommodityWet3__1.getBasePdct()).get();
        }
        final MapperS<FreightCommodityContainerShip2__1> cntnrShip = MapperS.of(assetClassCommodityFreight4Choice__1).<FreightCommodityContainerShip2__1>map("getCntnrShip", _assetClassCommodityFreight4Choice__1 -> _assetClassCommodityFreight4Choice__1.getCntnrShip());
        if (exists(cntnrShip).getOrDefault(false)) {
            return cntnrShip.<AssetClassProductType4Code>map("getBasePdct", freightCommodityContainerShip2__1 -> freightCommodityContainerShip2__1.getBasePdct()).get();
        }
        final MapperS<FreightCommodityOther2__1> othr = MapperS.of(assetClassCommodityFreight4Choice__1).<FreightCommodityOther2__1>map("getOthr", _assetClassCommodityFreight4Choice__1 -> _assetClassCommodityFreight4Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType4Code>map("getBasePdct", freightCommodityOther2__1 -> freightCommodityOther2__1.getBasePdct()).get();
        }
        return null;
    }

}
