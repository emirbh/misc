package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.TradeTransaction50__6;
import iso20022.auth030.asic.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__6.Create_TradeTransaction50__6Default.class)
public abstract class Create_TradeTransaction50__6 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt4 getDerivEvt4;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__6 evaluate(ASICTransactionReport drrReport) {
		TradeTransaction50__6.TradeTransaction50__6Builder txDataBuilder = doEvaluate(drrReport);
		
		final TradeTransaction50__6 txData;
		if (txDataBuilder == null) {
			txData = null;
		} else {
			txData = txDataBuilder.build();
			objectValidator.validate(TradeTransaction50__6.class, txData);
		}
		
		return txData;
	}

	protected abstract TradeTransaction50__6.TradeTransaction50__6Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_TradeTransaction50__6Default extends Create_TradeTransaction50__6 {
		@Override
		protected TradeTransaction50__6.TradeTransaction50__6Builder doEvaluate(ASICTransactionReport drrReport) {
			TradeTransaction50__6.TradeTransaction50__6Builder txData = TradeTransaction50__6.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__6.TradeTransaction50__6Builder assignOutput(TradeTransaction50__6.TradeTransaction50__6Builder txData, ASICTransactionReport drrReport) {
			String ifThenElseResult = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICTransactionReport -> aSICTransactionReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			txData = toBuilder(TradeTransaction50__6.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult)
						.build())
					.build())
				.setDerivEvt(getDerivEvt4.evaluate(drrReport))
				.setScndryTxId(MapperS.of(drrReport).<String>map("getSecondaryTransactionIdentifier", aSICTransactionReport -> aSICTransactionReport.getSecondaryTransactionIdentifier()).get())
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
