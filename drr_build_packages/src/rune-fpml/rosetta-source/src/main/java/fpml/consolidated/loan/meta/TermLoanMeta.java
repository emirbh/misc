package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.TermLoan;
import fpml.consolidated.loan.validation.TermLoanTypeFormatValidator;
import fpml.consolidated.loan.validation.TermLoanValidator;
import fpml.consolidated.loan.validation.exists.TermLoanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TermLoan.class)
public class TermLoanMeta implements RosettaMetaData<TermLoan> {

	@Override
	public List<Validator<? super TermLoan>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TermLoan, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TermLoan> validator(ValidatorFactory factory) {
		return factory.<TermLoan>create(TermLoanValidator.class);
	}

	@Override
	public Validator<? super TermLoan> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TermLoan>create(TermLoanTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TermLoan> validator() {
		return new TermLoanValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TermLoan> typeFormatValidator() {
		return new TermLoanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TermLoan, Set<String>> onlyExistsValidator() {
		return new TermLoanOnlyExistsValidator();
	}
}
