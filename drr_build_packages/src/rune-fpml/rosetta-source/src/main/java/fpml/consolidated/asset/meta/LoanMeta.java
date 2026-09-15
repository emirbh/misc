package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Loan;
import fpml.consolidated.asset.validation.LoanTypeFormatValidator;
import fpml.consolidated.asset.validation.LoanValidator;
import fpml.consolidated.asset.validation.exists.LoanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Loan.class)
public class LoanMeta implements RosettaMetaData<Loan> {

	@Override
	public List<Validator<? super Loan>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Loan, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Loan> validator(ValidatorFactory factory) {
		return factory.<Loan>create(LoanValidator.class);
	}

	@Override
	public Validator<? super Loan> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Loan>create(LoanTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Loan> validator() {
		return new LoanValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Loan> typeFormatValidator() {
		return new LoanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Loan, Set<String>> onlyExistsValidator() {
		return new LoanOnlyExistsValidator();
	}
}
