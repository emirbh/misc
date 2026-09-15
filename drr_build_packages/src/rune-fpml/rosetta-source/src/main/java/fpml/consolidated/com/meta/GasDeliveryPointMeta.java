package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.GasDeliveryPoint;
import fpml.consolidated.com.validation.GasDeliveryPointTypeFormatValidator;
import fpml.consolidated.com.validation.GasDeliveryPointValidator;
import fpml.consolidated.com.validation.exists.GasDeliveryPointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GasDeliveryPoint.class)
public class GasDeliveryPointMeta implements RosettaMetaData<GasDeliveryPoint> {

	@Override
	public List<Validator<? super GasDeliveryPoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GasDeliveryPoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GasDeliveryPoint> validator(ValidatorFactory factory) {
		return factory.<GasDeliveryPoint>create(GasDeliveryPointValidator.class);
	}

	@Override
	public Validator<? super GasDeliveryPoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GasDeliveryPoint>create(GasDeliveryPointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GasDeliveryPoint> validator() {
		return new GasDeliveryPointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GasDeliveryPoint> typeFormatValidator() {
		return new GasDeliveryPointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliveryPoint, Set<String>> onlyExistsValidator() {
		return new GasDeliveryPointOnlyExistsValidator();
	}
}
