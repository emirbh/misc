package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityEnergy3Choice__1;
import iso20022.auth030.fca.AssetClassProductType2Code;
import iso20022.auth030.fca.EnergyCommodityCoal2__1;
import iso20022.auth030.fca.EnergyCommodityDistillates2__1;
import iso20022.auth030.fca.EnergyCommodityElectricity2__1;
import iso20022.auth030.fca.EnergyCommodityInterEnergy2__1;
import iso20022.auth030.fca.EnergyCommodityLightEnd2__1;
import iso20022.auth030.fca.EnergyCommodityNaturalGas3__1;
import iso20022.auth030.fca.EnergyCommodityOil3__1;
import iso20022.auth030.fca.EnergyCommodityOther2__1;
import iso20022.auth030.fca.EnergyCommodityRenewableEnergy2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityEnergy3Choice__1DeepPathUtil {
    public AssetClassProductType2Code chooseBasePdct(AssetClassCommodityEnergy3Choice__1 assetClassCommodityEnergy3Choice__1) {
        final MapperS<EnergyCommodityElectricity2__1> elctrcty = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityElectricity2__1>map("getElctrcty", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getElctrcty());
        if (exists(elctrcty).getOrDefault(false)) {
            return elctrcty.<AssetClassProductType2Code>map("getBasePdct", energyCommodityElectricity2__1 -> energyCommodityElectricity2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityNaturalGas3__1> ntrlGas = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityNaturalGas3__1>map("getNtrlGas", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getNtrlGas());
        if (exists(ntrlGas).getOrDefault(false)) {
            return ntrlGas.<AssetClassProductType2Code>map("getBasePdct", energyCommodityNaturalGas3__1 -> energyCommodityNaturalGas3__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityOil3__1> oil = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityOil3__1>map("getOil", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getOil());
        if (exists(oil).getOrDefault(false)) {
            return oil.<AssetClassProductType2Code>map("getBasePdct", energyCommodityOil3__1 -> energyCommodityOil3__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityCoal2__1> coal = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityCoal2__1>map("getCoal", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getCoal());
        if (exists(coal).getOrDefault(false)) {
            return coal.<AssetClassProductType2Code>map("getBasePdct", energyCommodityCoal2__1 -> energyCommodityCoal2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityInterEnergy2__1> intrNrgy = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityInterEnergy2__1>map("getIntrNrgy", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getIntrNrgy());
        if (exists(intrNrgy).getOrDefault(false)) {
            return intrNrgy.<AssetClassProductType2Code>map("getBasePdct", energyCommodityInterEnergy2__1 -> energyCommodityInterEnergy2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityRenewableEnergy2__1> rnwblNrgy = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityRenewableEnergy2__1>map("getRnwblNrgy", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getRnwblNrgy());
        if (exists(rnwblNrgy).getOrDefault(false)) {
            return rnwblNrgy.<AssetClassProductType2Code>map("getBasePdct", energyCommodityRenewableEnergy2__1 -> energyCommodityRenewableEnergy2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityLightEnd2__1> lghtEnd = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityLightEnd2__1>map("getLghtEnd", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getLghtEnd());
        if (exists(lghtEnd).getOrDefault(false)) {
            return lghtEnd.<AssetClassProductType2Code>map("getBasePdct", energyCommodityLightEnd2__1 -> energyCommodityLightEnd2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityDistillates2__1> dstllts = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityDistillates2__1>map("getDstllts", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getDstllts());
        if (exists(dstllts).getOrDefault(false)) {
            return dstllts.<AssetClassProductType2Code>map("getBasePdct", energyCommodityDistillates2__1 -> energyCommodityDistillates2__1.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityOther2__1> othr = MapperS.of(assetClassCommodityEnergy3Choice__1).<EnergyCommodityOther2__1>map("getOthr", _assetClassCommodityEnergy3Choice__1 -> _assetClassCommodityEnergy3Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType2Code>map("getBasePdct", energyCommodityOther2__1 -> energyCommodityOther2__1.getBasePdct()).get();
        }
        return null;
    }

}
