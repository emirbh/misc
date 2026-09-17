package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.business.events.validation.BusinessEventIdentifierTypeFormatValidator;
import fpml.consolidated.business.events.validation.BusinessEventIdentifierValidator;
import fpml.consolidated.business.events.validation.exists.BusinessEventIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BusinessEventIdentifier.class)
public class BusinessEventIdentifierMeta implements RosettaMetaData<BusinessEventIdentifier> {

	@Override
	public List<Validator<? super BusinessEventIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessEventIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BusinessEventIdentifier> validator(ValidatorFactory factory) {
		return factory.<BusinessEventIdentifier>create(BusinessEventIdentifierValidator.class);
	}

	@Override
	public Validator<? super BusinessEventIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BusinessEventIdentifier>create(BusinessEventIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BusinessEventIdentifier> validator() {
		return new BusinessEventIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BusinessEventIdentifier> typeFormatValidator() {
		return new BusinessEventIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessEventIdentifier, Set<String>> onlyExistsValidator() {
		return new BusinessEventIdentifierOnlyExistsValidator();
	}
}
