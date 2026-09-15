package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.product.asset.ReferencePoolItem;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.ConstituentWeight;
import fpml.consolidated.cd.ProtectionTermsReference;
import fpml.consolidated.cd.ReferencePair;
import fpml.consolidated.cd.SettlementTermsReference;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferencePoolItem.MapReferencePoolItemDefault.class)
public abstract class MapReferencePoolItem implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapConstituentWeight mapConstituentWeight;
	@Inject protected MapReferencePair mapReferencePair;

	/**
	* @param fpmlReferencePoolItem 
	* @return referencePoolItem 
	*/
	public ReferencePoolItem evaluate(fpml.consolidated.cd.ReferencePoolItem fpmlReferencePoolItem) {
		ReferencePoolItem.ReferencePoolItemBuilder referencePoolItemBuilder = doEvaluate(fpmlReferencePoolItem);
		
		final ReferencePoolItem referencePoolItem;
		if (referencePoolItemBuilder == null) {
			referencePoolItem = null;
		} else {
			referencePoolItem = referencePoolItemBuilder.build();
			objectValidator.validate(ReferencePoolItem.class, referencePoolItem);
		}
		
		return referencePoolItem;
	}

	protected abstract ReferencePoolItem.ReferencePoolItemBuilder doEvaluate(fpml.consolidated.cd.ReferencePoolItem fpmlReferencePoolItem);

	public static class MapReferencePoolItemDefault extends MapReferencePoolItem {
		@Override
		protected ReferencePoolItem.ReferencePoolItemBuilder doEvaluate(fpml.consolidated.cd.ReferencePoolItem fpmlReferencePoolItem) {
			ReferencePoolItem.ReferencePoolItemBuilder referencePoolItem = ReferencePoolItem.builder();
			return assignOutput(referencePoolItem, fpmlReferencePoolItem);
		}
		
		protected ReferencePoolItem.ReferencePoolItemBuilder assignOutput(ReferencePoolItem.ReferencePoolItemBuilder referencePoolItem, fpml.consolidated.cd.ReferencePoolItem fpmlReferencePoolItem) {
			referencePoolItem = toBuilder(ReferencePoolItem.builder()
				.setConstituentWeight(mapConstituentWeight.evaluate(MapperS.of(fpmlReferencePoolItem).<ConstituentWeight>map("getConstituentWeight", _referencePoolItem -> _referencePoolItem.getConstituentWeight()).get()))
				.setReferencePair(mapReferencePair.evaluate(MapperS.of(fpmlReferencePoolItem).<ReferencePair>map("getReferencePair", _referencePoolItem -> _referencePoolItem.getReferencePair()).get()))
				.build(), () -> ReferencePoolItem.builder());
			
			referencePoolItem
				.getOrCreateProtectionTermsReference()
				.setExternalReference(MapperS.of(fpmlReferencePoolItem).<ProtectionTermsReference>map("getProtectionTermsReference", _referencePoolItem -> _referencePoolItem.getProtectionTermsReference()).<String>map("getHref", protectionTermsReference -> protectionTermsReference.getHref()).get());
			
			referencePoolItem
				.getOrCreateCashSettlementTermsReference()
				.setExternalReference(MapperS.of(fpmlReferencePoolItem).<SettlementTermsReference>map("getSettlementTermsReference", _referencePoolItem -> _referencePoolItem.getSettlementTermsReference()).<String>map("getHref", settlementTermsReference -> settlementTermsReference.getHref()).get());
			
			referencePoolItem
				.getOrCreatePhysicalSettlementTermsReference()
				.setExternalReference(MapperS.of(fpmlReferencePoolItem).<SettlementTermsReference>map("getSettlementTermsReference", _referencePoolItem -> _referencePoolItem.getSettlementTermsReference()).<String>map("getHref", settlementTermsReference -> settlementTermsReference.getHref()).get());
			
			return Optional.ofNullable(referencePoolItem)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
