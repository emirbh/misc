package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LoanFloatingRateAccrual;
import fpml.consolidated.loan.validation.LoanFloatingRateAccrualTypeFormatValidator;
import fpml.consolidated.loan.validation.LoanFloatingRateAccrualValidator;
import fpml.consolidated.loan.validation.exists.LoanFloatingRateAccrualOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LoanFloatingRateAccrual.class)
public class LoanFloatingRateAccrualMeta implements RosettaMetaData<LoanFloatingRateAccrual> {

	@Override
	public List<Validator<? super LoanFloatingRateAccrual>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanFloatingRateAccrual, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanFloatingRateAccrual> validator(ValidatorFactory factory) {
		return factory.<LoanFloatingRateAccrual>create(LoanFloatingRateAccrualValidator.class);
	}

	@Override
	public Validator<? super LoanFloatingRateAccrual> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LoanFloatingRateAccrual>create(LoanFloatingRateAccrualTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRateAccrual> validator() {
		return new LoanFloatingRateAccrualValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LoanFloatingRateAccrual> typeFormatValidator() {
		return new LoanFloatingRateAccrualTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanFloatingRateAccrual, Set<String>> onlyExistsValidator() {
		return new LoanFloatingRateAccrualOnlyExistsValidator();
	}
}
