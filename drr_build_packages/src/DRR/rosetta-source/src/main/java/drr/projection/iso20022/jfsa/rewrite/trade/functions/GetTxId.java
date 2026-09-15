package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.GenericIdentification175__1;
import iso20022.auth030.jfsa.UniqueTransactionIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetTxId.GetTxIdDefault.class)
public abstract class GetTxId implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return txId 
	*/
	public UniqueTransactionIdentifier2Choice__1 evaluate(JFSATransactionReport drrReport) {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txIdBuilder = doEvaluate(drrReport);
		
		final UniqueTransactionIdentifier2Choice__1 txId;
		if (txIdBuilder == null) {
			txId = null;
		} else {
			txId = txIdBuilder.build();
			objectValidator.validate(UniqueTransactionIdentifier2Choice__1.class, txId);
		}
		
		return txId;
	}

	protected abstract UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetTxIdDefault extends GetTxId {
		@Override
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId = UniqueTransactionIdentifier2Choice__1.builder();
			return assignOutput(txId, drrReport);
		}
		
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder assignOutput(UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId, JFSATransactionReport drrReport) {
			txId = toBuilder(UniqueTransactionIdentifier2Choice__1.builder()
				.setUnqTxIdr(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifier", jFSATransactionReport -> jFSATransactionReport.getUniqueTransactionIdentifier()).get())
				.setPrtry(GenericIdentification175__1.builder()
					.setId(MapperS.of(drrReport).<String>map("getUniqueTransactionIdentifierProprietary", jFSATransactionReport -> jFSATransactionReport.getUniqueTransactionIdentifierProprietary()).get())
					.build())
				.build());
			
			return Optional.ofNullable(txId)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
