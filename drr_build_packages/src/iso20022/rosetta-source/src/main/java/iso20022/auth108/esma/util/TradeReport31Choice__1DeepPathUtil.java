package iso20022.auth108.esma.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import iso20022.auth108.esma.MarginCollateralReport4__1;
import iso20022.auth108.esma.MarginReportData7__1;
import iso20022.auth108.esma.PostedMarginOrCollateral6__1;
import iso20022.auth108.esma.ReceivedMarginOrCollateral6__1;
import iso20022.auth108.esma.TradeCounterpartyReport20__1;
import iso20022.auth108.esma.TradeReport31Choice__1;
import iso20022.auth108.esma.UniqueTransactionIdentifier2Choice__1;
import java.time.ZonedDateTime;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class TradeReport31Choice__1DeepPathUtil {
    public TradeCounterpartyReport20__1 chooseCtrPtyId(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<TradeCounterpartyReport20__1>map("getCtrPtyId", marginReportData7__1 -> marginReportData7__1.getCtrPtyId()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TradeCounterpartyReport20__1>map("getCtrPtyId", marginReportData7__1 -> marginReportData7__1.getCtrPtyId()).get();
        }
        return null;
    }

    public MarginCollateralReport4__1 chooseColl(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<MarginCollateralReport4__1>map("getColl", marginReportData7__1 -> marginReportData7__1.getColl()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<MarginCollateralReport4__1>map("getColl", marginReportData7__1 -> marginReportData7__1.getColl()).get();
        }
        return null;
    }

    public ZonedDateTime chooseRptgTmStmp(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ZonedDateTime>map("getRptgTmStmp", marginReportData7__1 -> marginReportData7__1.getRptgTmStmp()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ZonedDateTime>map("getRptgTmStmp", marginReportData7__1 -> marginReportData7__1.getRptgTmStmp()).get();
        }
        return null;
    }

    public Date chooseEvtDt(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<Date>map("getEvtDt", marginReportData7__1 -> marginReportData7__1.getEvtDt()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<Date>map("getEvtDt", marginReportData7__1 -> marginReportData7__1.getEvtDt()).get();
        }
        return null;
    }

    public UniqueTransactionIdentifier2Choice__1 chooseTxId(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<UniqueTransactionIdentifier2Choice__1>map("getTxId", marginReportData7__1 -> marginReportData7__1.getTxId()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<UniqueTransactionIdentifier2Choice__1>map("getTxId", marginReportData7__1 -> marginReportData7__1.getTxId()).get();
        }
        return null;
    }

    public ReceivedMarginOrCollateral6__1 chooseRcvdMrgnOrColl(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ReceivedMarginOrCollateral6__1>map("getRcvdMrgnOrColl", marginReportData7__1 -> marginReportData7__1.getRcvdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ReceivedMarginOrCollateral6__1>map("getRcvdMrgnOrColl", marginReportData7__1 -> marginReportData7__1.getRcvdMrgnOrColl()).get();
        }
        return null;
    }

    public PostedMarginOrCollateral6__1 choosePstdMrgnOrColl(TradeReport31Choice__1 tradeReport31Choice__1) {
        final MapperS<MarginReportData7__1> mrgnUpd = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getMrgnUpd", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<PostedMarginOrCollateral6__1>map("getPstdMrgnOrColl", marginReportData7__1 -> marginReportData7__1.getPstdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7__1> crrctn = MapperS.of(tradeReport31Choice__1).<MarginReportData7__1>map("getCrrctn", _tradeReport31Choice__1 -> _tradeReport31Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<PostedMarginOrCollateral6__1>map("getPstdMrgnOrColl", marginReportData7__1 -> marginReportData7__1.getPstdMrgnOrColl()).get();
        }
        return null;
    }

}
