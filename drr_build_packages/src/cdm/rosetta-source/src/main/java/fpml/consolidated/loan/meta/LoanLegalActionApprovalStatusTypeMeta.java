package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanLegalActionApprovalStatusType;
import fpml.consolidated.loan.validation.LoanLegalActionApprovalStatusTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanLegalActionApprovalStatusTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanLegalActionApprovalStatusTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanLegalActionApprovalStatusType.class)
public class LoanLegalActionApprovalStatusTypeMeta implements RosettaMetaData<LoanLegalActionApprovalStatusType> {

	@Override
	public List<Validator<? super LoanLegalActionApprovalStatusType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanLegalActionApprovalStatusType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanLegalActionApprovalStatusType> validator(ValidatorFactory factory) {
		return factory.<LoanLegalActionApprovalStatusType>create(LoanLegalActionApprovalStatusTypeValidator.class);
	}

	@Override
	public Validator<? super LoanLegalActionApprovalStatusType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanLegalActionApprovalStatusType>create(LoanLegalActionApprovalStatusTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionApprovalStatusType> validator() {
		return new LoanLegalActionApprovalStatusTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanLegalActionApprovalStatusType> typeFormatValidator() {
		return new LoanLegalActionApprovalStatusTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanLegalActionApprovalStatusType, Set<String>> onlyExistsValidator() {
		return new LoanLegalActionApprovalStatusTypeOnlyExistsValidator();
	}
}
