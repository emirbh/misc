package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.LegacyAccrualPeriod;
import fpml.consolidated.loan.validation.LegacyAccrualPeriodTypeFormatValidator;
import fpml.consolidated.loan.validation.LegacyAccrualPeriodValidator;
import fpml.consolidated.loan.validation.exists.LegacyAccrualPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegacyAccrualPeriod.class)
public class LegacyAccrualPeriodMeta implements RosettaMetaData<LegacyAccrualPeriod> {

	@Override
	public List<Validator<? super LegacyAccrualPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyAccrualPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyAccrualPeriod> validator(ValidatorFactory factory) {
		return factory.<LegacyAccrualPeriod>create(LegacyAccrualPeriodValidator.class);
	}

	@Override
	public Validator<? super LegacyAccrualPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyAccrualPeriod>create(LegacyAccrualPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyAccrualPeriod> validator() {
		return new LegacyAccrualPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyAccrualPeriod> typeFormatValidator() {
		return new LegacyAccrualPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyAccrualPeriod, Set<String>> onlyExistsValidator() {
		return new LegacyAccrualPeriodOnlyExistsValidator();
	}
}
