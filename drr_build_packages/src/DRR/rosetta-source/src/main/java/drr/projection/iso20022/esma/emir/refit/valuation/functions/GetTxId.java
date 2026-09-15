package drr.projection.iso20022.esma.emir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import iso20022.auth030.esma.GenericIdentification175__2;
import iso20022.auth030.esma.UniqueTransactionIdentifier2Choice__2;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return txId 
	*/
	public UniqueTransactionIdentifier2Choice__2 evaluate(ESMAValuationReport drrReport) {
		UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txIdBuilder = doEvaluate(drrReport);
		
		final UniqueTransactionIdentifier2Choice__2 txId;
		if (txIdBuilder == null) {
			txId = null;
		} else {
			txId = txIdBuilder.build();
			objectValidator.validate(UniqueTransactionIdentifier2Choice__2.class, txId);
		}
		
		return txId;
	}

	protected abstract UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder doEvaluate(ESMAValuationReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder doEvaluate(ESMAValuationReport drrReport) {
			UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId = UniqueTransactionIdentifier2Choice__2.builder();
			return assignOutput(txId, drrReport);
		}
		
		protected UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder assignOutput(UniqueTransactionIdentifier2Choice__2.UniqueTransactionIdentifier2Choice__2Builder txId, ESMAValuationReport drrReport) {
			txId = toBuilder(UniqueTransactionIdentifier2Choice__2.builder()
				.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", eSMAValuationReport -> eSMAValuationReport.getUniqueTransactionIdentifier()).get())
				.setPrtry(GenericIdentification175__2.builder()
					.setId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", eSMAValuationReport -> eSMAValuationReport.getUniqueTransactionIdentifierProprietary()).get())
					.build())
				.build());
			
			return Optional.ofNullable(txId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
