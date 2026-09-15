package cdm.ingest.fpml.confirmation.product.varianceswaptransactionsupplement.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.variance.swaps.VarianceLeg;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapTransactionSupplementAccountPartyReference.MapVarianceSwapTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapVarianceSwapTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlVarianceSwapTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlVarianceSwapTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, Account fpmlAccount);

	public static class MapVarianceSwapTransactionSupplementAccountPartyReferenceDefault extends MapVarianceSwapTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlVarianceSwapTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, VarianceSwapTransactionSupplement fpmlVarianceSwapTransactionSupplement, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlVarianceSwapTransactionSupplement).<VarianceLeg>mapC("getVarianceLeg", varianceSwapTransactionSupplement -> varianceSwapTransactionSupplement.getVarianceLeg())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", varianceLeg -> varianceLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", varianceLeg -> varianceLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", varianceLeg -> varianceLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", varianceLeg -> varianceLeg.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
