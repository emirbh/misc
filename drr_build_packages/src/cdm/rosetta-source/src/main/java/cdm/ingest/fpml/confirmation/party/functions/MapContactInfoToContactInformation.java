package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.Address;
import cdm.base.staticdata.party.ContactInformation;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.shared.TelephoneNumber;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapContactInfoToContactInformation.MapContactInfoToContactInformationDefault.class)
public abstract class MapContactInfoToContactInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAddress mapAddress;
	@Inject protected MapTelephoneNumber mapTelephoneNumber;

	/**
	* @param fpmlContactInformation 
	* @return cdmContactInformation 
	*/
	public ContactInformation evaluate(fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
		ContactInformation.ContactInformationBuilder cdmContactInformationBuilder = doEvaluate(fpmlContactInformation);
		
		final ContactInformation cdmContactInformation;
		if (cdmContactInformationBuilder == null) {
			cdmContactInformation = null;
		} else {
			cdmContactInformation = cdmContactInformationBuilder.build();
			objectValidator.validate(ContactInformation.class, cdmContactInformation);
		}
		
		return cdmContactInformation;
	}

	protected abstract ContactInformation.ContactInformationBuilder doEvaluate(fpml.consolidated.shared.ContactInformation fpmlContactInformation);

	public static class MapContactInfoToContactInformationDefault extends MapContactInfoToContactInformation {
		@Override
		protected ContactInformation.ContactInformationBuilder doEvaluate(fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
			ContactInformation.ContactInformationBuilder cdmContactInformation = ContactInformation.builder();
			return assignOutput(cdmContactInformation, fpmlContactInformation);
		}
		
		protected ContactInformation.ContactInformationBuilder assignOutput(ContactInformation.ContactInformationBuilder cdmContactInformation, fpml.consolidated.shared.ContactInformation fpmlContactInformation) {
			final List<Address> ifThenElseResult;
			if (exists(MapperS.of(fpmlContactInformation).<fpml.consolidated.shared.Address>map("getAddress", contactInformation -> contactInformation.getAddress())).getOrDefault(false)) {
				final Address address = mapAddress.evaluate(MapperS.of(fpmlContactInformation).<fpml.consolidated.shared.Address>map("getAddress", contactInformation -> contactInformation.getAddress()).get());
				ifThenElseResult = address == null ? Collections.<Address>emptyList() : Collections.singletonList(address);
			} else {
				ifThenElseResult = Collections.<Address>emptyList();
			}
			cdmContactInformation = toBuilder(ContactInformation.builder()
				.setTelephone(MapperS.of(fpmlContactInformation).<TelephoneNumber>mapC("getTelephone", contactInformation -> contactInformation.getTelephone())
					.mapItem(item -> MapperS.of(mapTelephoneNumber.evaluate(item.get()))).getMulti())
				.setAddress(ifThenElseResult)
				.setEmail(MapperS.of(fpmlContactInformation).<String>mapC("getEmail", contactInformation -> contactInformation.getEmail()).getMulti())
				.build());
			
			return Optional.ofNullable(cdmContactInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
