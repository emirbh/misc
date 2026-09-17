package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.loan.validation.ParentEventIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.ParentEventIdentifierValidator;
import fpml.consolidated.loan.validation.exists.ParentEventIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ParentEventIdentifier.class)
public class ParentEventIdentifierMeta implements RosettaMetaData<ParentEventIdentifier> {

	@Override
	public List<Validator<? super ParentEventIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ParentEventIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ParentEventIdentifier> validator(ValidatorFactory factory) {
		return factory.<ParentEventIdentifier>create(ParentEventIdentifierValidator.class);
	}

	@Override
	public Validator<? super ParentEventIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ParentEventIdentifier>create(ParentEventIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ParentEventIdentifier> validator() {
		return new ParentEventIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ParentEventIdentifier> typeFormatValidator() {
		return new ParentEventIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParentEventIdentifier, Set<String>> onlyExistsValidator() {
		return new ParentEventIdentifierOnlyExistsValidator();
	}
}
