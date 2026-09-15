package cdm.ingest.fpml.confirmation.product.fxoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxOptionEconomicTerms.MapFxOptionEconomicTermsDefault.class)
public abstract class MapFxOptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapFxOptionPayout mapFxOptionPayout;

	/**
	* @param fpmlFxOption 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlFxOption, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapFxOptionEconomicTermsDefault extends MapFxOptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlFxOption, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, FxOption fpmlFxOption, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapFxOptionPayout.evaluate(fpmlFxOption, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlFxOption).<AdjustableOrRelativeDate>map("getEffectiveDate", fxOption -> fxOption.getEffectiveDate()).get()))
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
