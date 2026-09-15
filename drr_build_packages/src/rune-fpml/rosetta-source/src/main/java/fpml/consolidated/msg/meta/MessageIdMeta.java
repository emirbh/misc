package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.MessageId;
import fpml.consolidated.msg.validation.MessageIdTypeFormatValidator;
import fpml.consolidated.msg.validation.MessageIdValidator;
import fpml.consolidated.msg.validation.exists.MessageIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MessageId.class)
public class MessageIdMeta implements RosettaMetaData<MessageId> {

	@Override
	public List<Validator<? super MessageId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MessageId> validator(ValidatorFactory factory) {
		return factory.<MessageId>create(MessageIdValidator.class);
	}

	@Override
	public Validator<? super MessageId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MessageId>create(MessageIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MessageId> validator() {
		return new MessageIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MessageId> typeFormatValidator() {
		return new MessageIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageId, Set<String>> onlyExistsValidator() {
		return new MessageIdOnlyExistsValidator();
	}
}
