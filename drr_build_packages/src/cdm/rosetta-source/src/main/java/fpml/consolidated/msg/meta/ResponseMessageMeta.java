package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ResponseMessage;
import fpml.consolidated.msg.validation.ResponseMessageTypeFormatValidator;
import fpml.consolidated.msg.validation.ResponseMessageValidator;
import fpml.consolidated.msg.validation.exists.ResponseMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResponseMessage.class)
public class ResponseMessageMeta implements RosettaMetaData<ResponseMessage> {

	@Override
	public List<Validator<? super ResponseMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResponseMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResponseMessage> validator(ValidatorFactory factory) {
		return factory.<ResponseMessage>create(ResponseMessageValidator.class);
	}

	@Override
	public Validator<? super ResponseMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResponseMessage>create(ResponseMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResponseMessage> validator() {
		return new ResponseMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResponseMessage> typeFormatValidator() {
		return new ResponseMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResponseMessage, Set<String>> onlyExistsValidator() {
		return new ResponseMessageOnlyExistsValidator();
	}
}
