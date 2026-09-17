package cdm.ingest.fpml.confirmation.product.fxvolatilityswap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.fx.FxVolatilitySwap;
import fpml.consolidated.shared.Account;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxVolatilitySwapAccountPartyReference.MapFxVolatilitySwapAccountPartyReferenceDefault.class)
public abstract class MapFxVolatilitySwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlFxVolatilitySwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(FxVolatilitySwap fpmlFxVolatilitySwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlFxVolatilitySwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, Account fpmlAccount);

	public static class MapFxVolatilitySwapAccountPartyReferenceDefault extends MapFxVolatilitySwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxVolatilitySwap fpmlFxVolatilitySwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlFxVolatilitySwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, FxVolatilitySwap fpmlFxVolatilitySwap, Account fpmlAccount) {
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
