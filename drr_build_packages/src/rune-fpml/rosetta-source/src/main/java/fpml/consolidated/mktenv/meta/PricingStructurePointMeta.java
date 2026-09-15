package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.PricingStructurePoint;
import fpml.consolidated.mktenv.validation.PricingStructurePointTypeFormatValidator;
import fpml.consolidated.mktenv.validation.PricingStructurePointValidator;
import fpml.consolidated.mktenv.validation.datarule.PricingStructurePointChoice0;
import fpml.consolidated.mktenv.validation.datarule.PricingStructurePointChoice1;
import fpml.consolidated.mktenv.validation.exists.PricingStructurePointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PricingStructurePoint.class)
public class PricingStructurePointMeta implements RosettaMetaData<PricingStructurePoint> {

	@Override
	public List<Validator<? super PricingStructurePoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingStructurePoint>create(PricingStructurePointChoice0.class),
			factory.<PricingStructurePoint>create(PricingStructurePointChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super PricingStructurePoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingStructurePoint> validator(ValidatorFactory factory) {
		return factory.<PricingStructurePoint>create(PricingStructurePointValidator.class);
	}

	@Override
	public Validator<? super PricingStructurePoint> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingStructurePoint>create(PricingStructurePointTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructurePoint> validator() {
		return new PricingStructurePointValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingStructurePoint> typeFormatValidator() {
		return new PricingStructurePointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructurePoint, Set<String>> onlyExistsValidator() {
		return new PricingStructurePointOnlyExistsValidator();
	}
}
