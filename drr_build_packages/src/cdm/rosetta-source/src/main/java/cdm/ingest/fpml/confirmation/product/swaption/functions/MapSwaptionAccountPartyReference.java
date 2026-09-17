package cdm.ingest.fpml.confirmation.product.swaption.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwaptionAccountPartyReference.MapSwaptionAccountPartyReferenceDefault.class)
public abstract class MapSwaptionAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlSwaption 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(Swaption fpmlSwaption, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlSwaption, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Swaption fpmlSwaption, Account fpmlAccount);

	public static class MapSwaptionAccountPartyReferenceDefault extends MapSwaptionAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Swaption fpmlSwaption, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlSwaption, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, Swaption fpmlSwaption, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlSwaption).<AccountReference>map("getBuyerAccountReference", swaption -> swaption.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlSwaption).<AccountReference>map("getSellerAccountReference", swaption -> swaption.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
