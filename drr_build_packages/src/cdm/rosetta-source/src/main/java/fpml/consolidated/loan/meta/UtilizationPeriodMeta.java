package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.UtilizationPeriod;
import fpml.consolidated.loan.validation.UtilizationPeriodTypeFormatValidator;
import fpml.consolidated.loan.validation.UtilizationPeriodValidator;
import fpml.consolidated.loan.validation.exists.UtilizationPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UtilizationPeriod.class)
public class UtilizationPeriodMeta implements RosettaMetaData<UtilizationPeriod> {

	@Override
	public List<Validator<? super UtilizationPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UtilizationPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UtilizationPeriod> validator(ValidatorFactory factory) {
		return factory.<UtilizationPeriod>create(UtilizationPeriodValidator.class);
	}

	@Override
	public Validator<? super UtilizationPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UtilizationPeriod>create(UtilizationPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UtilizationPeriod> validator() {
		return new UtilizationPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UtilizationPeriod> typeFormatValidator() {
		return new UtilizationPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UtilizationPeriod, Set<String>> onlyExistsValidator() {
		return new UtilizationPeriodOnlyExistsValidator();
	}
}
