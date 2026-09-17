package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradingNonAccruingFee;
import fpml.consolidated.loan.validation.LoanTradingNonAccruingFeeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradingNonAccruingFeeValidator;
import fpml.consolidated.loan.validation.datarule.LoanTradingNonAccruingFeeChoice0;
import fpml.consolidated.loan.validation.datarule.LoanTradingNonAccruingFeeChoice1;
import fpml.consolidated.loan.validation.exists.LoanTradingNonAccruingFeeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradingNonAccruingFee.class)
public class LoanTradingNonAccruingFeeMeta implements RosettaMetaData<LoanTradingNonAccruingFee> {

	@Override
	public List<Validator<? super LoanTradingNonAccruingFee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LoanTradingNonAccruingFee>create(LoanTradingNonAccruingFeeChoice0.class),
			factory.<LoanTradingNonAccruingFee>create(LoanTradingNonAccruingFeeChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super LoanTradingNonAccruingFee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradingNonAccruingFee> validator(ValidatorFactory factory) {
		return factory.<LoanTradingNonAccruingFee>create(LoanTradingNonAccruingFeeValidator.class);
	}

	@Override
	public Validator<? super LoanTradingNonAccruingFee> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradingNonAccruingFee>create(LoanTradingNonAccruingFeeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingNonAccruingFee> validator() {
		return new LoanTradingNonAccruingFeeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradingNonAccruingFee> typeFormatValidator() {
		return new LoanTradingNonAccruingFeeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradingNonAccruingFee, Set<String>> onlyExistsValidator() {
		return new LoanTradingNonAccruingFeeOnlyExistsValidator();
	}
}
