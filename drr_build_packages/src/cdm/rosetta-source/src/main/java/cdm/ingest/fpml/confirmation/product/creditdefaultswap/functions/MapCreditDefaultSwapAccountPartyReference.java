package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.CreditDefaultSwap;
import fpml.consolidated.cd.GeneralTerms;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditDefaultSwapAccountPartyReference.MapCreditDefaultSwapAccountPartyReferenceDefault.class)
public abstract class MapCreditDefaultSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlCreditDefaultSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(CreditDefaultSwap fpmlCreditDefaultSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlCreditDefaultSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, Account fpmlAccount);

	public static class MapCreditDefaultSwapAccountPartyReferenceDefault extends MapCreditDefaultSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CreditDefaultSwap fpmlCreditDefaultSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlCreditDefaultSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, CreditDefaultSwap fpmlCreditDefaultSwap, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<AccountReference>map("getBuyerAccountReference", generalTerms -> generalTerms.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlCreditDefaultSwap).<GeneralTerms>map("getGeneralTerms", creditDefaultSwap -> creditDefaultSwap.getGeneralTerms()).<AccountReference>map("getSellerAccountReference", generalTerms -> generalTerms.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
