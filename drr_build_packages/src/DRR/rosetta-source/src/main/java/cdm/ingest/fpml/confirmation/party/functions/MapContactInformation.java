package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.ContactInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.CountryCode;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapContactInformation.MapContactInformationDefault.class)
public abstract class MapContactInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInfoToContactInformation mapContactInfoToContactInformation;
	@Inject protected MapCountryToContactInformation mapCountryToContactInformation;

	/**
	* @param fpmlCountry 
	* @param fpmlContactInformation 
	* @return cdmContactInformation 
	*/
	public ContactInformation evaluate(CountryCode fpmlCountry, fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
		ContactInformation.ContactInformationBuilder cdmContactInformationBuilder = doEvaluate(fpmlCountry, fpmlContactInformation);
		
		final ContactInformation cdmContactInformation;
		if (cdmContactInformationBuilder == null) {
			cdmContactInformation = null;
		} else {
			cdmContactInformation = cdmContactInformationBuilder.build();
			objectValidator.validate(ContactInformation.class, cdmContactInformation);
		}
		
		return cdmContactInformation;
	}

	protected abstract ContactInformation.ContactInformationBuilder doEvaluate(CountryCode fpmlCountry, fpml.consolidated.shared.ContactInformation fpmlContactInformation);

	public static class MapContactInformationDefault extends MapContactInformation {
		@Override
		protected ContactInformation.ContactInformationBuilder doEvaluate(CountryCode fpmlCountry, fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
			ContactInformation.ContactInformationBuilder cdmContactInformation = ContactInformation.builder();
			return assignOutput(cdmContactInformation, fpmlCountry, fpmlContactInformation);
		}
		
		protected ContactInformation.ContactInformationBuilder assignOutput(ContactInformation.ContactInformationBuilder cdmContactInformation, CountryCode fpmlCountry, fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
			if (exists(MapperS.of(fpmlContactInformation)).getOrDefault(false)) {
				cdmContactInformation = toBuilder(mapContactInfoToContactInformation.evaluate(fpmlContactInformation));
			} else if (exists(MapperS.of(fpmlCountry)).getOrDefault(false)) {
				cdmContactInformation = toBuilder(mapCountryToContactInformation.evaluate(fpmlCountry));
			} else {
				cdmContactInformation = null;
			}
			
			return Optional.ofNullable(cdmContactInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
