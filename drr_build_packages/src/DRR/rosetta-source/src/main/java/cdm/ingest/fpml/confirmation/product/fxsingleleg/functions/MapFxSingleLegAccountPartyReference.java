package cdm.ingest.fpml.confirmation.product.fxsingleleg.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fx.FxSingleLeg;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Payment;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFxSingleLegAccountPartyReference.MapFxSingleLegAccountPartyReferenceDefault.class)
public abstract class MapFxSingleLegAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlFxSingleLeg 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(FxSingleLeg fpmlFxSingleLeg, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlFxSingleLeg, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, Account fpmlAccount);

	public static class MapFxSingleLegAccountPartyReferenceDefault extends MapFxSingleLegAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(FxSingleLeg fpmlFxSingleLeg, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlFxSingleLeg, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, FxSingleLeg fpmlFxSingleLeg, Account fpmlAccount) {
			final MapperC<ReferenceWithMetaParty> thenArg = MapperC.<Payment>of(MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency1", fxSingleLeg -> fxSingleLeg.getExchangedCurrency1()), MapperS.of(fpmlFxSingleLeg).<Payment>map("getExchangedCurrency2", fxSingleLeg -> fxSingleLeg.getExchangedCurrency2()))
				.mapItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", payment -> payment.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", payment -> payment.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", payment -> payment.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", payment -> payment.getReceiverPartyReference()).get())));
			partyReference = toBuilder(thenArg
				.first().get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
