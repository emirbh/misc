package cdm.ingest.fpml.confirmation.product.fxswap.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxSwap;
import fpml.consolidated.fx.FxSwapLeg;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSwapAccountPartyReference.MapFxSwapAccountPartyReferenceDefault.class)
public abstract class MapFxSwapAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlFxSwap 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(FxSwap fpmlFxSwap, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlFxSwap, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxSwap fpmlFxSwap, Account fpmlAccount);

	public static class MapFxSwapAccountPartyReferenceDefault extends MapFxSwapAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxSwap fpmlFxSwap, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlFxSwap, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, FxSwap fpmlFxSwap, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperC.<Payment>of(MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getNearLeg", fxSwap -> fxSwap.getNearLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency1", fxSwapLeg -> fxSwapLeg.getExchangedCurrency1()), MapperS.of(fpmlFxSwap).<FxSwapLeg>map("getFarLeg", fxSwap -> fxSwap.getFarLeg()).<Payment>map("getExchangedCurrency2", fxSwapLeg -> fxSwapLeg.getExchangedCurrency2()))
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", payment -> payment.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", payment -> payment.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
