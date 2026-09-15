package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FloatingLeg;
import fpml.consolidated.com.FloatingPriceLeg;
import fpml.consolidated.com.validation.FloatingLegTypeFormatValidator;
import fpml.consolidated.com.validation.FloatingLegValidator;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice0;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice1;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice2;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice3;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice4;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice5;
import fpml.consolidated.com.validation.exists.FloatingLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingLeg.class)
public class FloatingLegMeta implements RosettaMetaData<FloatingLeg> {

	@Override
	public List<Validator<? super FloatingLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice0.class),
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice1.class),
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice2.class),
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice3.class),
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice4.class),
			factory.<FloatingPriceLeg>create(FloatingPriceLegChoice5.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingLeg> validator(ValidatorFactory factory) {
		return factory.<FloatingLeg>create(FloatingLegValidator.class);
	}

	@Override
	public Validator<? super FloatingLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingLeg>create(FloatingLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingLeg> validator() {
		return new FloatingLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingLeg> typeFormatValidator() {
		return new FloatingLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingLeg, Set<String>> onlyExistsValidator() {
		return new FloatingLegOnlyExistsValidator();
	}
}
