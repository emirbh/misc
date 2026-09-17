package cdm.ingest.fpml.confirmation.product.creditdefaultswap.functions;

import cdm.ingest.fpml.confirmation.party.functions.MapLegalEntity;
import cdm.product.asset.ReferenceInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.cd.ReferenceObligation;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.LegalEntity;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferenceInformation.MapReferenceInformationDefault.class)
public abstract class MapReferenceInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapReferenceObligation mapReferenceObligation;
	@Inject protected MapReferencePrice mapReferencePrice;

	/**
	* @param fpmlReferenceInformation 
	* @param fpmlCurrency 
	* @return referenceInformation 
	*/
	public ReferenceInformation evaluate(fpml.consolidated.cd.ReferenceInformation fpmlReferenceInformation, Currency fpmlCurrency) {
		ReferenceInformation.ReferenceInformationBuilder referenceInformationBuilder = doEvaluate(fpmlReferenceInformation, fpmlCurrency);
		
		final ReferenceInformation referenceInformation;
		if (referenceInformationBuilder == null) {
			referenceInformation = null;
		} else {
			referenceInformation = referenceInformationBuilder.build();
			objectValidator.validate(ReferenceInformation.class, referenceInformation);
		}
		
		return referenceInformation;
	}

	protected abstract ReferenceInformation.ReferenceInformationBuilder doEvaluate(fpml.consolidated.cd.ReferenceInformation fpmlReferenceInformation, Currency fpmlCurrency);

	public static class MapReferenceInformationDefault extends MapReferenceInformation {
		@Override
		protected ReferenceInformation.ReferenceInformationBuilder doEvaluate(fpml.consolidated.cd.ReferenceInformation fpmlReferenceInformation, Currency fpmlCurrency) {
			ReferenceInformation.ReferenceInformationBuilder referenceInformation = ReferenceInformation.builder();
			return assignOutput(referenceInformation, fpmlReferenceInformation, fpmlCurrency);
		}
		
		protected ReferenceInformation.ReferenceInformationBuilder assignOutput(ReferenceInformation.ReferenceInformationBuilder referenceInformation, fpml.consolidated.cd.ReferenceInformation fpmlReferenceInformation, Currency fpmlCurrency) {
			referenceInformation = toBuilder(ReferenceInformation.builder()
				.setReferenceEntity(mapLegalEntity.evaluate(MapperS.of(fpmlReferenceInformation).<LegalEntity>map("getReferenceEntity", _referenceInformation -> _referenceInformation.getReferenceEntity()).get()))
				.setReferenceObligation(MapperS.of(fpmlReferenceInformation).<ReferenceObligation>mapC("getReferenceObligation", _referenceInformation -> _referenceInformation.getReferenceObligation())
					.mapItem(item -> MapperS.of(mapReferenceObligation.evaluate(item.get()))).getMulti())
				.setAllGuarantees(MapperS.of(fpmlReferenceInformation).<Boolean>map("getAllGuarantees", _referenceInformation -> _referenceInformation.getAllGuarantees()).get())
				.setReferencePrice(mapReferencePrice.evaluate(MapperS.of(fpmlReferenceInformation).<BigDecimal>map("getReferencePrice", _referenceInformation -> _referenceInformation.getReferencePrice()).get(), fpmlCurrency))
				.build());
			
			return Optional.ofNullable(referenceInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
