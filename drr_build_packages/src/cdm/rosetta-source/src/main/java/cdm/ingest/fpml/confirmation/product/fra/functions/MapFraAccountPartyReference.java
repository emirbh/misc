package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.Fra;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraAccountPartyReference.MapFraAccountPartyReferenceDefault.class)
public abstract class MapFraAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlFra 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(Fra fpmlFra, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlFra, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Fra fpmlFra, Account fpmlAccount);

	public static class MapFraAccountPartyReferenceDefault extends MapFraAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Fra fpmlFra, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlFra, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, Fra fpmlFra, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlFra).<AccountReference>map("getBuyerAccountReference", fra -> fra.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlFra).<AccountReference>map("getSellerAccountReference", fra -> fra.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
