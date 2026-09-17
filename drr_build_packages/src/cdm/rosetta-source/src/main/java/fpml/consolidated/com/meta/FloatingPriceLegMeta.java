package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FloatingPriceLeg;
import fpml.consolidated.com.validation.FloatingPriceLegTypeFormatValidator;
import fpml.consolidated.com.validation.FloatingPriceLegValidator;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice0;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice1;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice2;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice3;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice4;
import fpml.consolidated.com.validation.datarule.FloatingPriceLegChoice5;
import fpml.consolidated.com.validation.exists.FloatingPriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingPriceLeg.class)
public class FloatingPriceLegMeta implements RosettaMetaData<FloatingPriceLeg> {

	@Override
	public List<Validator<? super FloatingPriceLeg>> dataRules(ValidatorFactory factory) {
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
	public List<Function<? super FloatingPriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingPriceLeg> validator(ValidatorFactory factory) {
		return factory.<FloatingPriceLeg>create(FloatingPriceLegValidator.class);
	}

	@Override
	public Validator<? super FloatingPriceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingPriceLeg>create(FloatingPriceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingPriceLeg> validator() {
		return new FloatingPriceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingPriceLeg> typeFormatValidator() {
		return new FloatingPriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingPriceLeg, Set<String>> onlyExistsValidator() {
		return new FloatingPriceLegOnlyExistsValidator();
	}
}
