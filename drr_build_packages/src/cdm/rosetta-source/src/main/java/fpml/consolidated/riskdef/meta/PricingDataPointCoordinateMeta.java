package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingDataPointCoordinate;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateValidator;
import fpml.consolidated.riskdef.validation.exists.PricingDataPointCoordinateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingDataPointCoordinate.class)
public class PricingDataPointCoordinateMeta implements RosettaMetaData<PricingDataPointCoordinate> {

	@Override
	public List<Validator<? super PricingDataPointCoordinate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingDataPointCoordinate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingDataPointCoordinate> validator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinate>create(PricingDataPointCoordinateValidator.class);
	}

	@Override
	public Validator<? super PricingDataPointCoordinate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinate>create(PricingDataPointCoordinateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinate> validator() {
		return new PricingDataPointCoordinateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinate> typeFormatValidator() {
		return new PricingDataPointCoordinateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingDataPointCoordinate, Set<String>> onlyExistsValidator() {
		return new PricingDataPointCoordinateOnlyExistsValidator();
	}
}
