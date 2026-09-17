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


@ImplementedBy(MapPayerAsSellerAndReceiverAsBuyer.MapPayerAsSellerAndReceiverAsBuyerDefault.class)
public abstract class MapPayerAsSellerAndReceiverAsBuyer implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyRoleEnum mapCounterpartyRoleEnum;

	/**
	* @param fpmlPayerPartyReference 
	* @param fpmlReceiverPartyReference 
	* @param cdmCounterpartyList 
	* @return buyerSeller 
	*/
	public BuyerSeller evaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
		BuyerSeller.BuyerSellerBuilder buyerSellerBuilder = doEvaluate(fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		
		final BuyerSeller buyerSeller;
		if (buyerSellerBuilder == null) {
			buyerSeller = null;
		} else {
			buyerSeller = buyerSellerBuilder.build();
			objectValidator.validate(BuyerSeller.class, buyerSeller);
		}
		
		return buyerSeller;
	}

	protected abstract BuyerSeller.BuyerSellerBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList);

	public static class MapPayerAsSellerAndReceiverAsBuyerDefault extends MapPayerAsSellerAndReceiverAsBuyer {
		@Override
		protected BuyerSeller.BuyerSellerBuilder doEvaluate(PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			if (cdmCounterpartyList == null) {
				cdmCounterpartyList = Collections.emptyList();
			}
			BuyerSeller.BuyerSellerBuilder buyerSeller = BuyerSeller.builder();
			return assignOutput(buyerSeller, fpmlPayerPartyReference, fpmlReceiverPartyReference, cdmCounterpartyList);
		}
		
		protected BuyerSeller.BuyerSellerBuilder assignOutput(BuyerSeller.BuyerSellerBuilder buyerSeller, PartyReference fpmlPayerPartyReference, PartyReference fpmlReceiverPartyReference, List<? extends Counterparty> cdmCounterpartyList) {
			buyerSeller = toBuilder(BuyerSeller.builder()
				.setBuyer(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlPayerPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.setSeller(mapCounterpartyRoleEnum.evaluate(MapperS.of(fpmlReceiverPartyReference).<String>map("getHref", partyReference -> partyReference.getHref()).get(), cdmCounterpartyList))
				.build());
			
			return Optional.ofNullable(buyerSeller)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
