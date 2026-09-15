package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.Velocity;
import fpml.consolidated.business.events.validation.VelocityTypeFormatValidator;
import fpml.consolidated.business.events.validation.VelocityValidator;
import fpml.consolidated.business.events.validation.exists.VelocityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Velocity.class)
public class VelocityMeta implements RosettaMetaData<Velocity> {

	@Override
	public List<Validator<? super Velocity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Velocity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Velocity> validator(ValidatorFactory factory) {
		return factory.<Velocity>create(VelocityValidator.class);
	}

	@Override
	public Validator<? super Velocity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Velocity>create(VelocityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Velocity> validator() {
		return new VelocityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Velocity> typeFormatValidator() {
		return new VelocityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Velocity, Set<String>> onlyExistsValidator() {
		return new VelocityOnlyExistsValidator();
	}
}
