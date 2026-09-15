package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FloatingAmountCalculation;
import fpml.consolidated.cd.validation.FloatingAmountCalculationTypeFormatValidator;
import fpml.consolidated.cd.validation.FloatingAmountCalculationValidator;
import fpml.consolidated.cd.validation.exists.FloatingAmountCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingAmountCalculation.class)
public class FloatingAmountCalculationMeta implements RosettaMetaData<FloatingAmountCalculation> {

	@Override
	public List<Validator<? super FloatingAmountCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingAmountCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingAmountCalculation> validator(ValidatorFactory factory) {
		return factory.<FloatingAmountCalculation>create(FloatingAmountCalculationValidator.class);
	}

	@Override
	public Validator<? super FloatingAmountCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingAmountCalculation>create(FloatingAmountCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountCalculation> validator() {
		return new FloatingAmountCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountCalculation> typeFormatValidator() {
		return new FloatingAmountCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingAmountCalculation, Set<String>> onlyExistsValidator() {
		return new FloatingAmountCalculationOnlyExistsValidator();
	}
}
