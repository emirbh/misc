package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.TransformTypeChoice;
import fpml.consolidated.validation.TransformTypeChoiceTypeFormatValidator;
import fpml.consolidated.validation.TransformTypeChoiceValidator;
import fpml.consolidated.validation.datarule.TransformTypeChoiceChoice;
import fpml.consolidated.validation.exists.TransformTypeChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TransformTypeChoice.class)
public class TransformTypeChoiceMeta implements RosettaMetaData<TransformTypeChoice> {

	@Override
	public List<Validator<? super TransformTypeChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TransformTypeChoice>create(TransformTypeChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TransformTypeChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransformTypeChoice> validator(ValidatorFactory factory) {
		return factory.<TransformTypeChoice>create(TransformTypeChoiceValidator.class);
	}

	@Override
	public Validator<? super TransformTypeChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransformTypeChoice>create(TransformTypeChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransformTypeChoice> validator() {
		return new TransformTypeChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransformTypeChoice> typeFormatValidator() {
		return new TransformTypeChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransformTypeChoice, Set<String>> onlyExistsValidator() {
		return new TransformTypeChoiceOnlyExistsValidator();
	}
}
