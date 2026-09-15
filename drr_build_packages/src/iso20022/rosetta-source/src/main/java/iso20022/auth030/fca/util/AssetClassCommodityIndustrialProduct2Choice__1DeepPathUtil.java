package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityIndustrialProduct2Choice__1;
import iso20022.auth030.fca.AssetClassProductType6Code;
import iso20022.auth030.fca.IndustrialProductCommodityConstruction2__1;
import iso20022.auth030.fca.IndustrialProductCommodityManufacturing2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityIndustrialProduct2Choice__1DeepPathUtil {
    public AssetClassProductType6Code chooseBasePdct(AssetClassCommodityIndustrialProduct2Choice__1 assetClassCommodityIndustrialProduct2Choice__1) {
        final MapperS<IndustrialProductCommodityConstruction2__1> cnstrctn = MapperS.of(assetClassCommodityIndustrialProduct2Choice__1).<IndustrialProductCommodityConstruction2__1>map("getCnstrctn", _assetClassCommodityIndustrialProduct2Choice__1 -> _assetClassCommodityIndustrialProduct2Choice__1.getCnstrctn());
        if (exists(cnstrctn).getOrDefault(false)) {
            return cnstrctn.<AssetClassProductType6Code>map("getBasePdct", industrialProductCommodityConstruction2__1 -> industrialProductCommodityConstruction2__1.getBasePdct()).get();
        }
        final MapperS<IndustrialProductCommodityManufacturing2__1> manfctg = MapperS.of(assetClassCommodityIndustrialProduct2Choice__1).<IndustrialProductCommodityManufacturing2__1>map("getManfctg", _assetClassCommodityIndustrialProduct2Choice__1 -> _assetClassCommodityIndustrialProduct2Choice__1.getManfctg());
        if (exists(manfctg).getOrDefault(false)) {
            return manfctg.<AssetClassProductType6Code>map("getBasePdct", industrialProductCommodityManufacturing2__1 -> industrialProductCommodityManufacturing2__1.getBasePdct()).get();
        }
        return null;
    }

}
