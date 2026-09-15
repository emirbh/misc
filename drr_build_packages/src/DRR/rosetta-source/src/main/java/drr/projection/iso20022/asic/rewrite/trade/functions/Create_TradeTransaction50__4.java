package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.TradeTransaction50__4;
import iso20022.auth030.asic.UniqueTransactionIdentifier2Choice__1;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__4.Create_TradeTransaction50__4Default.class)
public abstract class Create_TradeTransaction50__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt1 getDerivEvt1;
	@Inject protected GetExctnTmStmp getExctnTmStmp;
	@Inject protected GetOthrPmt getOthrPmt;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__4 evaluate(ASICTransactionReport drrReport) {
		TradeTransaction50__4.TradeTransaction50__4Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__4 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__4.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeTransaction50__4Default extends Create_TradeTransaction50__4 {
		@Override
		protected TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeTransaction50__4.TradeTransaction50__4Builder txData = TradeTransaction50__4.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__4.TradeTransaction50__4Builder assignOutput(TradeTransaction50__4.TradeTransaction50__4Builder txData, ASICTransactionReport drrReport) {
			String ifThenElseResult = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			txData = toBuilder(TradeTransaction50__4.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult)
						.build())
					.build())
				.setExctnTmStmp(getExctnTmStmp.evaluate(drrReport))
				.setDerivEvt(getDerivEvt1.evaluate(drrReport))
				.setScndryTxId(MapperS.of(drrReport).<String>map("getSecondaryTransactionIdentifier", aSICTransactionReport -> aSICTransactionReport.getSecondaryTransactionIdentifier()).get())
				.setOthrPmt(new ArrayList(getOthrPmt.evaluate(drrReport)))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
