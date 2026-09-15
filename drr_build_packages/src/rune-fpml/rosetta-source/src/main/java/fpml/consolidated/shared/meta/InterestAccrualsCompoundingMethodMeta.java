package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.InterestAccrualsCompoundingMethod;
import fpml.consolidated.shared.InterestAccrualsMethod;
import fpml.consolidated.shared.validation.InterestAccrualsCompoundingMethodTypeFormatValidator;
import fpml.consolidated.shared.validation.InterestAccrualsCompoundingMethodValidator;
import fpml.consolidated.shared.validation.datarule.InterestAccrualsMethodChoice;
import fpml.consolidated.shared.validation.exists.InterestAccrualsCompoundingMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestAccrualsCompoundingMethod.class)
public class InterestAccrualsCompoundingMethodMeta implements RosettaMetaData<InterestAccrualsCompoundingMethod> {

	@Override
	public List<Validator<? super InterestAccrualsCompoundingMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestAccrualsMethod>create(InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestAccrualsCompoundingMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> validator(ValidatorFactory factory) {
		return factory.<InterestAccrualsCompoundingMethod>create(InterestAccrualsCompoundingMethodValidator.class);
	}

	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestAccrualsCompoundingMethod>create(InterestAccrualsCompoundingMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> validator() {
		return new InterestAccrualsCompoundingMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestAccrualsCompoundingMethod> typeFormatValidator() {
		return new InterestAccrualsCompoundingMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAccrualsCompoundingMethod, Set<String>> onlyExistsValidator() {
		return new InterestAccrualsCompoundingMethodOnlyExistsValidator();
	}
}
