package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ElectricityDeliveryPoint;
import fpml.consolidated.com.validation.ElectricityDeliveryPointTypeFormatValidator;
import fpml.consolidated.com.validation.ElectricityDeliveryPointValidator;
import fpml.consolidated.com.validation.exists.ElectricityDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ElectricityDeliveryPoint.class)
public class ElectricityDeliveryPointMeta implements RosettaMetaData<ElectricityDeliveryPoint> {

	@Override
	public List<Validator<? super ElectricityDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ElectricityDeliveryPoint> validator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryPoint>create(ElectricityDeliveryPointValidator.class);
	}

	@Override
	public Validator<? super ElectricityDeliveryPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ElectricityDeliveryPoint>create(ElectricityDeliveryPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryPoint> validator() {
		return new ElectricityDeliveryPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ElectricityDeliveryPoint> typeFormatValidator() {
		return new ElectricityDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryPointOnlyExistsValidator();
	}
}
