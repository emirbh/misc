package iso20022.auth030.hkma.dtcc.util;

import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.hkma.dtcc.SupplementaryData1;
import iso20022.auth030.hkma.dtcc.TechnicalAttributes5__1;
import iso20022.auth030.hkma.dtcc.TradeData43__1;
import iso20022.auth030.hkma.dtcc.TradeData43__2;
import iso20022.auth030.hkma.dtcc.TradeData43__3;
import iso20022.auth030.hkma.dtcc.TradeData43__4;
import iso20022.auth030.hkma.dtcc.TradeData43__5;
import iso20022.auth030.hkma.dtcc.TradeData43__6;
import iso20022.auth030.hkma.dtcc.TradeData43__7;
import iso20022.auth030.hkma.dtcc.TradeReport33Choice__1;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

public class TradeReport33Choice__1DeepPathUtil {
    public TechnicalAttributes5__1 chooseTechAttrbts(TradeReport33Choice__1 tradeReport33Choice__1) {
        final MapperS<TradeData43__1> _new = MapperS.of(tradeReport33Choice__1).<TradeData43__1>map("getNew", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__1 -> tradeData43__1.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__2> mod = MapperS.of(tradeReport33Choice__1).<TradeData43__2>map("getMod", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getMod());
        if (exists(mod).getOrDefault(false)) {
            return mod.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__2 -> tradeData43__2.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__3> crrctn = MapperS.of(tradeReport33Choice__1).<TradeData43__3>map("getCrrctn", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__3 -> tradeData43__3.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__4> termntn = MapperS.of(tradeReport33Choice__1).<TradeData43__4>map("getTermntn", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getTermntn());
        if (exists(termntn).getOrDefault(false)) {
            return termntn.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__4 -> tradeData43__4.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__5> valtnUpd = MapperS.of(tradeReport33Choice__1).<TradeData43__5>map("getValtnUpd", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getValtnUpd());
        if (exists(valtnUpd).getOrDefault(false)) {
            return valtnUpd.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__5 -> tradeData43__5.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__6> err = MapperS.of(tradeReport33Choice__1).<TradeData43__6>map("getErr", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__6 -> tradeData43__6.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__7> portOut = MapperS.of(tradeReport33Choice__1).<TradeData43__7>map("getPortOut", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getPortOut());
        if (exists(portOut).getOrDefault(false)) {
            return portOut.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__7 -> tradeData43__7.getTechAttrbts()).get();
        }
        final MapperS<TradeData43__3> rvv = MapperS.of(tradeReport33Choice__1).<TradeData43__3>map("getRvv", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getRvv());
        if (exists(rvv).getOrDefault(false)) {
            return rvv.<TechnicalAttributes5__1>map("getTechAttrbts", tradeData43__3 -> tradeData43__3.getTechAttrbts()).get();
        }
        return null;
    }

    public SupplementaryData1 chooseSplmtryData(TradeReport33Choice__1 tradeReport33Choice__1) {
        final MapperS<TradeData43__1> _new = MapperS.of(tradeReport33Choice__1).<TradeData43__1>map("getNew", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getNew());
        if (exists(_new).getOrDefault(false)) {
            return _new.<SupplementaryData1>map("getSplmtryData", tradeData43__1 -> tradeData43__1.getSplmtryData()).get();
        }
        final MapperS<TradeData43__2> mod = MapperS.of(tradeReport33Choice__1).<TradeData43__2>map("getMod", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getMod());
        if (exists(mod).getOrDefault(false)) {
            return mod.<SupplementaryData1>map("getSplmtryData", tradeData43__2 -> tradeData43__2.getSplmtryData()).get();
        }
        final MapperS<TradeData43__3> crrctn = MapperS.of(tradeReport33Choice__1).<TradeData43__3>map("getCrrctn", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getCrrctn());
        if (exists(crrctn).getOrDefault(false)) {
            return crrctn.<SupplementaryData1>map("getSplmtryData", tradeData43__3 -> tradeData43__3.getSplmtryData()).get();
        }
        final MapperS<TradeData43__4> termntn = MapperS.of(tradeReport33Choice__1).<TradeData43__4>map("getTermntn", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getTermntn());
        if (exists(termntn).getOrDefault(false)) {
            return termntn.<SupplementaryData1>map("getSplmtryData", tradeData43__4 -> tradeData43__4.getSplmtryData()).get();
        }
        final MapperS<TradeData43__5> valtnUpd = MapperS.of(tradeReport33Choice__1).<TradeData43__5>map("getValtnUpd", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getValtnUpd());
        if (exists(valtnUpd).getOrDefault(false)) {
            return valtnUpd.<SupplementaryData1>map("getSplmtryData", tradeData43__5 -> tradeData43__5.getSplmtryData()).get();
        }
        final MapperS<TradeData43__6> err = MapperS.of(tradeReport33Choice__1).<TradeData43__6>map("getErr", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getErr());
        if (exists(err).getOrDefault(false)) {
            return err.<SupplementaryData1>map("getSplmtryData", tradeData43__6 -> tradeData43__6.getSplmtryData()).get();
        }
        final MapperS<TradeData43__7> portOut = MapperS.of(tradeReport33Choice__1).<TradeData43__7>map("getPortOut", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getPortOut());
        if (exists(portOut).getOrDefault(false)) {
            return portOut.<SupplementaryData1>map("getSplmtryData", tradeData43__7 -> tradeData43__7.getSplmtryData()).get();
        }
        final MapperS<TradeData43__3> rvv = MapperS.of(tradeReport33Choice__1).<TradeData43__3>map("getRvv", _tradeReport33Choice__1 -> _tradeReport33Choice__1.getRvv());
        if (exists(rvv).getOrDefault(false)) {
            return rvv.<SupplementaryData1>map("getSplmtryData", tradeData43__3 -> tradeData43__3.getSplmtryData()).get();
        }
        return null;
    }

}
