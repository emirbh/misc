package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.InterestAccrualsMethod;
import fpml.consolidated.shared.validation.InterestAccrualsMethodTypeFormatValidator;
import fpml.consolidated.shared.validation.InterestAccrualsMethodValidator;
import fpml.consolidated.shared.validation.datarule.InterestAccrualsMethodChoice;
import fpml.consolidated.shared.validation.exists.InterestAccrualsMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InterestAccrualsMethod.class)
public class InterestAccrualsMethodMeta implements RosettaMetaData<InterestAccrualsMethod> {

	@Override
	public List<Validator<? super InterestAccrualsMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InterestAccrualsMethod>create(InterestAccrualsMethodChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InterestAccrualsMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAccrualsMethod> validator(ValidatorFactory factory) {
		return factory.<InterestAccrualsMethod>create(InterestAccrualsMethodValidator.class);
	}

	@Override
	public Validator<? super InterestAccrualsMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestAccrualsMethod>create(InterestAccrualsMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestAccrualsMethod> validator() {
		return new InterestAccrualsMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestAccrualsMethod> typeFormatValidator() {
		return new InterestAccrualsMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAccrualsMethod, Set<String>> onlyExistsValidator() {
		return new InterestAccrualsMethodOnlyExistsValidator();
	}
}
