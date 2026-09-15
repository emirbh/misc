package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.UniqueTransactionIdentifier3Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetPrrTxId.GetPrrTxIdDefault.class)
public abstract class GetPrrTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return prrTxId 
	*/
	public UniqueTransactionIdentifier3Choice__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetPrrTxIdDefault extends GetPrrTxId {
		@Override
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder doEvaluate(ASICTransactionReport drrReport) {
			UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId = UniqueTransactionIdentifier3Choice__1.builder();
			return assignOutput(prrTxId, drrReport);
		}
		
		protected UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder assignOutput(UniqueTransactionIdentifier3Choice__1.UniqueTransactionIdentifier3Choice__1Builder prrTxId, ASICTransactionReport drrReport) {
			prrTxId = toBuilder(UniqueTransactionIdentifier3Choice__1.builder()
				.setUnqTxIdr(MapperS.of(drrReport).<String>map("getPriorUTI", aSICTransactionReport -> aSICTransactionReport.getPriorUTI()).get())
				.setPrtry(GenericIdentification175__1.builder()
					.setId(MapperS.of(drrReport).<String>map("getPriorUTIProprietary", aSICTransactionReport -> aSICTransactionReport.getPriorUTIProprietary()).get())
					.build())
				.build());
			
			return Optional.ofNullable(prrTxId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
