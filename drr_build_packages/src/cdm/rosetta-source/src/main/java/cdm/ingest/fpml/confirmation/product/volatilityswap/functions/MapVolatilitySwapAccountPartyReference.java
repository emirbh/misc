package cdm.ingest.fpml.confirmation.product.volatilityswap.functions;

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
import fpml.consolidated.volatility.swaps.VolatilitySwap;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVolatilitySwapAccountPartyReference.MapVolatilitySwapAccountPartyReferenceDefault.class)
public abstract class MapVolatilitySwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlVolatilitySwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(VolatilitySwap fpmlVolatilitySwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlVolatilitySwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, Account fpmlAccount);

	public static class MapVolatilitySwapAccountPartyReferenceDefault extends MapVolatilitySwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VolatilitySwap fpmlVolatilitySwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlVolatilitySwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, VolatilitySwap fpmlVolatilitySwap, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlVolatilitySwap).<VolatilityLeg>mapC("getVolatilityLeg", volatilitySwap -> volatilitySwap.getVolatilityLeg())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", volatilityLeg -> volatilityLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", volatilityLeg -> volatilityLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", volatilityLeg -> volatilityLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", volatilityLeg -> volatilityLeg.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
