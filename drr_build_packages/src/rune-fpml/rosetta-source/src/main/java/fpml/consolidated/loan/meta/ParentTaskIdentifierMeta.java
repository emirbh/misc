package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.ParentTaskIdentifier;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.loan.validation.ParentTaskIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.ParentTaskIdentifierValidator;
import fpml.consolidated.loan.validation.datarule.TaskIdentifierChoice;
import fpml.consolidated.loan.validation.exists.ParentTaskIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ParentTaskIdentifier.class)
public class ParentTaskIdentifierMeta implements RosettaMetaData<ParentTaskIdentifier> {

	@Override
	public List<Validator<? super ParentTaskIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TaskIdentifier>create(TaskIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ParentTaskIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ParentTaskIdentifier> validator(ValidatorFactory factory) {
		return factory.<ParentTaskIdentifier>create(ParentTaskIdentifierValidator.class);
	}

	@Override
	public Validator<? super ParentTaskIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ParentTaskIdentifier>create(ParentTaskIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ParentTaskIdentifier> validator() {
		return new ParentTaskIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ParentTaskIdentifier> typeFormatValidator() {
		return new ParentTaskIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParentTaskIdentifier, Set<String>> onlyExistsValidator() {
		return new ParentTaskIdentifierOnlyExistsValidator();
	}
}
