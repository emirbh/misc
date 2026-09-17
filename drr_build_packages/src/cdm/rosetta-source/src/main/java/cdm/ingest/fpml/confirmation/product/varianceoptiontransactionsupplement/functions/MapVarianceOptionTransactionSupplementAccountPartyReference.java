package cdm.ingest.fpml.confirmation.product.varianceoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceOptionTransactionSupplementAccountPartyReference.MapVarianceOptionTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapVarianceOptionTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlVarianceOptionTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlVarianceOptionTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, Account fpmlAccount);

	public static class MapVarianceOptionTransactionSupplementAccountPartyReferenceDefault extends MapVarianceOptionTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlVarianceOptionTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, VarianceOptionTransactionSupplement fpmlVarianceOptionTransactionSupplement, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlVarianceOptionTransactionSupplement).<AccountReference>map("getBuyerAccountReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlVarianceOptionTransactionSupplement).<AccountReference>map("getSellerAccountReference", varianceOptionTransactionSupplement -> varianceOptionTransactionSupplement.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
