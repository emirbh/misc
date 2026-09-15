package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.PercentageTolerance;
import fpml.consolidated.com.validation.PercentageToleranceTypeFormatValidator;
import fpml.consolidated.com.validation.PercentageToleranceValidator;
import fpml.consolidated.com.validation.exists.PercentageToleranceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PercentageTolerance.class)
public class PercentageToleranceMeta implements RosettaMetaData<PercentageTolerance> {

	@Override
	public List<Validator<? super PercentageTolerance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PercentageTolerance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PercentageTolerance> validator(ValidatorFactory factory) {
		return factory.<PercentageTolerance>create(PercentageToleranceValidator.class);
	}

	@Override
	public Validator<? super PercentageTolerance> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PercentageTolerance>create(PercentageToleranceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PercentageTolerance> validator() {
		return new PercentageToleranceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PercentageTolerance> typeFormatValidator() {
		return new PercentageToleranceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PercentageTolerance, Set<String>> onlyExistsValidator() {
		return new PercentageToleranceOnlyExistsValidator();
	}
}
