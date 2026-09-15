package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.functions.IsMax52UpperCaseAlphanumericText;
import iso20022.auth030.fca.GenericIdentification175__3;
import iso20022.auth030.fca.UniqueTransactionIdentifier3Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetSbsqntTxId.GetSbsqntTxIdDefault.class)
public abstract class GetSbsqntTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsMax52UpperCaseAlphanumericText isMax52UpperCaseAlphanumericText;

	/**
	* @param drrReport 
	* @return sbsqntTxId 
	*/
	public UniqueTransactionIdentifier3Choice__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder sbsqntTxIdBuilder = doEvaluate(drrReport);
		
		final UniqueTransactionIdentifier3Choice__1 sbsqntTxId;
		if (sbsqntTxIdBuilder == null) {
			sbsqntTxId = null;
		} else {
			sbsqntTxId = sbsqntTxIdBuilder.build();
			objectValidator.validate(UniqueTransactionIdentifier3Choice__1.class, sbsqntTxId);
		}
		
		return sbsqntTxId;
	}

	protected abstract UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetSbsqntTxIdDefault extends GetSbsqntTxId {
		@Override
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder sbsqntTxId = UniqueTransactionIdentifier3Choice__1.builder();
			return assignOutput(sbsqntTxId, drrReport);
		}
		
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder assignOutput(UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder sbsqntTxId, FCAUKEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(drrReport).<String>map("getSubsequentPositionUTI", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubsequentPositionUTI()).get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getSubsequentPositionUTI", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubsequentPositionUTI()).get();
			}
			GenericIdentification175__3 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(isMax52UpperCaseAlphanumericText.evaluate(MapperS.of(drrReport).<String>map("getSubsequentPositionUTI", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubsequentPositionUTI()).get())), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = GenericIdentification175__3.builder()
					.setId(MapperS.of(drrReport).<String>map("getSubsequentPositionUTI", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getSubsequentPositionUTI()).get())
					.build();
			}
			sbsqntTxId = toBuilder(UniqueTransactionIdentifier3Choice__1.builder()
				.setUnqTxIdr(ifThenElseResult0)
				.setPrtry(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(sbsqntTxId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
