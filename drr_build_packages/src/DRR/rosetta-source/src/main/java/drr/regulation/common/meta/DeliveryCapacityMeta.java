package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.DeliveryCapacity;
import drr.regulation.common.validation.DeliveryCapacityTypeFormatValidator;
import drr.regulation.common.validation.DeliveryCapacityValidator;
import drr.regulation.common.validation.exists.DeliveryCapacityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=DeliveryCapacity.class)
public class DeliveryCapacityMeta implements RosettaMetaData<DeliveryCapacity> {

	@Override
	public List<Validator<? super DeliveryCapacity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeliveryCapacity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliveryCapacity> validator(ValidatorFactory factory) {
		return factory.<DeliveryCapacity>create(DeliveryCapacityValidator.class);
	}

	@Override
	public Validator<? super DeliveryCapacity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeliveryCapacity>create(DeliveryCapacityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryCapacity> validator() {
		return new DeliveryCapacityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryCapacity> typeFormatValidator() {
		return new DeliveryCapacityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryCapacity, Set<String>> onlyExistsValidator() {
		return new DeliveryCapacityOnlyExistsValidator();
	}
}
