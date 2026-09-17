package cdm.event.common.meta;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.validation.datarule.IdentifierIssuerChoice;
import cdm.event.common.PositionIdentifier;
import cdm.event.common.validation.PositionIdentifierTypeFormatValidator;
import cdm.event.common.validation.PositionIdentifierValidator;
import cdm.event.common.validation.exists.PositionIdentifierOnlyExistsValidator;
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
@RosettaMeta(model=PositionIdentifier.class)
public class PositionIdentifierMeta implements RosettaMetaData<PositionIdentifier> {

	@Override
	public List<Validator<? super PositionIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Identifier>create(IdentifierIssuerChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PositionIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PositionIdentifier> validator(ValidatorFactory factory) {
		return factory.<PositionIdentifier>create(PositionIdentifierValidator.class);
	}

	@Override
	public Validator<? super PositionIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PositionIdentifier>create(PositionIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PositionIdentifier> validator() {
		return new PositionIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PositionIdentifier> typeFormatValidator() {
		return new PositionIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PositionIdentifier, Set<String>> onlyExistsValidator() {
		return new PositionIdentifierOnlyExistsValidator();
	}
}
