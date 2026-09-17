package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccrualPeriod;
import fpml.consolidated.loan.validation.AccrualPeriodTypeFormatValidator;
import fpml.consolidated.loan.validation.AccrualPeriodValidator;
import fpml.consolidated.loan.validation.exists.AccrualPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccrualPeriod.class)
public class AccrualPeriodMeta implements RosettaMetaData<AccrualPeriod> {

	@Override
	public List<Validator<? super AccrualPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccrualPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccrualPeriod> validator(ValidatorFactory factory) {
		return factory.<AccrualPeriod>create(AccrualPeriodValidator.class);
	}

	@Override
	public Validator<? super AccrualPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccrualPeriod>create(AccrualPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccrualPeriod> validator() {
		return new AccrualPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccrualPeriod> typeFormatValidator() {
		return new AccrualPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccrualPeriod, Set<String>> onlyExistsValidator() {
		return new AccrualPeriodOnlyExistsValidator();
	}
}
