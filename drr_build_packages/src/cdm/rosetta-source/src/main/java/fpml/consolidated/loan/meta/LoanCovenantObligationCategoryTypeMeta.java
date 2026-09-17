package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import fpml.consolidated.loan.validation.LoanCovenantObligationCategoryTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationCategoryTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationCategoryTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationCategoryType.class)
public class LoanCovenantObligationCategoryTypeMeta implements RosettaMetaData<LoanCovenantObligationCategoryType> {

	@Override
	public List<Validator<? super LoanCovenantObligationCategoryType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationCategoryType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationCategoryType> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationCategoryType>create(LoanCovenantObligationCategoryTypeValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationCategoryType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationCategoryType>create(LoanCovenantObligationCategoryTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationCategoryType> validator() {
		return new LoanCovenantObligationCategoryTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationCategoryType> typeFormatValidator() {
		return new LoanCovenantObligationCategoryTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationCategoryType, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationCategoryTypeOnlyExistsValidator();
	}
}
