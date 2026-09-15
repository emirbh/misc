package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.TradeTransaction50__3;
import iso20022.auth030.mas.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_TradeTransaction50__3.Create_TradeTransaction50__3Default.class)
public abstract class Create_TradeTransaction50__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt3 getDerivEvt3;
	@Inject protected GetDlvryTp getDlvryTp;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetFctvDt getFctvDt;
	@Inject protected GetIntrstRate getIntrstRate;
	@Inject protected GetNtnlAmt getNtnlAmt;
	@Inject protected GetNtnlQty getNtnlQty;
	@Inject protected GetOptn getOptn;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetPackg getPackg;
	@Inject protected GetPltfmIdr getPltfmIdr;
	@Inject protected GetPrrTxId getPrrTxId;
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
	public TradeTransaction50__3 evaluate(MASTransactionReport drrReport) {
		TradeTransaction50__3.TradeTransaction50__3Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__3 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__3.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__3.TradeTransaction50__3Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_TradeTransaction50__3Default extends Create_TradeTransaction50__3 {
		@Override
		protected TradeTransaction50__3.TradeTransaction50__3Builder doEvaluate(MASTransactionReport drrReport) {
			TradeTransaction50__3.TradeTransaction50__3Builder txData = TradeTransaction50__3.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__3.TradeTransaction50__3Builder assignOutput(TradeTransaction50__3.TradeTransaction50__3Builder txData, MASTransactionReport drrReport) {
			txData = toBuilder(TradeTransaction50__3.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", mASTransactionReport -> mASTransactionReport.getUniqueTransactionIdentifierProprietary()).get())
						.build())
					.build())
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt.evaluate(drrReport))
				.setNtnlQty(getNtnlQty.evaluate(drrReport))
				.setDlvryTp(getDlvryTp.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setSttlmDt(getSttlmDt.evaluate(drrReport))
				.setTradConf(getTradConf.evaluate(drrReport))
				.setTradClr(getTradClr.evaluate(drrReport))
				.setIntrstRate(getIntrstRate.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setOptn(getOptn.evaluate(drrReport))
				.setPackg(getPackg.evaluate(drrReport))
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
