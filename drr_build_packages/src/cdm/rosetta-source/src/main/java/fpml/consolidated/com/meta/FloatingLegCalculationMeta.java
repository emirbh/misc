package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FloatingLegCalculation;
import fpml.consolidated.com.validation.FloatingLegCalculationTypeFormatValidator;
import fpml.consolidated.com.validation.FloatingLegCalculationValidator;
import fpml.consolidated.com.validation.datarule.FloatingLegCalculationChoice;
import fpml.consolidated.com.validation.exists.FloatingLegCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingLegCalculation.class)
public class FloatingLegCalculationMeta implements RosettaMetaData<FloatingLegCalculation> {

	@Override
	public List<Validator<? super FloatingLegCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FloatingLegCalculation>create(FloatingLegCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingLegCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingLegCalculation> validator(ValidatorFactory factory) {
		return factory.<FloatingLegCalculation>create(FloatingLegCalculationValidator.class);
	}

	@Override
	public Validator<? super FloatingLegCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingLegCalculation>create(FloatingLegCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingLegCalculation> validator() {
		return new FloatingLegCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingLegCalculation> typeFormatValidator() {
		return new FloatingLegCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingLegCalculation, Set<String>> onlyExistsValidator() {
		return new FloatingLegCalculationOnlyExistsValidator();
	}
}
