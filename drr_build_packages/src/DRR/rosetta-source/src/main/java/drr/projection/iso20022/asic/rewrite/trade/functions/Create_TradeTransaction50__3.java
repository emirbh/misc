package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.TradeTransaction50__3;
import iso20022.auth030.asic.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__3.Create_TradeTransaction50__3Default.class)
public abstract class Create_TradeTransaction50__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetCcy getCcy;
	@Inject protected GetCdt getCdt;
	@Inject protected GetCollPrtflCd getCollPrtflCd;
	@Inject protected GetDerivEvt3 getDerivEvt3;
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
	@Inject protected GetTradClr getTradClr;
	@Inject protected GetTxId getTxId;
	@Inject protected GetTxPric getTxPric;
	@Inject protected GetXprtnDt getXprtnDt;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__3 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract TradeTransaction50__3.TradeTransaction50__3Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeTransaction50__3Default extends Create_TradeTransaction50__3 {
		@Override
		protected TradeTransaction50__3.TradeTransaction50__3Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeTransaction50__3.TradeTransaction50__3Builder txData = TradeTransaction50__3.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__3.TradeTransaction50__3Builder assignOutput(TradeTransaction50__3.TradeTransaction50__3Builder txData, ASICTransactionReport drrReport) {
			String ifThenElseResult = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			txData = toBuilder(TradeTransaction50__3.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult)
						.build())
					.build())
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setDerivEvt(getDerivEvt3.evaluate(drrReport))
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.setCollPrtflCd(getCollPrtflCd.evaluate(drrReport))
				.setNtnlAmt(getNtnlAmt.evaluate(drrReport))
				.setTradClr(getTradClr.evaluate(drrReport))
				.setPrrTxId(getPrrTxId.evaluate(drrReport))
				.setPltfmIdr(getPltfmIdr.evaluate(drrReport))
				.setTxPric(getTxPric.evaluate(drrReport))
				.setNtnlQty(getNtnlQty.evaluate(drrReport))
				.setFctvDt(getFctvDt.evaluate(drrReport))
				.setXprtnDt(getXprtnDt.evaluate(drrReport))
				.setIntrstRate(getIntrstRate.evaluate(drrReport))
				.setCcy(getCcy.evaluate(drrReport))
				.setOptn(getOptn.evaluate(drrReport))
				.setCdt(getCdt.evaluate(drrReport))
				.setPackg(getPackg.evaluate(drrReport))
				.setScndryTxId(MapperS.of(drrReport).<String>map("getSecondaryTransactionIdentifier", aSICTransactionReport -> aSICTransactionReport.getSecondaryTransactionIdentifier()).get())
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
