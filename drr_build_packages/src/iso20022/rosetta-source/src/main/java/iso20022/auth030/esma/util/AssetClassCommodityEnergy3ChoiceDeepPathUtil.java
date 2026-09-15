package iso20022.auth030.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.AssetClassCommodityEnergy3Choice;
import iso20022.auth030.esma.AssetClassProductType2Code;
import iso20022.auth030.esma.EnergyCommodityCoal2;
import iso20022.auth030.esma.EnergyCommodityDistillates2;
import iso20022.auth030.esma.EnergyCommodityElectricity2;
import iso20022.auth030.esma.EnergyCommodityInterEnergy2;
import iso20022.auth030.esma.EnergyCommodityLightEnd2;
import iso20022.auth030.esma.EnergyCommodityNaturalGas3;
import iso20022.auth030.esma.EnergyCommodityOil3;
import iso20022.auth030.esma.EnergyCommodityOther2;
import iso20022.auth030.esma.EnergyCommodityRenewableEnergy2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityEnergy3ChoiceDeepPathUtil {
    public AssetClassProductType2Code chooseBasePdct(AssetClassCommodityEnergy3Choice assetClassCommodityEnergy3Choice) {
        final MapperS<EnergyCommodityElectricity2> elctrcty = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityElectricity2>map("getElctrcty", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getElctrcty());
        if (exists(elctrcty).getOrDefault(false)) {
            return elctrcty.<AssetClassProductType2Code>map("getBasePdct", energyCommodityElectricity2 -> energyCommodityElectricity2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityNaturalGas3> ntrlGas = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityNaturalGas3>map("getNtrlGas", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getNtrlGas());
        if (exists(ntrlGas).getOrDefault(false)) {
            return ntrlGas.<AssetClassProductType2Code>map("getBasePdct", energyCommodityNaturalGas3 -> energyCommodityNaturalGas3.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityOil3> oil = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityOil3>map("getOil", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getOil());
        if (exists(oil).getOrDefault(false)) {
            return oil.<AssetClassProductType2Code>map("getBasePdct", energyCommodityOil3 -> energyCommodityOil3.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityCoal2> coal = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityCoal2>map("getCoal", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getCoal());
        if (exists(coal).getOrDefault(false)) {
            return coal.<AssetClassProductType2Code>map("getBasePdct", energyCommodityCoal2 -> energyCommodityCoal2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityInterEnergy2> intrNrgy = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityInterEnergy2>map("getIntrNrgy", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getIntrNrgy());
        if (exists(intrNrgy).getOrDefault(false)) {
            return intrNrgy.<AssetClassProductType2Code>map("getBasePdct", energyCommodityInterEnergy2 -> energyCommodityInterEnergy2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityRenewableEnergy2> rnwblNrgy = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityRenewableEnergy2>map("getRnwblNrgy", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getRnwblNrgy());
        if (exists(rnwblNrgy).getOrDefault(false)) {
            return rnwblNrgy.<AssetClassProductType2Code>map("getBasePdct", energyCommodityRenewableEnergy2 -> energyCommodityRenewableEnergy2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityLightEnd2> lghtEnd = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityLightEnd2>map("getLghtEnd", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getLghtEnd());
        if (exists(lghtEnd).getOrDefault(false)) {
            return lghtEnd.<AssetClassProductType2Code>map("getBasePdct", energyCommodityLightEnd2 -> energyCommodityLightEnd2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityDistillates2> dstllts = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityDistillates2>map("getDstllts", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getDstllts());
        if (exists(dstllts).getOrDefault(false)) {
            return dstllts.<AssetClassProductType2Code>map("getBasePdct", energyCommodityDistillates2 -> energyCommodityDistillates2.getBasePdct()).get();
        }
        final MapperS<EnergyCommodityOther2> othr = MapperS.of(assetClassCommodityEnergy3Choice).<EnergyCommodityOther2>map("getOthr", _assetClassCommodityEnergy3Choice -> _assetClassCommodityEnergy3Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType2Code>map("getBasePdct", energyCommodityOther2 -> energyCommodityOther2.getBasePdct()).get();
        }
        return null;
    }

}
