package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Calculation;
import fpml.consolidated.ird.validation.CalculationTypeFormatValidator;
import fpml.consolidated.ird.validation.CalculationValidator;
import fpml.consolidated.ird.validation.datarule.CalculationChoice0;
import fpml.consolidated.ird.validation.datarule.CalculationChoice1;
import fpml.consolidated.ird.validation.datarule.CalculationChoice2;
import fpml.consolidated.ird.validation.datarule.CalculationChoice3;
import fpml.consolidated.ird.validation.exists.CalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Calculation.class)
public class CalculationMeta implements RosettaMetaData<Calculation> {

	@Override
	public List<Validator<? super Calculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Calculation>create(CalculationChoice0.class),
			factory.<Calculation>create(CalculationChoice1.class),
			factory.<Calculation>create(CalculationChoice2.class),
			factory.<Calculation>create(CalculationChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super Calculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Calculation> validator(ValidatorFactory factory) {
		return factory.<Calculation>create(CalculationValidator.class);
	}

	@Override
	public Validator<? super Calculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Calculation>create(CalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Calculation> validator() {
		return new CalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Calculation> typeFormatValidator() {
		return new CalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Calculation, Set<String>> onlyExistsValidator() {
		return new CalculationOnlyExistsValidator();
	}
}
