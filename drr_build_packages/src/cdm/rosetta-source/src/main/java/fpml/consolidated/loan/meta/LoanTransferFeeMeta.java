package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTransferFee;
import fpml.consolidated.loan.validation.LoanTransferFeeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTransferFeeValidator;
import fpml.consolidated.loan.validation.datarule.LoanTransferFeeChoice;
import fpml.consolidated.loan.validation.exists.LoanTransferFeeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTransferFee.class)
public class LoanTransferFeeMeta implements RosettaMetaData<LoanTransferFee> {

	@Override
	public List<Validator<? super LoanTransferFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanTransferFee>create(LoanTransferFeeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTransferFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTransferFee> validator(ValidatorFactory factory) {
		return factory.<LoanTransferFee>create(LoanTransferFeeValidator.class);
	}

	@Override
	public Validator<? super LoanTransferFee> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTransferFee>create(LoanTransferFeeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTransferFee> validator() {
		return new LoanTransferFeeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTransferFee> typeFormatValidator() {
		return new LoanTransferFeeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTransferFee, Set<String>> onlyExistsValidator() {
		return new LoanTransferFeeOnlyExistsValidator();
	}
}
