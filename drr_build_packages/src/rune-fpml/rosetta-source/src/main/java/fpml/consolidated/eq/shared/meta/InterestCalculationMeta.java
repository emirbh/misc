package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.InterestCalculation;
import fpml.consolidated.eq.shared.validation.InterestCalculationTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.InterestCalculationValidator;
import fpml.consolidated.eq.shared.validation.exists.InterestCalculationOnlyExistsValidator;
import fpml.consolidated.shared.InterestAccrualsMethod;
import fpml.consolidated.shared.validation.datarule.InterestAccrualsMethodChoice;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestCalculation.class)
public class InterestCalculationMeta implements RosettaMetaData<InterestCalculation> {

	@Override
	public List<Validator<? super InterestCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestAccrualsMethod>create(InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestCalculation> validator(ValidatorFactory factory) {
		return factory.<InterestCalculation>create(InterestCalculationValidator.class);
	}

	@Override
	public Validator<? super InterestCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestCalculation>create(InterestCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestCalculation> validator() {
		return new InterestCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestCalculation> typeFormatValidator() {
		return new InterestCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestCalculation, Set<String>> onlyExistsValidator() {
		return new InterestCalculationOnlyExistsValidator();
	}
}
