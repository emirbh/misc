package cdm.ingest.fpml.confirmation.product.commodityforward.functions;

import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.consolidated.com.CommodityForward;
import fpml.consolidated.shared.Account;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityForwardAccountPartyReference.MapCommodityForwardAccountPartyReferenceDefault.class)
public abstract class MapCommodityForwardAccountPartyReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlCommodityForward 
	* @param fpmlAccount 
	* @return partyReference 
	*/
	public ReferenceWithMetaParty evaluate(CommodityForward fpmlCommodityForward, Account fpmlAccount) {
		ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReferenceBuilder = doEvaluate(fpmlCommodityForward, fpmlAccount);
		
		final ReferenceWithMetaParty partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.build();
			objectValidator.validate(ReferenceWithMetaParty.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CommodityForward fpmlCommodityForward, Account fpmlAccount);

	public static class MapCommodityForwardAccountPartyReferenceDefault extends MapCommodityForwardAccountPartyReference {
		@Override
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder doEvaluate(CommodityForward fpmlCommodityForward, Account fpmlAccount) {
			ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference = ReferenceWithMetaParty.builder();
			return assignOutput(partyReference, fpmlCommodityForward, fpmlAccount);
		}
		
		protected ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder assignOutput(ReferenceWithMetaParty.ReferenceWithMetaPartyBuilder partyReference, CommodityForward fpmlCommodityForward, Account fpmlAccount) {
			return Optional.ofNullable(partyReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
