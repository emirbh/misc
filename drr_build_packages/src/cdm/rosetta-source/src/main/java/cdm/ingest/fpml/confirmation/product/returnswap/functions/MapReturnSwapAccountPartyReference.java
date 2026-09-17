package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReturnSwapAccountPartyReference.MapReturnSwapAccountPartyReferenceDefault.class)
public abstract class MapReturnSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlReturnSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(ReturnSwap fpmlReturnSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlReturnSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(ReturnSwap fpmlReturnSwap, Account fpmlAccount);

	public static class MapReturnSwapAccountPartyReferenceDefault extends MapReturnSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(ReturnSwap fpmlReturnSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlReturnSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, ReturnSwap fpmlReturnSwap, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperS.of(fpmlReturnSwap).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwap -> returnSwap.getReturnSwapLeg())
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", directionalLeg -> directionalLeg.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", directionalLeg -> directionalLeg.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", directionalLeg -> directionalLeg.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", directionalLeg -> directionalLeg.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
