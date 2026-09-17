package cdm.ingest.fpml.confirmation.product.capfloor.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapPayerReceiverToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.ird.CapFloor;
import fpml.consolidated.ird.InterestRateStream;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.PartyReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCapFloorAccountPartyReference.MapCapFloorAccountPartyReferenceDefault.class)
public abstract class MapCapFloorAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiverToAccountPartyReference mapPayerReceiverToAccountPartyReference;

	/**
	* @param fpmlCapFloor 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(CapFloor fpmlCapFloor, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlCapFloor, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CapFloor fpmlCapFloor, Account fpmlAccount);

	public static class MapCapFloorAccountPartyReferenceDefault extends MapCapFloorAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CapFloor fpmlCapFloor, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlCapFloor, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, CapFloor fpmlCapFloor, Account fpmlAccount) {
			partyReference = toBuilder(MapperS.of(fpmlCapFloor).<InterestRateStream>map("getCapFloorStream", capFloor -> capFloor.getCapFloorStream())
				.mapSingleToItem(item -> MapperS.of(mapPayerReceiverToAccountPartyReference.evaluate(fpmlAccount, item.<AccountReference>map("getPayerAccountReference", interestRateStream -> interestRateStream.getPayerAccountReference()).get(), item.<AccountReference>map("getReceiverAccountReference", interestRateStream -> interestRateStream.getReceiverAccountReference()).get(), item.<PartyReference>map("getPayerPartyReference", interestRateStream -> interestRateStream.getPayerPartyReference()).get(), item.<PartyReference>map("getReceiverPartyReference", interestRateStream -> interestRateStream.getReceiverPartyReference()).get()))).get());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
