package cdm.ingest.fpml.confirmation.product.equityoption.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import cdm.ingest.fpml.confirmation.party.functions.MapBuyerSellerToAccountPartyReference;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eqd.EquityOption;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.AccountReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityOptionAccountPartyReference.MapEquityOptionAccountPartyReferenceDefault.class)
public abstract class MapEquityOptionAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBuyerSellerToAccountPartyReference mapBuyerSellerToAccountPartyReference;

	/**
	* @param fpmlEquityOption 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(EquityOption fpmlEquityOption, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlEquityOption, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(EquityOption fpmlEquityOption, Account fpmlAccount);

	public static class MapEquityOptionAccountPartyReferenceDefault extends MapEquityOptionAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(EquityOption fpmlEquityOption, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlEquityOption, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, EquityOption fpmlEquityOption, Account fpmlAccount) {
			partyReference = toBuilder(mapBuyerSellerToAccountPartyReference.evaluate(fpmlAccount, MapperS.of(fpmlEquityOption).<AccountReference>map("getBuyerAccountReference", equityOption -> equityOption.getBuyerAccountReference()).getMulti(), MapperS.of(fpmlEquityOption).<AccountReference>map("getSellerAccountReference", equityOption -> equityOption.getSellerAccountReference()).getMulti()));
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
