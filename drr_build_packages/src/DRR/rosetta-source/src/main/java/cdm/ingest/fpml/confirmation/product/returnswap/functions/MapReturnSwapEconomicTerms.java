package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.DirectionalLeg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapEconomicTerms.MapReturnSwapEconomicTermsDefault.class)
public abstract class MapReturnSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapReturnSwapLegListToPayoutList mapReturnSwapLegListToPayoutList;

	/**
	* @param fpmlReturnSwap 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(ReturnSwap fpmlReturnSwap, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlReturnSwap, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(ReturnSwap fpmlReturnSwap, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapReturnSwapEconomicTermsDefault extends MapReturnSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(ReturnSwap fpmlReturnSwap, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlReturnSwap, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, ReturnSwap fpmlReturnSwap, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg()).<AdjustableOrRelativeDate>map("getEffectiveDate", directionalLeg -> directionalLeg.getEffectiveDate())
					.first().get()))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg()).<AdjustableOrRelativeDate>map("getTerminationDate", directionalLeg -> directionalLeg.getTerminationDate())
					.first().get()))
				.setPayout(new ArrayList(mapReturnSwapLegListToPayoutList.evaluate(MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg()).getMulti(), cdmCounterpartyList)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
