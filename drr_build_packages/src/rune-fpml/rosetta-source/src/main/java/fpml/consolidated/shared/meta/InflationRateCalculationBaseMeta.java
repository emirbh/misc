package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.InflationRateCalculationBase;
import fpml.consolidated.shared.validation.InflationRateCalculationBaseTypeFormatValidator;
import fpml.consolidated.shared.validation.InflationRateCalculationBaseValidator;
import fpml.consolidated.shared.validation.exists.InflationRateCalculationBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InflationRateCalculationBase.class)
public class InflationRateCalculationBaseMeta implements RosettaMetaData<InflationRateCalculationBase> {

	@Override
	public List<Validator<? super InflationRateCalculationBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InflationRateCalculationBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InflationRateCalculationBase> validator(ValidatorFactory factory) {
		return factory.<InflationRateCalculationBase>create(InflationRateCalculationBaseValidator.class);
	}

	@Override
	public Validator<? super InflationRateCalculationBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InflationRateCalculationBase>create(InflationRateCalculationBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InflationRateCalculationBase> validator() {
		return new InflationRateCalculationBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InflationRateCalculationBase> typeFormatValidator() {
		return new InflationRateCalculationBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InflationRateCalculationBase, Set<String>> onlyExistsValidator() {
		return new InflationRateCalculationBaseOnlyExistsValidator();
	}
}
