package cdm.ingest.fpml.confirmation.product.dividendswapoptiontransactionsupplement.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapOptionTransactionSupplementAccountPartyReference.MapDividendSwapOptionTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapDividendSwapOptionTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlDividendSwapOptionTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlDividendSwapOptionTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, Account fpmlAccount);

	public static class MapDividendSwapOptionTransactionSupplementAccountPartyReferenceDefault extends MapDividendSwapOptionTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlDividendSwapOptionTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, DividendSwapOptionTransactionSupplement fpmlDividendSwapOptionTransactionSupplement, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<AccountReference>map("getBuyerAccountReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlDividendSwapOptionTransactionSupplement).<AccountReference>map("getSellerAccountReference", dividendSwapOptionTransactionSupplement -> dividendSwapOptionTransactionSupplement.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
