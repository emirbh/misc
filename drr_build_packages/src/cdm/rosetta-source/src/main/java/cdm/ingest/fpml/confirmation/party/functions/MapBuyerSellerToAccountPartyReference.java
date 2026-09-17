package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBuyerSellerToAccountPartyReference.MapBuyerSellerToAccountPartyReferenceDefault.class)
public abstract class MapBuyerSellerToAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlAccountList 
	* @param fpmlBuyerAccountReferenceList 
	* @param fpmlSellerAccountReferenceList 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlAccountList, fpmlBuyerAccountReferenceList, fpmlSellerAccountReferenceList);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList);

	protected abstract MapperS<String> buyerPartyReference(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList);

	protected abstract MapperS<String> sellerPartyReference(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList);

	public static class MapBuyerSellerToAccountPartyReferenceDefault extends MapBuyerSellerToAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList) {
			if (fpmlBuyerAccountReferenceList == null) {
				fpmlBuyerAccountReferenceList = Collections.emptyList();
			}
			if (fpmlSellerAccountReferenceList == null) {
				fpmlSellerAccountReferenceList = Collections.emptyList();
			}
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlAccountList, fpmlBuyerAccountReferenceList, fpmlSellerAccountReferenceList);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList) {
			partyReference = toBuilder(ReferenceWithMetaParty.builder().setValue(null).setExternalReference(buyerPartyReference(fpmlAccountList, fpmlBuyerAccountReferenceList, fpmlSellerAccountReferenceList).getOrDefault(sellerPartyReference(fpmlAccountList, fpmlBuyerAccountReferenceList, fpmlSellerAccountReferenceList).get())).build());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<String> buyerPartyReference(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList) {
			final MapperC<AccountReference> thenArg0 = MapperC.<AccountReference>of(fpmlBuyerAccountReferenceList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getHref", accountReference -> accountReference.getHref()), MapperS.of(fpmlAccountList).<String>map("getId", account -> account.getId()), CardinalityOperator.All).get());
			final MapperC<String> thenArg1 = thenArg0
				.mapItem(item -> item.<String>map("getHref", accountReference -> accountReference.getHref()));
			return MapperS.of(distinct(thenArg1).get());
		}
		
		@Override
		protected MapperS<String> sellerPartyReference(Account fpmlAccountList, List<? extends AccountReference> fpmlBuyerAccountReferenceList, List<? extends AccountReference> fpmlSellerAccountReferenceList) {
			final MapperC<AccountReference> thenArg0 = MapperC.<AccountReference>of(fpmlSellerAccountReferenceList)
				.filterItemNullSafe(item -> areEqual(item.<String>map("getHref", accountReference -> accountReference.getHref()), MapperS.of(fpmlAccountList).<String>map("getId", account -> account.getId()), CardinalityOperator.All).get());
			final MapperC<String> thenArg1 = thenArg0
				.mapItem(item -> item.<String>map("getHref", accountReference -> accountReference.getHref()));
			return MapperS.of(distinct(thenArg1).get());
		}
	}
}
