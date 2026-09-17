package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.datetime.functions.MapAdjustable2;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.PartyTradeInformation;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.shared.AdjustableDate2;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapGenericProductEconomicTerms.MapGenericProductEconomicTermsDefault.class)
public abstract class MapGenericProductEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustable2 mapAdjustable2;
	@Inject protected MapGenericProductPayout mapGenericProductPayout;

	/**
	* @param fpmlGenericProduct 
	* @param cdmCounterpartyList 
	* @param fpmlPartyTradeInformationList 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlGenericProduct, cdmCounterpartyList, fpmlPartyTradeInformationList);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList);

	public static class MapGenericProductEconomicTermsDefault extends MapGenericProductEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			if (fpmlPartyTradeInformationList == null) {
				fpmlPartyTradeInformationList = Collections.emptyList();
			}
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlGenericProduct, cdmCounterpartyList, fpmlPartyTradeInformationList);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, GenericProduct fpmlGenericProduct, List<? extends Counterparty> cdmCounterpartyList, List<? extends PartyTradeInformation> fpmlPartyTradeInformationList) {
			final Payout payout = mapGenericProductPayout.evaluate(fpmlGenericProduct, cdmCounterpartyList);
			final MapperC<PartyTradeInformation> thenArg0 = MapperC.<PartyTradeInformation>of(fpmlPartyTradeInformationList)
				.filterItemNullSafe(item -> exists(item.<Boolean>map("getNonStandardTerms", partyTradeInformation -> partyTradeInformation.getNonStandardTerms())).get());
			final MapperC<Boolean> thenArg1 = thenArg0
				.mapItem(item -> item.<Boolean>map("getNonStandardTerms", partyTradeInformation -> partyTradeInformation.getNonStandardTerms()));
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(AdjustableOrRelativeDate.builder()
					.setAdjustableDate(mapAdjustable2.evaluate(MapperS.of(fpmlGenericProduct).<AdjustableDate2>map("getEffectiveDate", genericProduct -> genericProduct.getEffectiveDate()).get()))
					.build())
				.setTerminationDate(AdjustableOrRelativeDate.builder()
					.setAdjustableDate(mapAdjustable2.evaluate(MapperS.of(fpmlGenericProduct).<AdjustableDate2>map("getTerminationDate", genericProduct -> genericProduct.getTerminationDate()).get()))
					.build())
				.setDateAdjustments(null)
				.setPayout((payout == null ? Collections.<Payout>emptyList() : Collections.singletonList(payout)))
				.setTerminationProvision(null)
				.setNonStandardisedTerms(MapperS.of(distinct(thenArg1).get()).get())
				.setCollateral(null)
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
