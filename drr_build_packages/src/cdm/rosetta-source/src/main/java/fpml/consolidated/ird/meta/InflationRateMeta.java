package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.InflationRate;
import fpml.consolidated.ird.validation.InflationRateTypeFormatValidator;
import fpml.consolidated.ird.validation.InflationRateValidator;
import fpml.consolidated.ird.validation.exists.InflationRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InflationRate.class)
public class InflationRateMeta implements RosettaMetaData<InflationRate> {

	@Override
	public List<Validator<? super InflationRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InflationRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InflationRate> validator(ValidatorFactory factory) {
		return factory.<InflationRate>create(InflationRateValidator.class);
	}

	@Override
	public Validator<? super InflationRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InflationRate>create(InflationRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InflationRate> validator() {
		return new InflationRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InflationRate> typeFormatValidator() {
		return new InflationRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationRate, Set<String>> onlyExistsValidator() {
		return new InflationRateOnlyExistsValidator();
	}
}
