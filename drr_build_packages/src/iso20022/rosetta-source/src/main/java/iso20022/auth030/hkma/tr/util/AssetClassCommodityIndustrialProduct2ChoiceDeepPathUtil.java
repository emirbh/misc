package iso20022.auth030.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.tr.AssetClassCommodityIndustrialProduct2Choice;
import iso20022.auth030.hkma.tr.AssetClassProductType6Code;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityConstruction2;
import iso20022.auth030.hkma.tr.IndustrialProductCommodityManufacturing2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityIndustrialProduct2ChoiceDeepPathUtil {
    public AssetClassProductType6Code chooseBasePdct(AssetClassCommodityIndustrialProduct2Choice assetClassCommodityIndustrialProduct2Choice) {
        final MapperS<IndustrialProductCommodityConstruction2> cnstrctn = MapperS.of(assetClassCommodityIndustrialProduct2Choice).<IndustrialProductCommodityConstruction2>map("getCnstrctn", _assetClassCommodityIndustrialProduct2Choice -> _assetClassCommodityIndustrialProduct2Choice.getCnstrctn());
        if (exists(cnstrctn).getOrDefault(false)) {
            return cnstrctn.<AssetClassProductType6Code>map("getBasePdct", industrialProductCommodityConstruction2 -> industrialProductCommodityConstruction2.getBasePdct()).get();
        }
        final MapperS<IndustrialProductCommodityManufacturing2> manfctg = MapperS.of(assetClassCommodityIndustrialProduct2Choice).<IndustrialProductCommodityManufacturing2>map("getManfctg", _assetClassCommodityIndustrialProduct2Choice -> _assetClassCommodityIndustrialProduct2Choice.getManfctg());
        if (exists(manfctg).getOrDefault(false)) {
            return manfctg.<AssetClassProductType6Code>map("getBasePdct", industrialProductCommodityManufacturing2 -> industrialProductCommodityManufacturing2.getBasePdct()).get();
        }
        return null;
    }

}
