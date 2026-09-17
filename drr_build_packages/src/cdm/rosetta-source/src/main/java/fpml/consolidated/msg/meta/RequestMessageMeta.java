package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.RequestMessage;
import fpml.consolidated.msg.validation.RequestMessageTypeFormatValidator;
import fpml.consolidated.msg.validation.RequestMessageValidator;
import fpml.consolidated.msg.validation.exists.RequestMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestMessage.class)
public class RequestMessageMeta implements RosettaMetaData<RequestMessage> {

	@Override
	public List<Validator<? super RequestMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestMessage> validator(ValidatorFactory factory) {
		return factory.<RequestMessage>create(RequestMessageValidator.class);
	}

	@Override
	public Validator<? super RequestMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestMessage>create(RequestMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestMessage> validator() {
		return new RequestMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestMessage> typeFormatValidator() {
		return new RequestMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestMessage, Set<String>> onlyExistsValidator() {
		return new RequestMessageOnlyExistsValidator();
	}
}
