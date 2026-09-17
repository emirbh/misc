package cdm.ingest.fpml.confirmation.header.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.TradeId;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeIdToAssignedIdentifier.MapTradeIdToAssignedIdentifierDefault.class)
public abstract class MapTradeIdToAssignedIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlTradeId 
	* @param fpmlVersion 
	* @return cdmAssignedIdentifier 
	*/
	public AssignedIdentifier evaluate(TradeId fpmlTradeId, Integer fpmlVersion) {
		AssignedIdentifier.AssignedIdentifierBuilder cdmAssignedIdentifierBuilder = doEvaluate(fpmlTradeId, fpmlVersion);
		
		final AssignedIdentifier cdmAssignedIdentifier;
		if (cdmAssignedIdentifierBuilder == null) {
			cdmAssignedIdentifier = null;
		} else {
			cdmAssignedIdentifier = cdmAssignedIdentifierBuilder.build();
			objectValidator.validate(AssignedIdentifier.class, cdmAssignedIdentifier);
		}
		
		return cdmAssignedIdentifier;
	}

	protected abstract AssignedIdentifier.AssignedIdentifierBuilder doEvaluate(TradeId fpmlTradeId, Integer fpmlVersion);

	public static class MapTradeIdToAssignedIdentifierDefault extends MapTradeIdToAssignedIdentifier {
		@Override
		protected AssignedIdentifier.AssignedIdentifierBuilder doEvaluate(TradeId fpmlTradeId, Integer fpmlVersion) {
			AssignedIdentifier.AssignedIdentifierBuilder cdmAssignedIdentifier = AssignedIdentifier.builder();
			return assignOutput(cdmAssignedIdentifier, fpmlTradeId, fpmlVersion);
		}
		
		protected AssignedIdentifier.AssignedIdentifierBuilder assignOutput(AssignedIdentifier.AssignedIdentifierBuilder cdmAssignedIdentifier, TradeId fpmlTradeId, Integer fpmlVersion) {
			cdmAssignedIdentifier = toBuilder(AssignedIdentifier.builder()
				.setIdentifier(mapStringWithScheme.evaluate(MapperS.of(fpmlTradeId).<String>map("getValue", tradeId -> tradeId.getValue()).get(), MapperS.of(fpmlTradeId).<String>map("getTradeIdScheme", tradeId -> tradeId.getTradeIdScheme()).get()))
				.setVersion(fpmlVersion)
				.build());
			
			return Optional.ofNullable(cdmAssignedIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
