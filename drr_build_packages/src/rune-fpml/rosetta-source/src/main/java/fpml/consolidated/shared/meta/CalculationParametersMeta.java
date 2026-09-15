package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.validation.CalculationParametersTypeFormatValidator;
import fpml.consolidated.shared.validation.CalculationParametersValidator;
import fpml.consolidated.shared.validation.datarule.CalculationParametersChoice;
import fpml.consolidated.shared.validation.exists.CalculationParametersOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculationParameters.class)
public class CalculationParametersMeta implements RosettaMetaData<CalculationParameters> {

	@Override
	public List<Validator<? super CalculationParameters>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CalculationParameters>create(CalculationParametersChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CalculationParameters, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculationParameters> validator(ValidatorFactory factory) {
		return factory.<CalculationParameters>create(CalculationParametersValidator.class);
	}

	@Override
	public Validator<? super CalculationParameters> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculationParameters>create(CalculationParametersTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculationParameters> validator() {
		return new CalculationParametersValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculationParameters> typeFormatValidator() {
		return new CalculationParametersTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculationParameters, Set<String>> onlyExistsValidator() {
		return new CalculationParametersOnlyExistsValidator();
	}
}
