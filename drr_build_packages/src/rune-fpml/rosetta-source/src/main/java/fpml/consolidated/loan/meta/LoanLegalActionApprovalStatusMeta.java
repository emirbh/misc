package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionApprovalStatus;
import fpml.consolidated.loan.validation.LoanLegalActionApprovalStatusTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionApprovalStatusValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionApprovalStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionApprovalStatus.class)
public class LoanLegalActionApprovalStatusMeta implements RosettaMetaData<LoanLegalActionApprovalStatus> {

	@Override
	public List<Validator<? super LoanLegalActionApprovalStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionApprovalStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionApprovalStatus> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionApprovalStatus>create(LoanLegalActionApprovalStatusValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionApprovalStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionApprovalStatus>create(LoanLegalActionApprovalStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionApprovalStatus> validator() {
		return new LoanLegalActionApprovalStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionApprovalStatus> typeFormatValidator() {
		return new LoanLegalActionApprovalStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionApprovalStatus, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionApprovalStatusOnlyExistsValidator();
	}
}
