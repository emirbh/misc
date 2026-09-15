package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.Message;
import fpml.consolidated.msg.validation.MessageTypeFormatValidator;
import fpml.consolidated.msg.validation.MessageValidator;
import fpml.consolidated.msg.validation.exists.MessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Message.class)
public class MessageMeta implements RosettaMetaData<Message> {

	@Override
	public List<Validator<? super Message>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Message, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Message> validator(ValidatorFactory factory) {
		return factory.<Message>create(MessageValidator.class);
	}

	@Override
	public Validator<? super Message> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Message>create(MessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Message> validator() {
		return new MessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Message> typeFormatValidator() {
		return new MessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Message, Set<String>> onlyExistsValidator() {
		return new MessageOnlyExistsValidator();
	}
}
