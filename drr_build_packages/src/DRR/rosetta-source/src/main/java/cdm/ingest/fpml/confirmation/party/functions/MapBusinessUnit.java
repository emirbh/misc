package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.BusinessUnit;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.ContactInformation;
import fpml.consolidated.shared.CountryCode;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessUnit.MapBusinessUnitDefault.class)
public abstract class MapBusinessUnit implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInformation mapContactInformation;

	/**
	* @param fpmlBusinessUnit 
	* @return cdmBusinessUnit 
	*/
	public BusinessUnit evaluate(fpml.consolidated.shared.BusinessUnit fpmlBusinessUnit) {
		BusinessUnit.BusinessUnitBuilder cdmBusinessUnitBuilder = doEvaluate(fpmlBusinessUnit);
		
		final BusinessUnit cdmBusinessUnit;
		if (cdmBusinessUnitBuilder == null) {
			cdmBusinessUnit = null;
		} else {
			cdmBusinessUnit = cdmBusinessUnitBuilder.build();
			objectValidator.validate(BusinessUnit.class, cdmBusinessUnit);
		}
		
		return cdmBusinessUnit;
	}

	protected abstract BusinessUnit.BusinessUnitBuilder doEvaluate(fpml.consolidated.shared.BusinessUnit fpmlBusinessUnit);

	public static class MapBusinessUnitDefault extends MapBusinessUnit {
		@Override
		protected BusinessUnit.BusinessUnitBuilder doEvaluate(fpml.consolidated.shared.BusinessUnit fpmlBusinessUnit) {
			BusinessUnit.BusinessUnitBuilder cdmBusinessUnit = BusinessUnit.builder();
			return assignOutput(cdmBusinessUnit, fpmlBusinessUnit);
		}
		
		protected BusinessUnit.BusinessUnitBuilder assignOutput(BusinessUnit.BusinessUnitBuilder cdmBusinessUnit, fpml.consolidated.shared.BusinessUnit fpmlBusinessUnit) {
			final BusinessUnit.BusinessUnitBuilder withMetaArgument = BusinessUnit.builder()
				.setName(MapperS.of(fpmlBusinessUnit).<String>map("getName", businessUnit -> businessUnit.getName()).get())
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlBusinessUnit).<CountryCode>map("getCountry", businessUnit -> businessUnit.getCountry()).get(), MapperS.of(fpmlBusinessUnit).<ContactInformation>map("getContactInfo", businessUnit -> businessUnit.getContactInfo()).get()))
				.build() == null ? null : BusinessUnit.builder()
				.setName(MapperS.of(fpmlBusinessUnit).<String>map("getName", businessUnit -> businessUnit.getName()).get())
				.setContactInformation(mapContactInformation.evaluate(MapperS.of(fpmlBusinessUnit).<CountryCode>map("getCountry", businessUnit -> businessUnit.getCountry()).get(), MapperS.of(fpmlBusinessUnit).<ContactInformation>map("getContactInfo", businessUnit -> businessUnit.getContactInfo()).get()))
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlBusinessUnit).<String>map("getId", businessUnit -> businessUnit.getId()).get());
			cdmBusinessUnit = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(cdmBusinessUnit)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
