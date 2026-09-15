package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.Identifier;
import cdm.ingest.fpml.confirmation.common.functions.MapStringWithScheme;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PortfolioName;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPortfolioNameToIdentifier.MapPortfolioNameToIdentifierDefault.class)
public abstract class MapPortfolioNameToIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapStringWithScheme mapStringWithScheme;

	/**
	* @param fpmlPortfolioNameList 
	* @return cdmIdentifier 
	*/
	public Identifier evaluate(List<? extends PortfolioName> fpmlPortfolioNameList) {
		Identifier.IdentifierBuilder cdmIdentifierBuilder = doEvaluate(fpmlPortfolioNameList);
		
		final Identifier cdmIdentifier;
		if (cdmIdentifierBuilder == null) {
			cdmIdentifier = null;
		} else {
			cdmIdentifier = cdmIdentifierBuilder.build();
			objectValidator.validate(Identifier.class, cdmIdentifier);
		}
		
		return cdmIdentifier;
	}

	protected abstract Identifier.IdentifierBuilder doEvaluate(List<? extends PortfolioName> fpmlPortfolioNameList);

	public static class MapPortfolioNameToIdentifierDefault extends MapPortfolioNameToIdentifier {
		@Override
		protected Identifier.IdentifierBuilder doEvaluate(List<? extends PortfolioName> fpmlPortfolioNameList) {
			if (fpmlPortfolioNameList == null) {
				fpmlPortfolioNameList = Collections.emptyList();
			}
			Identifier.IdentifierBuilder cdmIdentifier = Identifier.builder();
			return assignOutput(cdmIdentifier, fpmlPortfolioNameList);
		}
		
		protected Identifier.IdentifierBuilder assignOutput(Identifier.IdentifierBuilder cdmIdentifier, List<? extends PortfolioName> fpmlPortfolioNameList) {
			cdmIdentifier = toBuilder(Identifier.builder()
				.setAssignedIdentifier(MapperC.<PortfolioName>of(fpmlPortfolioNameList)
					.mapItem(item -> MapperS.of(AssignedIdentifier.builder()
						.setIdentifier(mapStringWithScheme.evaluate(item.<String>map("getValue", portfolioName -> portfolioName.getValue()).get(), item.<String>map("getPortfolioNameScheme", portfolioName -> portfolioName.getPortfolioNameScheme()).get()))
						.build())).getMulti())
				.build());
			
			return Optional.ofNullable(cdmIdentifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
