package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.Counterparty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.PartyReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBuyerSeller.MapBuyerSellerDefault.class)
public abstract class MapBuyerSeller implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlBuyerPartyReference 
	* @param fpmlSellerPartyReference 
	* @param cdmCounterpartyList 
	* @return buyerSeller 
	*/
	public BuyerSeller evaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		BuyerSeller.BuyerSellerBuilder buyerSellerBuilder = doEvaluate(fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList);
		
		final BuyerSeller buyerSeller;
		if (buyerSellerBuilder == null) {
			buyerSeller = null;
		} else {
			buyerSeller = buyerSellerBuilder.build();
			objectValidator.validate(BuyerSeller.class, buyerSeller);
		}
		
		return buyerSeller;
	}

	protected abstract BuyerSeller.BuyerSellerBuilder doEvaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapBuyerSellerDefault extends MapBuyerSeller {
		@Override
		protected BuyerSeller.BuyerSellerBuilder doEvaluate(PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			BuyerSeller.BuyerSellerBuilder buyerSeller = BuyerSeller.builder();
			return assignOutput(buyerSeller, fpmlBuyerPartyReference, fpmlSellerPartyReference, cdmCounterpartyList);
		}
		
		protected BuyerSeller.BuyerSellerBuilder assignOutput(BuyerSeller.BuyerSellerBuilder buyerSeller, PartyReference fpmlBuyerPartyReference, PartyReference fpmlSellerPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			buyerSeller = toBuilder(BuyerSeller.builder()
				.setBuyer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlBuyerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setSeller(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlSellerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(buyerSeller)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
