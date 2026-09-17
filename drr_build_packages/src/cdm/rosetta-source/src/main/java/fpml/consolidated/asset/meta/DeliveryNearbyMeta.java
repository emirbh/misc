package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.DeliveryNearby;
import fpml.consolidated.asset.validation.DeliveryNearbyTypeFormatValidator;
import fpml.consolidated.asset.validation.DeliveryNearbyValidator;
import fpml.consolidated.asset.validation.exists.DeliveryNearbyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeliveryNearby.class)
public class DeliveryNearbyMeta implements RosettaMetaData<DeliveryNearby> {

	@Override
	public List<Validator<? super DeliveryNearby>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeliveryNearby, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliveryNearby> validator(ValidatorFactory factory) {
		return factory.<DeliveryNearby>create(DeliveryNearbyValidator.class);
	}

	@Override
	public Validator<? super DeliveryNearby> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeliveryNearby>create(DeliveryNearbyTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryNearby> validator() {
		return new DeliveryNearbyValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeliveryNearby> typeFormatValidator() {
		return new DeliveryNearbyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliveryNearby, Set<String>> onlyExistsValidator() {
		return new DeliveryNearbyOnlyExistsValidator();
	}
}
