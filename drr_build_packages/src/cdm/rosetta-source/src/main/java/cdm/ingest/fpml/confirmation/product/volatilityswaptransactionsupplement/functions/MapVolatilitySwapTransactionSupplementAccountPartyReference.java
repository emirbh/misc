package cdm.ingest.fpml.confirmation.product.volatilityswaptransactionsupplement.functions;

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
import fpml.consolidated.volatility.swaps.VolatilityLeg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapTransactionSupplementAccountPartyReference.MapVolatilitySwapTransactionSupplementAccountPartyReferenceDefault.class)
public abstract class MapVolatilitySwapTransactionSupplementAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlVolatilitySwapTransactionSupplement 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlVolatilitySwapTransactionSupplement, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, Account fpmlAccount);

	public static class MapVolatilitySwapTransactionSupplementAccountPartyReferenceDefault extends MapVolatilitySwapTransactionSupplementAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlVolatilitySwapTransactionSupplement, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, VolatilitySwapTransactionSupplement fpmlVolatilitySwapTransactionSupplement, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlVolatilitySwapTransactionSupplement).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwapTransactionSupplement -> volatilitySwapTransactionSupplement.getVolatilityLeg())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", volatilityLeg -> volatilityLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", volatilityLeg -> volatilityLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", volatilityLeg -> volatilityLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", volatilityLeg -> volatilityLeg.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
