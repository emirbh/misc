package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanAllocationNoSettlePeriodType;
import fpml.consolidated.loan.validation.LoanAllocationNoSettlePeriodTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanAllocationNoSettlePeriodTypeValidator;
import fpml.consolidated.loan.validation.exists.LoanAllocationNoSettlePeriodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanAllocationNoSettlePeriodType.class)
public class LoanAllocationNoSettlePeriodTypeMeta implements RosettaMetaData<LoanAllocationNoSettlePeriodType> {

	@Override
	public List<Validator<? super LoanAllocationNoSettlePeriodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanAllocationNoSettlePeriodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> validator(ValidatorFactory factory) {
		return factory.<LoanAllocationNoSettlePeriodType>create(LoanAllocationNoSettlePeriodTypeValidator.class);
	}

	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanAllocationNoSettlePeriodType>create(LoanAllocationNoSettlePeriodTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> validator() {
		return new LoanAllocationNoSettlePeriodTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanAllocationNoSettlePeriodType> typeFormatValidator() {
		return new LoanAllocationNoSettlePeriodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanAllocationNoSettlePeriodType, Set<String>> onlyExistsValidator() {
		return new LoanAllocationNoSettlePeriodTypeOnlyExistsValidator();
	}
}
