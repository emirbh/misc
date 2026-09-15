package drr.projection.iso20022.esma.emir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.GenericIdentification175__2;
import iso20022.auth030.esma.UniqueTransactionIdentifier3Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPrrTxId.GetPrrTxIdDefault.class)
public abstract class GetPrrTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return prrTxId 
	*/
	public UniqueTransactionIdentifier3Choice__1 evaluate(ESMAEMIRTransactionReport drrReport) {
		UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxIdBuilder = doEvaluate(drrReport);
		
		final UniqueTransactionIdentifier3Choice__1 prrTxId;
		if (prrTxIdBuilder == null) {
			prrTxId = null;
		} else {
			prrTxId = prrTxIdBuilder.build();
			objectValidator.validate(UniqueTransactionIdentifier3Choice__1.class, prrTxId);
		}
		
		return prrTxId;
	}

	protected abstract UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetPrrTxIdDefault extends GetPrrTxId {
		@Override
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId = UniqueTransactionIdentifier3Choice__1.builder();
			return assignOutput(prrTxId, drrReport);
		}
		
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder assignOutput(UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId, ESMAEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (exists(MapperS.of(drrReport).<String>map("getPriorUTI", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriorUTI())).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getPriorUTI", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriorUTI()).get();
			}
			GenericIdentification175__2 ifThenElseResult1 = null;
			if (exists(MapperS.of(drrReport).<String>map("getPriorUTIProprietary", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriorUTIProprietary())).getOrDefault(false)) {
				ifThenElseResult1 = GenericIdentification175__2.builder()
					.setId(MapperS.of(drrReport).<String>map("getPriorUTIProprietary", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriorUTIProprietary()).get())
					.build();
			}
			prrTxId = toBuilder(UniqueTransactionIdentifier3Choice__1.builder()
				.setUnqTxIdr(ifThenElseResult0)
				.setPrtry(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(prrTxId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
