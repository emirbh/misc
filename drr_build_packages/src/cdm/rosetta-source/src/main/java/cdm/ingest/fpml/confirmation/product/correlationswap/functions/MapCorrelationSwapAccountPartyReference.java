package cdm.ingest.fpml.confirmation.product.correlationswap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.correlation.swaps.CorrelationLeg;
import fpml.consolidated.correlation.swaps.CorrelationSwap;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorrelationSwapAccountPartyReference.MapCorrelationSwapAccountPartyReferenceDefault.class)
public abstract class MapCorrelationSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlCorrelationSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(CorrelationSwap fpmlCorrelationSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlCorrelationSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, Account fpmlAccount);

	public static class MapCorrelationSwapAccountPartyReferenceDefault extends MapCorrelationSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CorrelationSwap fpmlCorrelationSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlCorrelationSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, CorrelationSwap fpmlCorrelationSwap, Account fpmlAccount) {
			partyReference = toBuilder(MapperS.of(fpmlCorrelationSwap).<CorrelationLeg>map("getCorrelationLeg", correlationSwap -> correlationSwap.getCorrelationLeg())
				.mapSingleToItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", correlationLeg -> correlationLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", correlationLeg -> correlationLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", correlationLeg -> correlationLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", correlationLeg -> correlationLeg.getReceiverPartyReference()).get()))).get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
