package cdm.ingest.fpml.confirmation.tradestate.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.doc.PortfolioName;
import fpml.consolidated.doc.TradeHeader;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCollateral.MapCollateralDefault.class)
public abstract class MapCollateral implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPortfolioNameToIdentifier mapPortfolioNameToIdentifier;

	/**
	* @param fpmlTradeHeader 
	* @return collateral 
	*/
	public Collateral evaluate(TradeHeader fpmlTradeHeader) {
		Collateral.CollateralBuilder collateralBuilder = doEvaluate(fpmlTradeHeader);
		
		final Collateral collateral;
		if (collateralBuilder == null) {
			collateral = null;
		} else {
			collateral = collateralBuilder.build();
			objectValidator.validate(Collateral.class, collateral);
		}
		
		return collateral;
	}

	protected abstract Collateral.CollateralBuilder doEvaluate(TradeHeader fpmlTradeHeader);

	public static class MapCollateralDefault extends MapCollateral {
		@Override
		protected Collateral.CollateralBuilder doEvaluate(TradeHeader fpmlTradeHeader) {
			Collateral.CollateralBuilder collateral = Collateral.builder();
			return assignOutput(collateral, fpmlTradeHeader);
		}
		
		protected Collateral.CollateralBuilder assignOutput(Collateral.CollateralBuilder collateral, TradeHeader fpmlTradeHeader) {
			final Identifier identifier = mapPortfolioNameToIdentifier.evaluate(MapperS.of(fpmlTradeHeader).<PartyTradeInformation>mapC("getPartyTradeInformation", tradeHeader -> tradeHeader.getPartyTradeInformation()).<PortfolioName>map("getCollateralPortfolio", partyTradeInformation -> partyTradeInformation.getCollateralPortfolio()).getMulti());
			collateral = toBuilder(Collateral.builder()
				.setPortfolioIdentifier((identifier == null ? Collections.<Identifier>emptyList() : Collections.singletonList(identifier)))
				.build());
			
			return Optional.ofNullable(collateral)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
