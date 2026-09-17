package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.business.events.validation.CompressionActivityTypeFormatValidator;
import fpml.consolidated.business.events.validation.CompressionActivityValidator;
import fpml.consolidated.business.events.validation.datarule.CompressionActivityChoice;
import fpml.consolidated.business.events.validation.exists.CompressionActivityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CompressionActivity.class)
public class CompressionActivityMeta implements RosettaMetaData<CompressionActivity> {

	@Override
	public List<Validator<? super CompressionActivity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CompressionActivity>create(CompressionActivityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CompressionActivity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CompressionActivity> validator(ValidatorFactory factory) {
		return factory.<CompressionActivity>create(CompressionActivityValidator.class);
	}

	@Override
	public Validator<? super CompressionActivity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CompressionActivity>create(CompressionActivityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CompressionActivity> validator() {
		return new CompressionActivityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CompressionActivity> typeFormatValidator() {
		return new CompressionActivityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CompressionActivity, Set<String>> onlyExistsValidator() {
		return new CompressionActivityOnlyExistsValidator();
	}
}
