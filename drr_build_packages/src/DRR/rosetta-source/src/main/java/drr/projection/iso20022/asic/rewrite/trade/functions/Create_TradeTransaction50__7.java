package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.TradeTransaction50__7;
import iso20022.auth030.asic.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__7.Create_TradeTransaction50__7Default.class)
public abstract class Create_TradeTransaction50__7 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt5 getDerivEvt5;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__7 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract TradeTransaction50__7.TradeTransaction50__7Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeTransaction50__7Default extends Create_TradeTransaction50__7 {
		@Override
		protected TradeTransaction50__7.TradeTransaction50__7Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeTransaction50__7.TradeTransaction50__7Builder txData = TradeTransaction50__7.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__7.TradeTransaction50__7Builder assignOutput(TradeTransaction50__7.TradeTransaction50__7Builder txData, ASICTransactionReport drrReport) {
			String ifThenElseResult = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			txData = toBuilder(TradeTransaction50__7.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult)
						.build())
					.build())
				.setDerivEvt(getDerivEvt5.evaluate(drrReport))
				.setScndryTxId(MapperS.of(drrReport).<String>map("getSecondaryTransactionIdentifier", aSICTransactionReport -> aSICTransactionReport.getSecondaryTransactionIdentifier()).get())
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
