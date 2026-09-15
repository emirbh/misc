package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.TradeTransaction50__7;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__7.Create_TradeTransaction50__7Default.class)
public abstract class Create_TradeTransaction50__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt3 getDerivEvt3;
	@Inject protected GetDlvryTp getDlvryTp;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate2 getIntrstRate2;
	@Inject protected GetNtnlAmt2 getNtnlAmt2;
	@Inject protected GetNtnlQty2 getNtnlQty2;
	@Inject protected GetOptn2 getOptn2;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetSttlmDt getSttlmDt;
	@Inject protected GetTradClr2 getTradClr2;
	@Inject protected GetTradConf getTradConf;
	@Inject protected GetTxId getTxId;
	@Inject protected GetTxPric2 getTxPric2;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__7 evaluate(JFSATransactionReport drrReport) {
		TradeTransaction50__7.TradeTransaction50__7Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__7 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__7.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__7.TradeTransaction50__7Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_TradeTransaction50__7Default extends Create_TradeTransaction50__7 {
		@Override
		protected TradeTransaction50__7.TradeTransaction50__7Builder doEvaluate(JFSATransactionReport drrReport) {
			TradeTransaction50__7.TradeTransaction50__7Builder txData = TradeTransaction50__7.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__7.TradeTransaction50__7Builder assignOutput(TradeTransaction50__7.TradeTransaction50__7Builder txData, JFSATransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__7.builder()
				.setTxId(getTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric2.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt2.evaluate(drrReport))
				.setNtnlQty(getNtnlQty2.evaluate(drrReport))
				.setDlvryTp(getDlvryTp.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setSttlmDt(getSttlmDt.evaluate(drrReport))
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.setTradConf(getTradConf.evaluate(drrReport))
				.setTradClr(getTradClr2.evaluate(drrReport))
				.setIntrstRate(getIntrstRate2.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setOptn(getOptn2.evaluate(drrReport))
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
