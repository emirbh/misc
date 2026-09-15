package iso20022.auth108.iso.util;

import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import iso20022.auth108.iso.MarginCollateralReport4;
import iso20022.auth108.iso.MarginReportData7;
import iso20022.auth108.iso.PostedMarginOrCollateral6;
import iso20022.auth108.iso.ReceivedMarginOrCollateral6;
import iso20022.auth108.iso.SupplementaryData1;
import iso20022.auth108.iso.TechnicalAttributes6;
import iso20022.auth108.iso.TradeCounterpartyReport20;
import iso20022.auth108.iso.TradeReport31Choice;
import iso20022.auth108.iso.UniqueTransactionIdentifier2Choice;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class TradeReport31ChoiceDeepPathUtil {
    public Boolean chooseCtrPtyRatgTrggrInd(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<Boolean>map("getCtrPtyRatgTrggrInd", marginReportData7 -> marginReportData7.getCtrPtyRatgTrggrInd()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<Boolean>map("getCtrPtyRatgTrggrInd", marginReportData7 -> marginReportData7.getCtrPtyRatgTrggrInd()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<Boolean>map("getCtrPtyRatgTrggrInd", marginReportData7 -> marginReportData7.getCtrPtyRatgTrggrInd()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<Boolean>map("getCtrPtyRatgTrggrInd", marginReportData7 -> marginReportData7.getCtrPtyRatgTrggrInd()).get();
        }
        return null;
    }

    public TechnicalAttributes6 chooseTechAttrbts(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<TechnicalAttributes6>map("getTechAttrbts", marginReportData7 -> marginReportData7.getTechAttrbts()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<TechnicalAttributes6>map("getTechAttrbts", marginReportData7 -> marginReportData7.getTechAttrbts()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<TechnicalAttributes6>map("getTechAttrbts", marginReportData7 -> marginReportData7.getTechAttrbts()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TechnicalAttributes6>map("getTechAttrbts", marginReportData7 -> marginReportData7.getTechAttrbts()).get();
        }
        return null;
    }

    public TradeCounterpartyReport20 chooseCtrPtyId(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<TradeCounterpartyReport20>map("getCtrPtyId", marginReportData7 -> marginReportData7.getCtrPtyId()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<TradeCounterpartyReport20>map("getCtrPtyId", marginReportData7 -> marginReportData7.getCtrPtyId()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<TradeCounterpartyReport20>map("getCtrPtyId", marginReportData7 -> marginReportData7.getCtrPtyId()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TradeCounterpartyReport20>map("getCtrPtyId", marginReportData7 -> marginReportData7.getCtrPtyId()).get();
        }
        return null;
    }

    public MarginCollateralReport4 chooseColl(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<MarginCollateralReport4>map("getColl", marginReportData7 -> marginReportData7.getColl()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<MarginCollateralReport4>map("getColl", marginReportData7 -> marginReportData7.getColl()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<MarginCollateralReport4>map("getColl", marginReportData7 -> marginReportData7.getColl()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<MarginCollateralReport4>map("getColl", marginReportData7 -> marginReportData7.getColl()).get();
        }
        return null;
    }

    public Boolean chooseCtrPtyRatgThrshldInd(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<Boolean>map("getCtrPtyRatgThrshldInd", marginReportData7 -> marginReportData7.getCtrPtyRatgThrshldInd()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<Boolean>map("getCtrPtyRatgThrshldInd", marginReportData7 -> marginReportData7.getCtrPtyRatgThrshldInd()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<Boolean>map("getCtrPtyRatgThrshldInd", marginReportData7 -> marginReportData7.getCtrPtyRatgThrshldInd()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<Boolean>map("getCtrPtyRatgThrshldInd", marginReportData7 -> marginReportData7.getCtrPtyRatgThrshldInd()).get();
        }
        return null;
    }

    public ZonedDateTime chooseRptgTmStmp(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<ZonedDateTime>map("getRptgTmStmp", marginReportData7 -> marginReportData7.getRptgTmStmp()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ZonedDateTime>map("getRptgTmStmp", marginReportData7 -> marginReportData7.getRptgTmStmp()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<ZonedDateTime>map("getRptgTmStmp", marginReportData7 -> marginReportData7.getRptgTmStmp()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ZonedDateTime>map("getRptgTmStmp", marginReportData7 -> marginReportData7.getRptgTmStmp()).get();
        }
        return null;
    }

    public Date chooseEvtDt(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<Date>map("getEvtDt", marginReportData7 -> marginReportData7.getEvtDt()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<Date>map("getEvtDt", marginReportData7 -> marginReportData7.getEvtDt()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<Date>map("getEvtDt", marginReportData7 -> marginReportData7.getEvtDt()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<Date>map("getEvtDt", marginReportData7 -> marginReportData7.getEvtDt()).get();
        }
        return null;
    }

    public List<SupplementaryData1> chooseSplmtryData(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<SupplementaryData1>mapC("getSplmtryData", marginReportData7 -> marginReportData7.getSplmtryData()).getMulti();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<SupplementaryData1>mapC("getSplmtryData", marginReportData7 -> marginReportData7.getSplmtryData()).getMulti();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<SupplementaryData1>mapC("getSplmtryData", marginReportData7 -> marginReportData7.getSplmtryData()).getMulti();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<SupplementaryData1>mapC("getSplmtryData", marginReportData7 -> marginReportData7.getSplmtryData()).getMulti();
        }
        return Collections.<SupplementaryData1>emptyList();
    }

    public UniqueTransactionIdentifier2Choice chooseTxId(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<UniqueTransactionIdentifier2Choice>map("getTxId", marginReportData7 -> marginReportData7.getTxId()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<UniqueTransactionIdentifier2Choice>map("getTxId", marginReportData7 -> marginReportData7.getTxId()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<UniqueTransactionIdentifier2Choice>map("getTxId", marginReportData7 -> marginReportData7.getTxId()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<UniqueTransactionIdentifier2Choice>map("getTxId", marginReportData7 -> marginReportData7.getTxId()).get();
        }
        return null;
    }

    public ReceivedMarginOrCollateral6 chooseRcvdMrgnOrColl(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<ReceivedMarginOrCollateral6>map("getRcvdMrgnOrColl", marginReportData7 -> marginReportData7.getRcvdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<ReceivedMarginOrCollateral6>map("getRcvdMrgnOrColl", marginReportData7 -> marginReportData7.getRcvdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<ReceivedMarginOrCollateral6>map("getRcvdMrgnOrColl", marginReportData7 -> marginReportData7.getRcvdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<ReceivedMarginOrCollateral6>map("getRcvdMrgnOrColl", marginReportData7 -> marginReportData7.getRcvdMrgnOrColl()).get();
        }
        return null;
    }

    public PostedMarginOrCollateral6 choosePstdMrgnOrColl(TradeReport31Choice tradeReport31Choice) {
        final MapperS<MarginReportData7> _new = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getNew", _tradeReport31Choice -> _tradeReport31Choice.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<PostedMarginOrCollateral6>map("getPstdMrgnOrColl", marginReportData7 -> marginReportData7.getPstdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> mrgnUpd = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getMrgnUpd", _tradeReport31Choice -> _tradeReport31Choice.getMrgnUpd());
        if (exists(mrgnUpd).getOrDefault(false)) {
            return mrgnUpd.<PostedMarginOrCollateral6>map("getPstdMrgnOrColl", marginReportData7 -> marginReportData7.getPstdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> err = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getErr", _tradeReport31Choice -> _tradeReport31Choice.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<PostedMarginOrCollateral6>map("getPstdMrgnOrColl", marginReportData7 -> marginReportData7.getPstdMrgnOrColl()).get();
        }
        final MapperS<MarginReportData7> crrctn = MapperS.of(tradeReport31Choice).<MarginReportData7>map("getCrrctn", _tradeReport31Choice -> _tradeReport31Choice.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<PostedMarginOrCollateral6>map("getPstdMrgnOrColl", marginReportData7 -> marginReportData7.getPstdMrgnOrColl()).get();
        }
        return null;
    }

}
