package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalDeliveryPoint;
import fpml.consolidated.com.validation.CoalDeliveryPointTypeFormatValidator;
import fpml.consolidated.com.validation.CoalDeliveryPointValidator;
import fpml.consolidated.com.validation.exists.CoalDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalDeliveryPoint.class)
public class CoalDeliveryPointMeta implements RosettaMetaData<CoalDeliveryPoint> {

	@Override
	public List<Validator<? super CoalDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalDeliveryPoint> validator(ValidatorFactory factory) {
		return factory.<CoalDeliveryPoint>create(CoalDeliveryPointValidator.class);
	}

	@Override
	public Validator<? super CoalDeliveryPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalDeliveryPoint>create(CoalDeliveryPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalDeliveryPoint> validator() {
		return new CoalDeliveryPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalDeliveryPoint> typeFormatValidator() {
		return new CoalDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new CoalDeliveryPointOnlyExistsValidator();
	}
}
