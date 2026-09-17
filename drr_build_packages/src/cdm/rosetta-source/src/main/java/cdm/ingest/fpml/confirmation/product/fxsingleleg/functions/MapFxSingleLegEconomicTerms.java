package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.ExchangeRate;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.FxCashSettlement;
import fpml.consolidated.shared.Payment;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSingleLegEconomicTerms.MapFxSingleLegEconomicTermsDefault.class)
public abstract class MapFxSingleLegEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapFxCoreDetailsModelToSettlementPayout mapFxCoreDetailsModelToSettlementPayout;

	/**
	* @param fpmlFxSingleLeg 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlFxSingleLeg, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxSingleLegEconomicTermsDefault extends MapFxSingleLegEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlFxSingleLeg, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, FxSingleLeg fpmlFxSingleLeg, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapFxCoreDetailsModelToSettlementPayout.evaluate(MapperS.of(fpmlFxSingleLeg).<ExchangeRate>map("getExchangeRate", fxSingleLeg -> fxSingleLeg.getExchangeRate()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency1", fxSingleLeg -> fxSingleLeg.getExchangedCurrency1()).get(), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency2", fxSingleLeg -> fxSingleLeg.getExchangedCurrency2()).get(), MapperS.of(fpmlFxSingleLeg).<FxCashSettlement>map("getNonDeliverableSettlement", fxSingleLeg -> fxSingleLeg.getNonDeliverableSettlement()).get(), MapperS.of(fpmlFxSingleLeg).<ZonedDateTime>map("getValueDate", fxSingleLeg -> fxSingleLeg.getValueDate()).get(), null, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
