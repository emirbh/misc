package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanCovenantObligationType;
import fpml.consolidated.loan.validation.LoanCovenantObligationTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanCovenantObligationTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanCovenantObligationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanCovenantObligationType.class)
public class LoanCovenantObligationTypeMeta implements RosettaMetaData<LoanCovenantObligationType> {

	@Override
	public List<Validator<? super LoanCovenantObligationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanCovenantObligationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanCovenantObligationType> validator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationType>create(LoanCovenantObligationTypeValidator.class);
	}

	@Override
	public Validator<? super LoanCovenantObligationType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanCovenantObligationType>create(LoanCovenantObligationTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationType> validator() {
		return new LoanCovenantObligationTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanCovenantObligationType> typeFormatValidator() {
		return new LoanCovenantObligationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanCovenantObligationType, Set<String>> onlyExistsValidator() {
		return new LoanCovenantObligationTypeOnlyExistsValidator();
	}
}
