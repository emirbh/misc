package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.product.bondoption.functions.MapBondOptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.capfloor.functions.MapCapFloorAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.commodityswaption.functions.MapCommoditySwaptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.creditdefaultswapoption.functions.MapCreditDefaultSwapOptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions.MapDividendSwapOptionTransactionSupplementAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.fxdigitaloption.functions.MapFxDigitalOptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.fxoption.functions.MapFxOptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.swap.functions.MapSwapAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.swaption.functions.MapSwaptionAncillaryPartyList;
import cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions.MapVarianceOptionTransactionSupplementAncillaryPartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.bond.option.BondOption;
import fpml.consolidated.cd.CreditDefaultSwapOption;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fx.FxDigitalOption;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.CalculationAgent;
import fpml.consolidated.shared.Product;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapAncillaryPartyList.MapAncillaryPartyListDefault.class)
public abstract class MapAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBondOptionAncillaryPartyList mapBondOptionAncillaryPartyList;
	@Inject protected MapCalculationAgentIndependentToAncillaryParty mapCalculationAgentIndependentToAncillaryParty;
	@Inject protected MapCapFloorAncillaryPartyList mapCapFloorAncillaryPartyList;
	@Inject protected MapCommoditySwaptionAncillaryPartyList mapCommoditySwaptionAncillaryPartyList;
	@Inject protected MapCreditDefaultSwapOptionAncillaryPartyList mapCreditDefaultSwapOptionAncillaryPartyList;
	@Inject protected MapDividendSwapOptionTransactionSupplementAncillaryPartyList mapDividendSwapOptionTransactionSupplementAncillaryPartyList;
	@Inject protected MapFxDigitalOptionAncillaryPartyList mapFxDigitalOptionAncillaryPartyList;
	@Inject protected MapFxOptionAncillaryPartyList mapFxOptionAncillaryPartyList;
	@Inject protected MapSwapAncillaryPartyList mapSwapAncillaryPartyList;
	@Inject protected MapSwaptionAncillaryPartyList mapSwaptionAncillaryPartyList;
	@Inject protected MapVarianceOptionTransactionSupplementAncillaryPartyList mapVarianceOptionTransactionSupplementAncillaryPartyList;

	/**
	* @param fpmlTrade 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlTrade, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapAncillaryPartyListDefault extends MapAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlTrade, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, Trade fpmlTrade, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty = mapCalculationAgentIndependentToAncillaryParty.evaluate(MapperS.of(fpmlTrade).<CalculationAgent>map("getCalculationAgent", trade -> trade.getCalculationAgent()).get());
			if (ancillaryParty == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty)));
			}
			
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else if (switchArgument instanceof BondOption) {
				final BondOption bondOption = (BondOption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapBondOptionAncillaryPartyList.evaluate(bondOption, cdmCounterpartyList)));
			} else if (switchArgument instanceof CapFloor) {
				final CapFloor capFloor = (CapFloor) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapCapFloorAncillaryPartyList.evaluate(capFloor, cdmCounterpartyList)));
			} else if (switchArgument instanceof CommoditySwaption) {
				final CommoditySwaption commoditySwaption = (CommoditySwaption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapCommoditySwaptionAncillaryPartyList.evaluate(commoditySwaption, cdmCounterpartyList)));
			} else if (switchArgument instanceof CreditDefaultSwapOption) {
				final CreditDefaultSwapOption creditDefaultSwapOption = (CreditDefaultSwapOption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapCreditDefaultSwapOptionAncillaryPartyList.evaluate(creditDefaultSwapOption, cdmCounterpartyList)));
			} else if (switchArgument instanceof DividendSwapOptionTransactionSupplement) {
				final DividendSwapOptionTransactionSupplement dividendSwapOptionTransactionSupplement = (DividendSwapOptionTransactionSupplement) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapDividendSwapOptionTransactionSupplementAncillaryPartyList.evaluate(dividendSwapOptionTransactionSupplement, cdmCounterpartyList)));
			} else if (switchArgument instanceof FxDigitalOption) {
				final FxDigitalOption fxDigitalOption = (FxDigitalOption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapFxDigitalOptionAncillaryPartyList.evaluate(fxDigitalOption, cdmCounterpartyList)));
			} else if (switchArgument instanceof FxOption) {
				final FxOption fxOption = (FxOption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapFxOptionAncillaryPartyList.evaluate(fxOption, cdmCounterpartyList)));
			} else if (switchArgument instanceof Swap) {
				final Swap swap = (Swap) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapSwapAncillaryPartyList.evaluate(swap, cdmCounterpartyList)));
			} else if (switchArgument instanceof Swaption) {
				final Swaption swaption = (Swaption) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapSwaptionAncillaryPartyList.evaluate(swaption, cdmCounterpartyList)));
			} else if (switchArgument instanceof VarianceOptionTransactionSupplement) {
				final VarianceOptionTransactionSupplement varianceOptionTransactionSupplement = (VarianceOptionTransactionSupplement) switchArgument;
				ancillaryPartyList.addAll(toBuilder(mapVarianceOptionTransactionSupplementAncillaryPartyList.evaluate(varianceOptionTransactionSupplement, cdmCounterpartyList)));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			}
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
