package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriod;
import fpml.consolidated.loan.validation.LoanAllocationNoSettlePeriodTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNoSettlePeriodValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationNoSettlePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNoSettlePeriod.class)
public class LoanAllocationNoSettlePeriodMeta implements RosettaMetaData<LoanAllocationNoSettlePeriod> {

	@Override
	public List<Validator<? super LoanAllocationNoSettlePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNoSettlePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNoSettlePeriod>create(LoanAllocationNoSettlePeriodValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNoSettlePeriod>create(LoanAllocationNoSettlePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> validator() {
		return new LoanAllocationNoSettlePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNoSettlePeriod> typeFormatValidator() {
		return new LoanAllocationNoSettlePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNoSettlePeriod, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNoSettlePeriodOnlyExistsValidator();
	}
}
