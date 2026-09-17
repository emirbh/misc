package cdm.ingest.fpml.confirmation.product.varianceswap.functions;

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
import fpml.consolidated.variance.swaps.VarianceSwap;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapVarianceSwapAccountPartyReference.MapVarianceSwapAccountPartyReferenceDefault.class)
public abstract class MapVarianceSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlVarianceSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(VarianceSwap fpmlVarianceSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlVarianceSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceSwap fpmlVarianceSwap, Account fpmlAccount);

	public static class MapVarianceSwapAccountPartyReferenceDefault extends MapVarianceSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(VarianceSwap fpmlVarianceSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlVarianceSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, VarianceSwap fpmlVarianceSwap, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlVarianceSwap).<VarianceLeg>mapC("getVarianceLeg", varianceSwap -> varianceSwap.getVarianceLeg())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", varianceLeg -> varianceLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", varianceLeg -> varianceLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", varianceLeg -> varianceLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", varianceLeg -> varianceLeg.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
