package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.PricingParameterShift;
import fpml.consolidated.riskdef.validation.PricingParameterShiftTypeFormatValidator;
import fpml.consolidated.riskdef.validation.PricingParameterShiftValidator;
import fpml.consolidated.riskdef.validation.datarule.PricingParameterShiftChoice;
import fpml.consolidated.riskdef.validation.exists.PricingParameterShiftOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingParameterShift.class)
public class PricingParameterShiftMeta implements RosettaMetaData<PricingParameterShift> {

	@Override
	public List<Validator<? super PricingParameterShift>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingParameterShift>create(PricingParameterShiftChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PricingParameterShift, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingParameterShift> validator(ValidatorFactory factory) {
		return factory.<PricingParameterShift>create(PricingParameterShiftValidator.class);
	}

	@Override
	public Validator<? super PricingParameterShift> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingParameterShift>create(PricingParameterShiftTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterShift> validator() {
		return new PricingParameterShiftValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingParameterShift> typeFormatValidator() {
		return new PricingParameterShiftTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingParameterShift, Set<String>> onlyExistsValidator() {
		return new PricingParameterShiftOnlyExistsValidator();
	}
}
