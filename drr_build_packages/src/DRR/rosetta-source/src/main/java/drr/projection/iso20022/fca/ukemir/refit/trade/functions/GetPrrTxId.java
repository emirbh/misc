package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.GenericIdentification175__3;
import iso20022.auth030.fca.UniqueTransactionIdentifier3Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetPrrTxId.GetPrrTxIdDefault.class)
public abstract class GetPrrTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return prrTxId 
	*/
	public UniqueTransactionIdentifier3Choice__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
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

	protected abstract UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetPrrTxIdDefault extends GetPrrTxId {
		@Override
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId = UniqueTransactionIdentifier3Choice__1.builder();
			return assignOutput(prrTxId, drrReport);
		}
		
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder assignOutput(UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId, FCAUKEMIRTransactionReport drrReport) {
			prrTxId = toBuilder(UniqueTransactionIdentifier3Choice__1.builder()
				.setUnqTxIdr(MapperS.of(drrReport).<String>map("getPriorUTI", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPriorUTI()).get())
				.setPrtry(GenericIdentification175__3.builder()
					.setId(MapperS.of(drrReport).<String>map("getPriorUTIProprietary", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPriorUTIProprietary()).get())
					.build())
				.build());
			
			return Optional.ofNullable(prrTxId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
