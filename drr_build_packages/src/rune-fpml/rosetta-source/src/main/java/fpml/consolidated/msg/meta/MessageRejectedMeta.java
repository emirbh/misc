package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.MessageRejected;
import fpml.consolidated.msg.validation.MessageRejectedTypeFormatValidator;
import fpml.consolidated.msg.validation.MessageRejectedValidator;
import fpml.consolidated.msg.validation.exists.MessageRejectedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MessageRejected.class)
public class MessageRejectedMeta implements RosettaMetaData<MessageRejected> {

	@Override
	public List<Validator<? super MessageRejected>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageRejected, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MessageRejected> validator(ValidatorFactory factory) {
		return factory.<MessageRejected>create(MessageRejectedValidator.class);
	}

	@Override
	public Validator<? super MessageRejected> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MessageRejected>create(MessageRejectedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MessageRejected> validator() {
		return new MessageRejectedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MessageRejected> typeFormatValidator() {
		return new MessageRejectedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageRejected, Set<String>> onlyExistsValidator() {
		return new MessageRejectedOnlyExistsValidator();
	}
}
