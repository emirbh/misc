package cdm.base.staticdata.identifier.meta;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.LocationIdentifier;
import cdm.base.staticdata.identifier.validation.LocationIdentifierTypeFormatValidator;
import cdm.base.staticdata.identifier.validation.LocationIdentifierValidator;
import cdm.base.staticdata.identifier.validation.datarule.IdentifierIssuerChoice;
import cdm.base.staticdata.identifier.validation.datarule.LocationIdentifierIdentifierType;
import cdm.base.staticdata.identifier.validation.exists.LocationIdentifierOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=LocationIdentifier.class)
public class LocationIdentifierMeta implements RosettaMetaData<LocationIdentifier> {

	@Override
	public List<Validator<? super LocationIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Identifier>create(IdentifierIssuerChoice.class),
			factory.<LocationIdentifier>create(LocationIdentifierIdentifierType.class)
		);
	}
	
	@Override
	public List<Function<? super LocationIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LocationIdentifier> validator(ValidatorFactory factory) {
		return factory.<LocationIdentifier>create(LocationIdentifierValidator.class);
	}

	@Override
	public Validator<? super LocationIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LocationIdentifier>create(LocationIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LocationIdentifier> validator() {
		return new LocationIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LocationIdentifier> typeFormatValidator() {
		return new LocationIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LocationIdentifier, Set<String>> onlyExistsValidator() {
		return new LocationIdentifierOnlyExistsValidator();
	}
}
