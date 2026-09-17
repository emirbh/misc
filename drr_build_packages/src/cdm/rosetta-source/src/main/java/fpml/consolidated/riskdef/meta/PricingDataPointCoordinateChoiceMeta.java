package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingDataPointCoordinateChoice;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateChoiceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingDataPointCoordinateChoiceValidator;
import fpml.consolidated.riskdef.validation.datarule.PricingDataPointCoordinateChoiceChoice;
import fpml.consolidated.riskdef.validation.exists.PricingDataPointCoordinateChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingDataPointCoordinateChoice.class)
public class PricingDataPointCoordinateChoiceMeta implements RosettaMetaData<PricingDataPointCoordinateChoice> {

	@Override
	public List<Validator<? super PricingDataPointCoordinateChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingDataPointCoordinateChoice>create(PricingDataPointCoordinateChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingDataPointCoordinateChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingDataPointCoordinateChoice> validator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinateChoice>create(PricingDataPointCoordinateChoiceValidator.class);
	}

	@Override
	public Validator<? super PricingDataPointCoordinateChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingDataPointCoordinateChoice>create(PricingDataPointCoordinateChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinateChoice> validator() {
		return new PricingDataPointCoordinateChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingDataPointCoordinateChoice> typeFormatValidator() {
		return new PricingDataPointCoordinateChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingDataPointCoordinateChoice, Set<String>> onlyExistsValidator() {
		return new PricingDataPointCoordinateChoiceOnlyExistsValidator();
	}
}
