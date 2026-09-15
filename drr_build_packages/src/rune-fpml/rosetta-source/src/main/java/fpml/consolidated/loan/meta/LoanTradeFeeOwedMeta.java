package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanTradeFeeOwed;
import fpml.consolidated.loan.validation.LoanTradeFeeOwedTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanTradeFeeOwedValidator;
import fpml.consolidated.loan.validation.exists.LoanTradeFeeOwedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanTradeFeeOwed.class)
public class LoanTradeFeeOwedMeta implements RosettaMetaData<LoanTradeFeeOwed> {

	@Override
	public List<Validator<? super LoanTradeFeeOwed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanTradeFeeOwed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanTradeFeeOwed> validator(ValidatorFactory factory) {
		return factory.<LoanTradeFeeOwed>create(LoanTradeFeeOwedValidator.class);
	}

	@Override
	public Validator<? super LoanTradeFeeOwed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanTradeFeeOwed>create(LoanTradeFeeOwedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeFeeOwed> validator() {
		return new LoanTradeFeeOwedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanTradeFeeOwed> typeFormatValidator() {
		return new LoanTradeFeeOwedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanTradeFeeOwed, Set<String>> onlyExistsValidator() {
		return new LoanTradeFeeOwedOnlyExistsValidator();
	}
}
