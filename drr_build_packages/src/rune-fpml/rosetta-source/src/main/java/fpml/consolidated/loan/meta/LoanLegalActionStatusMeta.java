package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionStatus;
import fpml.consolidated.loan.validation.LoanLegalActionStatusTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionStatusValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionStatus.class)
public class LoanLegalActionStatusMeta implements RosettaMetaData<LoanLegalActionStatus> {

	@Override
	public List<Validator<? super LoanLegalActionStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionStatus> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatus>create(LoanLegalActionStatusValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionStatus>create(LoanLegalActionStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatus> validator() {
		return new LoanLegalActionStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionStatus> typeFormatValidator() {
		return new LoanLegalActionStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionStatus, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionStatusOnlyExistsValidator();
	}
}
