package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyFloatingRateIndexLoan;
import fpml.consolidated.loan.validation.LegacyFloatingRateIndexLoanTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyFloatingRateIndexLoanValidator;
import fpml.consolidated.loan.validation.exists.LegacyFloatingRateIndexLoanOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyFloatingRateIndexLoan.class)
public class LegacyFloatingRateIndexLoanMeta implements RosettaMetaData<LegacyFloatingRateIndexLoan> {

	@Override
	public List<Validator<? super LegacyFloatingRateIndexLoan>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyFloatingRateIndexLoan, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyFloatingRateIndexLoan> validator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateIndexLoan>create(LegacyFloatingRateIndexLoanValidator.class);
	}

	@Override
	public Validator<? super LegacyFloatingRateIndexLoan> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyFloatingRateIndexLoan>create(LegacyFloatingRateIndexLoanTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateIndexLoan> validator() {
		return new LegacyFloatingRateIndexLoanValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyFloatingRateIndexLoan> typeFormatValidator() {
		return new LegacyFloatingRateIndexLoanTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyFloatingRateIndexLoan, Set<String>> onlyExistsValidator() {
		return new LegacyFloatingRateIndexLoanOnlyExistsValidator();
	}
}
