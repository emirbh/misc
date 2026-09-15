package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.TradeTransaction49__7;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__7.Create_TradeTransaction49__7Default.class)
public abstract class Create_TradeTransaction49__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCmmdty getCmmdty;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt3 getDerivEvt3;
	@Inject protected GetDlvryTp getDlvryTp;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate getIntrstRate;
	@Inject protected GetMstrAgrmt getMstrAgrmt;
	@Inject protected GetNrgySpcfcAttrbts getNrgySpcfcAttrbts;
	@Inject protected GetNtnlAmt getNtnlAmt;
	@Inject protected GetNtnlQty getNtnlQty;
	@Inject protected GetOptn getOptn;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetPrrTxId getPrrTxId;
	@Inject protected GetPstTradRskRdctnEvt getPstTradRskRdctnEvt;
	@Inject protected GetPstTradRskRdctnFlg getPstTradRskRdctnFlg;
	@Inject protected GetRptTrckgNb getRptTrckgNb;
	@Inject protected GetSbsqntTxId getSbsqntTxId;
	@Inject protected GetSttlmDt getSttlmDt;
	@Inject protected GetTradClr getTradClr;
	@Inject protected GetTradConf getTradConf;
	@Inject protected GetTxId getTxId;
	@Inject protected GetTxPric getTxPric;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__7 evaluate(FCAUKEMIRTransactionReport drrReport) {
		TradeTransaction49__7.TradeTransaction49__7Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__7 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__7.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__7.TradeTransaction49__7Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_TradeTransaction49__7Default extends Create_TradeTransaction49__7 {
		@Override
		protected TradeTransaction49__7.TradeTransaction49__7Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			TradeTransaction49__7.TradeTransaction49__7Builder txData = TradeTransaction49__7.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__7.TradeTransaction49__7Builder assignOutput(TradeTransaction49__7.TradeTransaction49__7Builder txData, FCAUKEMIRTransactionReport drrReport) {
			txData = toBuilder(TradeTransaction49__7.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setSbsqntTxId(getSbsqntTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setRptTrckgNb(getRptTrckgNb.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt.evaluate(drrReport))
				.setNtnlQty(getNtnlQty.evaluate(drrReport))
				.setDlvryTp(getDlvryTp.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setEarlyTermntnDt(MapperS.of(drrReport).<Date>map("getEarlyTerminationDate", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getEarlyTerminationDate()).get())
				.setSttlmDt(getSttlmDt.evaluate(drrReport))
				.setMstrAgrmt(getMstrAgrmt.evaluate(drrReport))
				.setPstTradRskRdctnFlg(getPstTradRskRdctnFlg.evaluate(drrReport))
				.setPstTradRskRdctnEvt(getPstTradRskRdctnEvt.evaluate(drrReport))
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.setTradConf(getTradConf.evaluate(drrReport))
				.setTradClr(getTradClr.evaluate(drrReport))
				.setIntrstRate(getIntrstRate.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setCmmdty(getCmmdty.evaluate(drrReport))
				.setOptn(getOptn.evaluate(drrReport))
				.setNrgySpcfcAttrbts(getNrgySpcfcAttrbts.evaluate(drrReport))
				.setCdt(getCdt.evaluate(drrReport))
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.setPackg(getPackg.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
