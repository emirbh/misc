package cdm.ingest.fpml.confirmation.product.commodityoption.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.com.CommodityOption;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityOptionEconomicTerms.MapCommodityOptionEconomicTermsDefault.class)
public abstract class MapCommodityOptionEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapCommodityOptionPayout mapCommodityOptionPayout;

	/**
	* @param fpmlCommodityOption 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCommodityOption, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommodityOptionEconomicTermsDefault extends MapCommodityOptionEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCommodityOption, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, CommodityOption fpmlCommodityOption, List<? extends Counterparty> cdmCounterpartyList) {
			final Payout payout = mapCommodityOptionPayout.evaluate(fpmlCommodityOption, cdmCounterpartyList);
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCommodityOption).<AdjustableOrRelativeDate>map("getEffectiveDate", commodityOption -> commodityOption.getEffectiveDate()).get()))
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCommodityOption).<AdjustableOrRelativeDate>map("getTerminationDate", commodityOption -> commodityOption.getTerminationDate()).get()))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
