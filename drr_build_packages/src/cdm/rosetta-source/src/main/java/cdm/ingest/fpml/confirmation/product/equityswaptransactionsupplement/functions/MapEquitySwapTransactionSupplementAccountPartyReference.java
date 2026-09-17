package cdm.ingest.fpml.confirmation.product.equityswaptransactionsupplement.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquitySwapTransactionSupplementAccountPartyReference.MapEquitySwapTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapEquitySwapTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlEquitySwapTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlEquitySwapTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, Account fpmlAccount);

	public static class MapEquitySwapTransactionSupplementAccountPartyReferenceDefault extends MapEquitySwapTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlEquitySwapTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, EquitySwapTransactionSupplement fpmlEquitySwapTransactionSupplement, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlEquitySwapTransactionSupplement).<AccountReference>map("getBuyerAccountReference", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlEquitySwapTransactionSupplement).<AccountReference>map("getSellerAccountReference", equitySwapTransactionSupplement -> equitySwapTransactionSupplement.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
