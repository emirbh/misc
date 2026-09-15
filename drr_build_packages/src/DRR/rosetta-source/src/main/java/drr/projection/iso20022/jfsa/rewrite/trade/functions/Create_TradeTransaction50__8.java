package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.TradeTransaction50__8;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__8.Create_TradeTransaction50__8Default.class)
public abstract class Create_TradeTransaction50__8 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt2 getDerivEvt2;
	@Inject protected GetDlvryTp getDlvryTp;
	@Inject protected GetEarlyTermntnDt getEarlyTermntnDt;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate2 getIntrstRate2;
	@Inject protected GetNtnlAmt1 getNtnlAmt1;
	@Inject protected GetNtnlQty getNtnlQty;
	@Inject protected GetOptn1 getOptn1;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetPrrTxId getPrrTxId;
	@Inject protected GetSttlmDt getSttlmDt;
	@Inject protected GetTradClr1 getTradClr1;
	@Inject protected GetTradConf getTradConf;
	@Inject protected GetTxId getTxId;
	@Inject protected GetTxPric1 getTxPric1;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__8 evaluate(JFSATransactionReport drrReport) {
		TradeTransaction50__8.TradeTransaction50__8Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__8 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__8.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__8.TradeTransaction50__8Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_TradeTransaction50__8Default extends Create_TradeTransaction50__8 {
		@Override
		protected TradeTransaction50__8.TradeTransaction50__8Builder doEvaluate(JFSATransactionReport drrReport) {
			TradeTransaction50__8.TradeTransaction50__8Builder txData = TradeTransaction50__8.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__8.TradeTransaction50__8Builder assignOutput(TradeTransaction50__8.TradeTransaction50__8Builder txData, JFSATransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__8.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric1.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt1.evaluate(drrReport))
				.setNtnlQty(getNtnlQty.evaluate(drrReport))
				.setDlvryTp(getDlvryTp.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setEarlyTermntnDt(getEarlyTermntnDt.evaluate(drrReport))
				.setSttlmDt(getSttlmDt.evaluate(drrReport))
				.setDerivEvt(getDerivEvt2.evaluate(drrReport))
				.setTradConf(getTradConf.evaluate(drrReport))
				.setTradClr(getTradClr1.evaluate(drrReport))
				.setIntrstRate(getIntrstRate2.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setOptn(getOptn1.evaluate(drrReport))
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
