package cdm.ingest.fpml.confirmation.product.swap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.ird.Swap;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSwapAccountPartyReference.MapSwapAccountPartyReferenceDefault.class)
public abstract class MapSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(Swap fpmlSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Swap fpmlSwap, Account fpmlAccount);

	public static class MapSwapAccountPartyReferenceDefault extends MapSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(Swap fpmlSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, Swap fpmlSwap, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlSwap).<InterestRateStream>mapC("getSwapStream", swap -> swap.getSwapStream())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", interestRateStream -> interestRateStream.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", interestRateStream -> interestRateStream.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", interestRateStream -> interestRateStream.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", interestRateStream -> interestRateStream.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
