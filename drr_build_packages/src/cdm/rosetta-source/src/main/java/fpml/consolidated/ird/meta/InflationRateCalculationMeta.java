package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.InflationRateCalculation;
import fpml.consolidated.ird.validation.InflationRateCalculationTypeFormatValidator;
import fpml.consolidated.ird.validation.InflationRateCalculationValidator;
import fpml.consolidated.ird.validation.exists.InflationRateCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InflationRateCalculation.class)
public class InflationRateCalculationMeta implements RosettaMetaData<InflationRateCalculation> {

	@Override
	public List<Validator<? super InflationRateCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InflationRateCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InflationRateCalculation> validator(ValidatorFactory factory) {
		return factory.<InflationRateCalculation>create(InflationRateCalculationValidator.class);
	}

	@Override
	public Validator<? super InflationRateCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InflationRateCalculation>create(InflationRateCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InflationRateCalculation> validator() {
		return new InflationRateCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InflationRateCalculation> typeFormatValidator() {
		return new InflationRateCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationRateCalculation, Set<String>> onlyExistsValidator() {
		return new InflationRateCalculationOnlyExistsValidator();
	}
}
