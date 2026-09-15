package iso20022.auth030.fca.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.fca.AssetClassCommodityPaper4Choice__1;
import iso20022.auth030.fca.AssetClassProductType8Code;
import iso20022.auth030.fca.PaperCommodityContainerBoard2__1;
import iso20022.auth030.fca.PaperCommodityNewsprint2__1;
import iso20022.auth030.fca.PaperCommodityOther1__1;
import iso20022.auth030.fca.PaperCommodityPulp2__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class AssetClassCommodityPaper4Choice__1DeepPathUtil {
    public AssetClassProductType8Code chooseBasePdct(AssetClassCommodityPaper4Choice__1 assetClassCommodityPaper4Choice__1) {
        final MapperS<PaperCommodityContainerBoard2__1> cntnrBrd = MapperS.of(assetClassCommodityPaper4Choice__1).<PaperCommodityContainerBoard2__1>map("getCntnrBrd", _assetClassCommodityPaper4Choice__1 -> _assetClassCommodityPaper4Choice__1.getCntnrBrd());
        if (exists(cntnrBrd).getOrDefault(false)) {
            return cntnrBrd.<AssetClassProductType8Code>map("getBasePdct", paperCommodityContainerBoard2__1 -> paperCommodityContainerBoard2__1.getBasePdct()).get();
        }
        final MapperS<PaperCommodityNewsprint2__1> nwsprnt = MapperS.of(assetClassCommodityPaper4Choice__1).<PaperCommodityNewsprint2__1>map("getNwsprnt", _assetClassCommodityPaper4Choice__1 -> _assetClassCommodityPaper4Choice__1.getNwsprnt());
        if (exists(nwsprnt).getOrDefault(false)) {
            return nwsprnt.<AssetClassProductType8Code>map("getBasePdct", paperCommodityNewsprint2__1 -> paperCommodityNewsprint2__1.getBasePdct()).get();
        }
        final MapperS<PaperCommodityPulp2__1> pulp = MapperS.of(assetClassCommodityPaper4Choice__1).<PaperCommodityPulp2__1>map("getPulp", _assetClassCommodityPaper4Choice__1 -> _assetClassCommodityPaper4Choice__1.getPulp());
        if (exists(pulp).getOrDefault(false)) {
            return pulp.<AssetClassProductType8Code>map("getBasePdct", paperCommodityPulp2__1 -> paperCommodityPulp2__1.getBasePdct()).get();
        }
        final MapperS<PaperCommodityOther1__1> rcvrdPpr = MapperS.of(assetClassCommodityPaper4Choice__1).<PaperCommodityOther1__1>map("getRcvrdPpr", _assetClassCommodityPaper4Choice__1 -> _assetClassCommodityPaper4Choice__1.getRcvrdPpr());
        if (exists(rcvrdPpr).getOrDefault(false)) {
            return rcvrdPpr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityOther1__1 -> paperCommodityOther1__1.getBasePdct()).get();
        }
        final MapperS<PaperCommodityOther1__1> othr = MapperS.of(assetClassCommodityPaper4Choice__1).<PaperCommodityOther1__1>map("getOthr", _assetClassCommodityPaper4Choice__1 -> _assetClassCommodityPaper4Choice__1.getOthr());
        if (exists(othr).getOrDefault(false)) {
            return othr.<AssetClassProductType8Code>map("getBasePdct", paperCommodityOther1__1 -> paperCommodityOther1__1.getBasePdct()).get();
        }
        return null;
    }

}
