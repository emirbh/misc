package iso20022.auth108.hkma.tr.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import iso20022.auth108.hkma.tr.MarginCollateralReport5__1;
import iso20022.auth108.hkma.tr.MarginReportData9__1;
import iso20022.auth108.hkma.tr.PostedMarginOrCollateral6__1;
import iso20022.auth108.hkma.tr.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.hkma.tr.TechnicalAttributes6__1;
import iso20022.auth108.hkma.tr.TradeCounterpartyReport20__1;
import iso20022.auth108.hkma.tr.TradeReport34Choice__1;
import iso20022.auth108.hkma.tr.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class TradeReport34Choice__1DeepPathUtil {
    public TechnicalAttributes6__1 chooseTechAttrbts(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<TechnicalAttributes6__1>map("getTechAttrbts", marginReportData9__1 -> marginReportData9__1.getTechAttrbts()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TechnicalAttributes6__1>map("getTechAttrbts", marginReportData9__1 -> marginReportData9__1.getTechAttrbts()).get();
        }
        return null;
    }

    public TradeCounterpartyReport20__1 chooseCtrPtyId(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<TradeCounterpartyReport20__1>map("getCtrPtyId", marginReportData9__1 -> marginReportData9__1.getCtrPtyId()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TradeCounterpartyReport20__1>map("getCtrPtyId", marginReportData9__1 -> marginReportData9__1.getCtrPtyId()).get();
        }
        return null;
    }

    public MarginCollateralReport5__1 chooseColl(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<MarginCollateralReport5__1>map("getColl", marginReportData9__1 -> marginReportData9__1.getColl()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<MarginCollateralReport5__1>map("getColl", marginReportData9__1 -> marginReportData9__1.getColl()).get();
        }
        return null;
    }

    public ZonedDateTime chooseRptgTmStmp(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ZonedDateTime>map("getRptgTmStmp", marginReportData9__1 -> marginReportData9__1.getRptgTmStmp()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ZonedDateTime>map("getRptgTmStmp", marginReportData9__1 -> marginReportData9__1.getRptgTmStmp()).get();
        }
        return null;
    }

    public Date chooseEvtDt(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<Date>map("getEvtDt", marginReportData9__1 -> marginReportData9__1.getEvtDt()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<Date>map("getEvtDt", marginReportData9__1 -> marginReportData9__1.getEvtDt()).get();
        }
        return null;
    }

    public UniqueTransactionIdentifier2Choice__1 chooseTxId(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<UniqueTransactionIdentifier2Choice__1>map("getTxId", marginReportData9__1 -> marginReportData9__1.getTxId()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<UniqueTransactionIdentifier2Choice__1>map("getTxId", marginReportData9__1 -> marginReportData9__1.getTxId()).get();
        }
        return null;
    }

    public ReceivedMarginOrCollateral6__1 chooseRcvdMrgnOrColl(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ReceivedMarginOrCollateral6__1>map("getRcvdMrgnOrColl", marginReportData9__1 -> marginReportData9__1.getRcvdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ReceivedMarginOrCollateral6__1>map("getRcvdMrgnOrColl", marginReportData9__1 -> marginReportData9__1.getRcvdMrgnOrColl()).get();
        }
        return null;
    }

    public PostedMarginOrCollateral6__1 choosePstdMrgnOrColl(TradeReport34Choice__1 tradeReport34Choice__1) {
        final MapperS<MarginReportData9__1> mrgnUpd = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getMrgnUpd", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<PostedMarginOrCollateral6__1>map("getPstdMrgnOrColl", marginReportData9__1 -> marginReportData9__1.getPstdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData9__1> crrctn = MapperS.of(tradeReport34Choice__1).<MarginReportData9__1>map("getCrrctn", _tradeReport34Choice__1 -> _tradeReport34Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<PostedMarginOrCollateral6__1>map("getPstdMrgnOrColl", marginReportData9__1 -> marginReportData9__1.getPstdMrgnOrColl()).get();
        }
        return null;
    }

}
