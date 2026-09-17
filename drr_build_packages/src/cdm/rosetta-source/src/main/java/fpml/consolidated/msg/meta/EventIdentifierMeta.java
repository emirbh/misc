package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.EventIdentifier;
import fpml.consolidated.msg.validation.EventIdentifierTypeFormatValidator;
import fpml.consolidated.msg.validation.EventIdentifierValidator;
import fpml.consolidated.msg.validation.datarule.EventIdentifierChoice;
import fpml.consolidated.msg.validation.exists.EventIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventIdentifier.class)
public class EventIdentifierMeta implements RosettaMetaData<EventIdentifier> {

	@Override
	public List<Validator<? super EventIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EventIdentifier>create(EventIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventIdentifier> validator(ValidatorFactory factory) {
		return factory.<EventIdentifier>create(EventIdentifierValidator.class);
	}

	@Override
	public Validator<? super EventIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventIdentifier>create(EventIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventIdentifier> validator() {
		return new EventIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventIdentifier> typeFormatValidator() {
		return new EventIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventIdentifier, Set<String>> onlyExistsValidator() {
		return new EventIdentifierOnlyExistsValidator();
	}
}
