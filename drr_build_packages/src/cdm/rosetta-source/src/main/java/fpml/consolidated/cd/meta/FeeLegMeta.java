package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FeeLeg;
import fpml.consolidated.cd.validation.FeeLegTypeFormatValidator;
import fpml.consolidated.cd.validation.FeeLegValidator;
import fpml.consolidated.cd.validation.datarule.FeeLegChoice0;
import fpml.consolidated.cd.validation.datarule.FeeLegChoice1;
import fpml.consolidated.cd.validation.exists.FeeLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FeeLeg.class)
public class FeeLegMeta implements RosettaMetaData<FeeLeg> {

	@Override
	public List<Validator<? super FeeLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FeeLeg>create(FeeLegChoice0.class),
			factory.<FeeLeg>create(FeeLegChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FeeLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FeeLeg> validator(ValidatorFactory factory) {
		return factory.<FeeLeg>create(FeeLegValidator.class);
	}

	@Override
	public Validator<? super FeeLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FeeLeg>create(FeeLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FeeLeg> validator() {
		return new FeeLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FeeLeg> typeFormatValidator() {
		return new FeeLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeeLeg, Set<String>> onlyExistsValidator() {
		return new FeeLegOnlyExistsValidator();
	}
}
