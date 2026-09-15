package iso20022.auth030.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.esma.AssetClassCommodityPaper4Choice;
import iso20022.auth030.esma.AssetClassProductType8Code;
import iso20022.auth030.esma.PaperCommodityContainerBoard2;
import iso20022.auth030.esma.PaperCommodityNewsprint2;
import iso20022.auth030.esma.PaperCommodityOther1;
import iso20022.auth030.esma.PaperCommodityPulp2;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityPaper4ChoiceDeepPathUtil {
    public AssetClassProductType8Code chooseBasePdct(AssetClassCommodityPaper4Choice assetClassCommodityPaper4Choice) {
        final MapperS<PaperCommodityContainerBoard2> cntnrBrd = MapperS.of(assetClassCommodityPaper4Choice).<PaperCommodityContainerBoard2>map("getCntnrBrd", _assetClassCommodityPaper4Choice -> _assetClassCommodityPaper4Choice.getCntnrBrd());
        if (exists(cntnrBrd).getOrDefault(false)) {
            return cntnrBrd.<AssetClassProductType8Code>map("getBasePdct", paperCommodityContainerBoard2 -> paperCommodityContainerBoard2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityNewsprint2> nwsprnt = MapperS.of(assetClassCommodityPaper4Choice).<PaperCommodityNewsprint2>map("getNwsprnt", _assetClassCommodityPaper4Choice -> _assetClassCommodityPaper4Choice.getNwsprnt());
        if (exists(nwsprnt).getOrDefault(false)) {
            return nwsprnt.<AssetClassProductType8Code>map("getBasePdct", paperCommodityNewsprint2 -> paperCommodityNewsprint2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityPulp2> pulp = MapperS.of(assetClassCommodityPaper4Choice).<PaperCommodityPulp2>map("getPulp", _assetClassCommodityPaper4Choice -> _assetClassCommodityPaper4Choice.getPulp());
        if (exists(pulp).getOrDefault(false)) {
            return pulp.<AssetClassProductType8Code>map("getBasePdct", paperCommodityPulp2 -> paperCommodityPulp2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityOther1> rcvrdPpr = MapperS.of(assetClassCommodityPaper4Choice).<PaperCommodityOther1>map("getRcvrdPpr", _assetClassCommodityPaper4Choice -> _assetClassCommodityPaper4Choice.getRcvrdPpr());
        if (exists(rcvrdPpr).getOrDefault(false)) {
            return rcvrdPpr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityOther1 -> paperCommodityOther1.getBasePdct()).get();
        }
        final MapperS<PaperCommodityOther1> othr = MapperS.of(assetClassCommodityPaper4Choice).<PaperCommodityOther1>map("getOthr", _assetClassCommodityPaper4Choice -> _assetClassCommodityPaper4Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityOther1 -> paperCommodityOther1.getBasePdct()).get();
        }
        return null;
    }

}
