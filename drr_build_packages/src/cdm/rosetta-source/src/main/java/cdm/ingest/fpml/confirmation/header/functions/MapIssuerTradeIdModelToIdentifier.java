package cdm.ingest.fpml.confirmation.header.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.TradeIdentifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.IssuerId;
import fpml.consolidated.shared.TradeId;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIssuerTradeIdModelToIdentifier.MapIssuerTradeIdModelToIdentifierDefault.class)
public abstract class MapIssuerTradeIdModelToIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;
	@Inject protected MapTradeIdToAssignedIdentifier mapTradeIdToAssignedIdentifier;
	@Inject protected MapTradeIdToIdentifierType mapTradeIdToIdentifierType;

	/**
	* @param fpmlIssuer 
	* @param fpmlTradeId 
	* @return cdmTradeIdentifier 
	*/
	public Identifier evaluate(IssuerId fpmlIssuer, TradeId fpmlTradeId) {
		Identifier.IdentifierBuilder cdmTradeIdentifierBuilder = doEvaluate(fpmlIssuer, fpmlTradeId);
		
		final Identifier cdmTradeIdentifier;
		if (cdmTradeIdentifierBuilder == null) {
			cdmTradeIdentifier = null;
		} else {
			cdmTradeIdentifier = cdmTradeIdentifierBuilder.build();
			objectValidator.validate(Identifier.class, cdmTradeIdentifier);
		}
		
		return cdmTradeIdentifier;
	}

	protected abstract Identifier.IdentifierBuilder doEvaluate(IssuerId fpmlIssuer, TradeId fpmlTradeId);

	public static class MapIssuerTradeIdModelToIdentifierDefault extends MapIssuerTradeIdModelToIdentifier {
		@Override
		protected Identifier.IdentifierBuilder doEvaluate(IssuerId fpmlIssuer, TradeId fpmlTradeId) {
			Identifier.IdentifierBuilder cdmTradeIdentifier = Identifier.builder();
			return assignOutput(cdmTradeIdentifier, fpmlIssuer, fpmlTradeId);
		}
		
		protected Identifier.IdentifierBuilder assignOutput(Identifier.IdentifierBuilder cdmTradeIdentifier, IssuerId fpmlIssuer, TradeId fpmlTradeId) {
			final AssignedIdentifier assignedIdentifier = mapTradeIdToAssignedIdentifier.evaluate(fpmlTradeId, null);
			cdmTradeIdentifier = toBuilder(TradeIdentifier.builder()
				.setIssuer(mapStringWithScheme.evaluate(MapperS.of(fpmlIssuer).<String>map("getValue", issuerId -> issuerId.getValue()).get(), MapperS.of(fpmlIssuer).<String>map("getIssuerIdScheme", issuerId -> issuerId.getIssuerIdScheme()).get()))
				.setAssignedIdentifier((assignedIdentifier == null ? Collections.<AssignedIdentifier>emptyList() : Collections.singletonList(assignedIdentifier)))
				.setIdentifierType(mapTradeIdToIdentifierType.evaluate(fpmlTradeId))
				.build());
			
			return Optional.ofNullable(cdmTradeIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
