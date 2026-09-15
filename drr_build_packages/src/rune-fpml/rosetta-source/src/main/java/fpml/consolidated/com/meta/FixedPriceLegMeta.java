package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FixedPriceLeg;
import fpml.consolidated.com.validation.FixedPriceLegTypeFormatValidator;
import fpml.consolidated.com.validation.FixedPriceLegValidator;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice0;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice1;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice2;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice3;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice4;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice5;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice6;
import fpml.consolidated.com.validation.datarule.FixedPriceLegChoice7;
import fpml.consolidated.com.validation.exists.FixedPriceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FixedPriceLeg.class)
public class FixedPriceLegMeta implements RosettaMetaData<FixedPriceLeg> {

	@Override
	public List<Validator<? super FixedPriceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FixedPriceLeg>create(FixedPriceLegChoice0.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice1.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice2.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice3.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice4.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice5.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice6.class),
			factory.<FixedPriceLeg>create(FixedPriceLegChoice7.class)
		);
	}
	
	@Override
	public List<Function<? super FixedPriceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedPriceLeg> validator(ValidatorFactory factory) {
		return factory.<FixedPriceLeg>create(FixedPriceLegValidator.class);
	}

	@Override
	public Validator<? super FixedPriceLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedPriceLeg>create(FixedPriceLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedPriceLeg> validator() {
		return new FixedPriceLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedPriceLeg> typeFormatValidator() {
		return new FixedPriceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPriceLeg, Set<String>> onlyExistsValidator() {
		return new FixedPriceLegOnlyExistsValidator();
	}
}
