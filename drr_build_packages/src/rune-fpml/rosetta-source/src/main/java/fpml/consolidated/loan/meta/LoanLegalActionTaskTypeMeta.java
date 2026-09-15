package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionTaskType;
import fpml.consolidated.loan.validation.LoanLegalActionTaskTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionTaskTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionTaskTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionTaskType.class)
public class LoanLegalActionTaskTypeMeta implements RosettaMetaData<LoanLegalActionTaskType> {

	@Override
	public List<Validator<? super LoanLegalActionTaskType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionTaskType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionTaskType> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionTaskType>create(LoanLegalActionTaskTypeValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionTaskType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionTaskType>create(LoanLegalActionTaskTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionTaskType> validator() {
		return new LoanLegalActionTaskTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionTaskType> typeFormatValidator() {
		return new LoanLegalActionTaskTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionTaskType, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionTaskTypeOnlyExistsValidator();
	}
}
