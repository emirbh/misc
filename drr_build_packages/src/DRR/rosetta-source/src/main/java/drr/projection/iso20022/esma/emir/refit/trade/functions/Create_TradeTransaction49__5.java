package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.TradeTransaction49__5;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction49__5.Create_TradeTransaction49__5Default.class)
public abstract class Create_TradeTransaction49__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCmmdty getCmmdty;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt5 getDerivEvt5;
	@Inject protected GetDlvryTp getDlvryTp;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate getIntrstRate;
	@Inject protected GetMstrAgrmt getMstrAgrmt;
	@Inject protected GetNrgySpcfcAttrbts getNrgySpcfcAttrbts;
	@Inject protected GetNtnlAmt getNtnlAmt;
	@Inject protected GetNtnlQty2 getNtnlQty2;
	@Inject protected GetOptn getOptn;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetPrrTxId getPrrTxId;
	@Inject protected GetPstTradRskRdctnEvt getPstTradRskRdctnEvt;
	@Inject protected GetPstTradRskRdctnFlg getPstTradRskRdctnFlg;
	@Inject protected GetRptTrckgNb getRptTrckgNb;
	@Inject protected GetSttlmDt getSttlmDt;
	@Inject protected GetTradClr getTradClr;
	@Inject protected GetTradConf getTradConf;
	@Inject protected GetTxPric getTxPric;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction49__5 evaluate(ESMAEMIRTransactionReport drrReport) {
		TradeTransaction49__5.TradeTransaction49__5Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction49__5 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction49__5.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction49__5.TradeTransaction49__5Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_TradeTransaction49__5Default extends Create_TradeTransaction49__5 {
		@Override
		protected TradeTransaction49__5.TradeTransaction49__5Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			TradeTransaction49__5.TradeTransaction49__5Builder txData = TradeTransaction49__5.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction49__5.TradeTransaction49__5Builder assignOutput(TradeTransaction49__5.TradeTransaction49__5Builder txData, ESMAEMIRTransactionReport drrReport) {
			txData = toBuilder(TradeTransaction49__5.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUniqueTransactionIdentifier()).get())
					.build())
				.setSbsqntTxId(null)
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setRptTrckgNb(getRptTrckgNb.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt.evaluate(drrReport))
				.setNtnlQty(getNtnlQty2.evaluate(drrReport))
				.setDlvryTp(getDlvryTp.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setSttlmDt(getSttlmDt.evaluate(drrReport))
				.setMstrAgrmt(getMstrAgrmt.evaluate(drrReport))
				.setPstTradRskRdctnFlg(getPstTradRskRdctnFlg.evaluate(drrReport))
				.setPstTradRskRdctnEvt(getPstTradRskRdctnEvt.evaluate(drrReport))
				.setDerivEvt(getDerivEvt5.evaluate(drrReport))
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
