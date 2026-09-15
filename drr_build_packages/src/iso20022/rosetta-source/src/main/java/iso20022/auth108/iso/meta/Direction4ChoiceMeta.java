package iso20022.auth108.iso.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.iso.Direction4Choice;
import iso20022.auth108.iso.validation.Direction4ChoiceTypeFormatValidator;
import iso20022.auth108.iso.validation.Direction4ChoiceValidator;
import iso20022.auth108.iso.validation.datarule.Direction4ChoiceChoice;
import iso20022.auth108.iso.validation.exists.Direction4ChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Direction4Choice.class)
public class Direction4ChoiceMeta implements RosettaMetaData<Direction4Choice> {

	@Override
	public List<Validator<? super Direction4Choice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Direction4Choice>create(Direction4ChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Direction4Choice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Direction4Choice> validator(ValidatorFactory factory) {
		return factory.<Direction4Choice>create(Direction4ChoiceValidator.class);
	}

	@Override
	public Validator<? super Direction4Choice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Direction4Choice>create(Direction4ChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Direction4Choice> validator() {
		return new Direction4ChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Direction4Choice> typeFormatValidator() {
		return new Direction4ChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Direction4Choice, Set<String>> onlyExistsValidator() {
		return new Direction4ChoiceOnlyExistsValidator();
	}
}
