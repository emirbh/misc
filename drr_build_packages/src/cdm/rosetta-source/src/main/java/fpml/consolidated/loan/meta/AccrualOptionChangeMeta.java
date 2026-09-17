package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccrualOptionChange;
import fpml.consolidated.loan.validation.AccrualOptionChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.AccrualOptionChangeValidator;
import fpml.consolidated.loan.validation.datarule.AccrualOptionChangeChoice;
import fpml.consolidated.loan.validation.exists.AccrualOptionChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccrualOptionChange.class)
public class AccrualOptionChangeMeta implements RosettaMetaData<AccrualOptionChange> {

	@Override
	public List<Validator<? super AccrualOptionChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AccrualOptionChange>create(AccrualOptionChangeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super AccrualOptionChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccrualOptionChange> validator(ValidatorFactory factory) {
		return factory.<AccrualOptionChange>create(AccrualOptionChangeValidator.class);
	}

	@Override
	public Validator<? super AccrualOptionChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccrualOptionChange>create(AccrualOptionChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccrualOptionChange> validator() {
		return new AccrualOptionChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccrualOptionChange> typeFormatValidator() {
		return new AccrualOptionChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualOptionChange, Set<String>> onlyExistsValidator() {
		return new AccrualOptionChangeOnlyExistsValidator();
	}
}
