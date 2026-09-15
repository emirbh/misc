package cdm.ingest.fpml.confirmation.product.commodityswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableOrRelativeDate;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityLeg;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.IdentifiedCurrency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommoditySwapEconomicTerms.MapCommoditySwapEconomicTermsDefault.class)
public abstract class MapCommoditySwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapCommoditySwapLegListToPayoutList mapCommoditySwapLegListToPayoutList;

	/**
	* @param fpmlCommoditySwapLegList 
	* @param fpmlSettlementCurrency 
	* @param fpmlEffectiveDate 
	* @param fpmlTerminationDate 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCommoditySwapLegList, fpmlSettlementCurrency, fpmlEffectiveDate, fpmlTerminationDate, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCommoditySwapEconomicTermsDefault extends MapCommoditySwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
			if (fpmlCommoditySwapLegList == null) {
				fpmlCommoditySwapLegList = Collections.emptyList();
			}
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCommoditySwapLegList, fpmlSettlementCurrency, fpmlEffectiveDate, fpmlTerminationDate, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, List<? extends CommodityLeg> fpmlCommoditySwapLegList, IdentifiedCurrency fpmlSettlementCurrency, AdjustableOrRelativeDate fpmlEffectiveDate, AdjustableOrRelativeDate fpmlTerminationDate, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(fpmlEffectiveDate))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(fpmlTerminationDate))
				.setPayout(new ArrayList(mapCommoditySwapLegListToPayoutList.evaluate(fpmlCommoditySwapLegList, fpmlSettlementCurrency, cdmCounterpartyList)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
