package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EnvironmentalTrackingSystem;
import fpml.consolidated.com.validation.EnvironmentalTrackingSystemTypeFormatValidator;
import fpml.consolidated.com.validation.EnvironmentalTrackingSystemValidator;
import fpml.consolidated.com.validation.exists.EnvironmentalTrackingSystemOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EnvironmentalTrackingSystem.class)
public class EnvironmentalTrackingSystemMeta implements RosettaMetaData<EnvironmentalTrackingSystem> {

	@Override
	public List<Validator<? super EnvironmentalTrackingSystem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EnvironmentalTrackingSystem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EnvironmentalTrackingSystem> validator(ValidatorFactory factory) {
		return factory.<EnvironmentalTrackingSystem>create(EnvironmentalTrackingSystemValidator.class);
	}

	@Override
	public Validator<? super EnvironmentalTrackingSystem> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EnvironmentalTrackingSystem>create(EnvironmentalTrackingSystemTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalTrackingSystem> validator() {
		return new EnvironmentalTrackingSystemValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EnvironmentalTrackingSystem> typeFormatValidator() {
		return new EnvironmentalTrackingSystemTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EnvironmentalTrackingSystem, Set<String>> onlyExistsValidator() {
		return new EnvironmentalTrackingSystemOnlyExistsValidator();
	}
}
