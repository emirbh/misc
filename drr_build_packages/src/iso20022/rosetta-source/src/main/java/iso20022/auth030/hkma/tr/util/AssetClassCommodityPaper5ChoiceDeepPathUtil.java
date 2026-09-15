package iso20022.auth030.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.tr.AssetClassCommodityPaper5Choice;
import iso20022.auth030.hkma.tr.AssetClassProductType8Code;
import iso20022.auth030.hkma.tr.PaperCommodityContainerBoard2;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import iso20022.auth030.hkma.tr.PaperCommodityOther1;
import iso20022.auth030.hkma.tr.PaperCommodityPulp2;
import iso20022.auth030.hkma.tr.PaperCommodityRecoveredPaper3;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityPaper5ChoiceDeepPathUtil {
    public AssetClassProductType8Code chooseBasePdct(AssetClassCommodityPaper5Choice assetClassCommodityPaper5Choice) {
        final MapperS<PaperCommodityContainerBoard2> cntnrBrd = MapperS.of(assetClassCommodityPaper5Choice).<PaperCommodityContainerBoard2>map("getCntnrBrd", _assetClassCommodityPaper5Choice -> _assetClassCommodityPaper5Choice.getCntnrBrd());
        if (exists(cntnrBrd).getOrDefault(false)) {
            return cntnrBrd.<AssetClassProductType8Code>map("getBasePdct", paperCommodityContainerBoard2 -> paperCommodityContainerBoard2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityNewsprint2> nwsprnt = MapperS.of(assetClassCommodityPaper5Choice).<PaperCommodityNewsprint2>map("getNwsprnt", _assetClassCommodityPaper5Choice -> _assetClassCommodityPaper5Choice.getNwsprnt());
        if (exists(nwsprnt).getOrDefault(false)) {
            return nwsprnt.<AssetClassProductType8Code>map("getBasePdct", paperCommodityNewsprint2 -> paperCommodityNewsprint2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityPulp2> pulp = MapperS.of(assetClassCommodityPaper5Choice).<PaperCommodityPulp2>map("getPulp", _assetClassCommodityPaper5Choice -> _assetClassCommodityPaper5Choice.getPulp());
        if (exists(pulp).getOrDefault(false)) {
            return pulp.<AssetClassProductType8Code>map("getBasePdct", paperCommodityPulp2 -> paperCommodityPulp2.getBasePdct()).get();
        }
        final MapperS<PaperCommodityRecoveredPaper3> rcvrdPpr = MapperS.of(assetClassCommodityPaper5Choice).<PaperCommodityRecoveredPaper3>map("getRcvrdPpr", _assetClassCommodityPaper5Choice -> _assetClassCommodityPaper5Choice.getRcvrdPpr());
        if (exists(rcvrdPpr).getOrDefault(false)) {
            return rcvrdPpr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityRecoveredPaper3 -> paperCommodityRecoveredPaper3.getBasePdct()).get();
        }
        final MapperS<PaperCommodityOther1> othr = MapperS.of(assetClassCommodityPaper5Choice).<PaperCommodityOther1>map("getOthr", _assetClassCommodityPaper5Choice -> _assetClassCommodityPaper5Choice.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityOther1 -> paperCommodityOther1.getBasePdct()).get();
        }
        return null;
    }

}
