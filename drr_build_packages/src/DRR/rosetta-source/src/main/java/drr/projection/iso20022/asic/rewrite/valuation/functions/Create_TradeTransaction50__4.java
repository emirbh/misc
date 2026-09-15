package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.TradeTransaction50__4;
import iso20022.auth030.asic.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeTransaction50__4.Create_TradeTransaction50__4Default.class)
public abstract class Create_TradeTransaction50__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDerivEvt getDerivEvt;
	@Inject protected GetTxId getTxId;

	/**
	* @param drrReport 
	* @return txData 
	*/
	public TradeTransaction50__4 evaluate(ASICValuationReport drrReport) {
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

	protected abstract TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(ASICValuationReport drrReport);

	public static class Create_TradeTransaction50__4Default extends Create_TradeTransaction50__4 {
		@Override
		protected TradeTransaction50__4.TradeTransaction50__4Builder doEvaluate(ASICValuationReport drrReport) {
			TradeTransaction50__4.TradeTransaction50__4Builder txData = TradeTransaction50__4.builder();
			return assignOutput(txData, drrReport);
		}
		
		protected TradeTransaction50__4.TradeTransaction50__4Builder assignOutput(TradeTransaction50__4.TradeTransaction50__4Builder txData, ASICValuationReport drrReport) {
			String ifThenElseResult = null;
			if (exists(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICValuationReport -> aSICValuationReport.getUniqueTransactionIdentifierProprietary())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", aSICValuationReport -> aSICValuationReport.getUniqueTransactionIdentifierProprietary()).get();
			}
			txData = toBuilder(TradeTransaction50__4.builder()
				.setTxId(UniqueTransactionIdentifier2Choice__1.builder()
					.setUnqTxIdr(getTxId.evaluate(drrReport))
					.setPrtry(GenericIdentification175__1.builder()
						.setId(ifThenElseResult)
						.build())
					.build())
				.setExctnTmStmp(null)
				.setDerivEvt(getDerivEvt.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(txData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
