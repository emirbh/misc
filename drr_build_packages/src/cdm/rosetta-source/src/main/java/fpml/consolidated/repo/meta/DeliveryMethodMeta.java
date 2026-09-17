package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.DeliveryMethod;
import fpml.consolidated.repo.validation.DeliveryMethodTypeFormatValidator;
import fpml.consolidated.repo.validation.DeliveryMethodValidator;
import fpml.consolidated.repo.validation.exists.DeliveryMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeliveryMethod.class)
public class DeliveryMethodMeta implements RosettaMetaData<DeliveryMethod> {

	@Override
	public List<Validator<? super DeliveryMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeliveryMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliveryMethod> validator(ValidatorFactory factory) {
		return factory.<DeliveryMethod>create(DeliveryMethodValidator.class);
	}

	@Override
	public Validator<? super DeliveryMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeliveryMethod>create(DeliveryMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryMethod> validator() {
		return new DeliveryMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryMethod> typeFormatValidator() {
		return new DeliveryMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryMethod, Set<String>> onlyExistsValidator() {
		return new DeliveryMethodOnlyExistsValidator();
	}
}
