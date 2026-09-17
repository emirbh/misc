package cdm.ingest.fpml.confirmation.product.dividendswaptransactionsupplement.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.dividend.swaps.DividendLeg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendSwapTransactionSupplementAccountPartyReference.MapDividendSwapTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapDividendSwapTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlDividendSwapTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlDividendSwapTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, Account fpmlAccount);

	public static class MapDividendSwapTransactionSupplementAccountPartyReferenceDefault extends MapDividendSwapTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlDividendSwapTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, DividendSwapTransactionSupplement fpmlDividendSwapTransactionSupplement, Account fpmlAccount) {
			partyReference = toBuilder(MapperS.of(fpmlDividendSwapTransactionSupplement).<DividendLeg>map("getDividendLeg", dividendSwapTransactionSupplement -> dividendSwapTransactionSupplement.getDividendLeg())
				.mapSingleToItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", dividendLeg -> dividendLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", dividendLeg -> dividendLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", dividendLeg -> dividendLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", dividendLeg -> dividendLeg.getReceiverPartyReference()).get()))).get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
