package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustableDate2ToAdjustableOrRelativeDate;
import cdm.ingest.fpml.confirmation.datetime.functions.MapBusinessDayAdjustments;
import cdm.product.template.EconomicTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.doc.TradeHeader;
import fpml.consolidated.shared.AdjustableDate2;
import fpml.consolidated.shared.BusinessDayAdjustments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapEconomicTerms.MapCreditDefaultSwapEconomicTermsDefault.class)
public abstract class MapCreditDefaultSwapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate2ToAdjustableOrRelativeDate mapAdjustableDate2ToAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCreditDefaultSwapPayoutList mapCreditDefaultSwapPayoutList;

	/**
	* @param fpmlCreditDefaultSwap 
	* @param fpmlTradeHeader 
	* @param cdmCounterpartyList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlCreditDefaultSwap, fpmlTradeHeader, cdmCounterpartyList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapCreditDefaultSwapEconomicTermsDefault extends MapCreditDefaultSwapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlCreditDefaultSwap, fpmlTradeHeader, cdmCounterpartyList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, CreditDefaultSwap fpmlCreditDefaultSwap, TradeHeader fpmlTradeHeader, List<? extends Counterparty> cdmCounterpartyList) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableDate2ToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<AdjustableDate2>map("getEffectiveDate", generalTerms -> generalTerms.getEffectiveDate()).get()))
				.setTerminationDate(mapAdjustableDate2ToAdjustableOrRelativeDate.evaluate(MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<AdjustableDate2>map("getScheduledTerminationDate", generalTerms -> generalTerms.getScheduledTerminationDate()).get()))
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<BusinessDayAdjustments>map("getDateAdjustments", generalTerms -> generalTerms.getDateAdjustments()).get()))
				.setPayout(new ArrayList(mapCreditDefaultSwapPayoutList.evaluate(fpmlCreditDefaultSwap, cdmCounterpartyList)))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
