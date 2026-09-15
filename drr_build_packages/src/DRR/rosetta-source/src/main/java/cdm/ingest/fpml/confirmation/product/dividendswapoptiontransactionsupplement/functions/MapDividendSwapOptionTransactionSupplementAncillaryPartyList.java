package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.AncillaryParty;
import cdm.base.staticdata.party.Counterparty;
import cdm.ingest.fpml.confirmation.party.functions.MapSwaptionPhysicalSettlementToAncillaryParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.shared.SwaptionPhysicalSettlement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementAncillaryPartyList.MapDividendSwapOptionTransactionSupplementAncillaryPartyListDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementAncillaryPartyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapSwaptionPhysicalSettlementToAncillaryParty mapSwaptionPhysicalSettlementToAncillaryParty;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @param cdmCounterpartyList 
	* @return ancillaryPartyList 
	*/
	public List<? extends AncillaryParty> evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
		List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyListBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		
		final List<? extends AncillaryParty> ancillaryPartyList;
		if (ancillaryPartyListBuilder == null) {
			ancillaryPartyList = null;
		} else {
			ancillaryPartyList = ancillaryPartyListBuilder.stream().map(AncillaryParty::build).collect(Collectors.toList());
			objectValidator.validate(AncillaryParty.class, ancillaryPartyList);
		}
		
		return ancillaryPartyList;
	}

	protected abstract List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapDividendSwapOptionTransactionSupplementAncillaryPartyListDefault extends MapDividendSwapOptionTransactionSupplementAncillaryPartyList {
		@Override
		protected List<AncillaryParty.AncillaryPartyBuilder> doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList = new ArrayList<>();
			return assignOutput(ancillaryPartyList, fpmlDividendSwapOptionTransactionSupplement, cdmCounterpartyList);
		}
		
		protected List<AncillaryParty.AncillaryPartyBuilder> assignOutput(List<AncillaryParty.AncillaryPartyBuilder> ancillaryPartyList, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, List<? extends Counterparty> cdmCounterpartyList) {
			final AncillaryParty ancillaryParty = mapSwaptionPhysicalSettlementToAncillaryParty.evaluate(MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<SwaptionPhysicalSettlement>map("getClearingInstructions", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getClearingInstructions()).get());
			if (ancillaryParty == null) {
				ancillaryPartyList.addAll(toBuilder(Collections.<AncillaryParty>emptyList()));
			} else {
				ancillaryPartyList.addAll(toBuilder(Collections.singletonList(ancillaryParty)));
			}
			
			return Optional.ofNullable(ancillaryPartyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
