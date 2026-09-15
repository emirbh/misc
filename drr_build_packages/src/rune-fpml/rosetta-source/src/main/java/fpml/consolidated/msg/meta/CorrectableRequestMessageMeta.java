package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.validation.CorrectableRequestMessageTypeFormatValidator;
import fpml.consolidated.msg.validation.CorrectableRequestMessageValidator;
import fpml.consolidated.msg.validation.exists.CorrectableRequestMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorrectableRequestMessage.class)
public class CorrectableRequestMessageMeta implements RosettaMetaData<CorrectableRequestMessage> {

	@Override
	public List<Validator<? super CorrectableRequestMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrectableRequestMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorrectableRequestMessage> validator(ValidatorFactory factory) {
		return factory.<CorrectableRequestMessage>create(CorrectableRequestMessageValidator.class);
	}

	@Override
	public Validator<? super CorrectableRequestMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorrectableRequestMessage>create(CorrectableRequestMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorrectableRequestMessage> validator() {
		return new CorrectableRequestMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorrectableRequestMessage> typeFormatValidator() {
		return new CorrectableRequestMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrectableRequestMessage, Set<String>> onlyExistsValidator() {
		return new CorrectableRequestMessageOnlyExistsValidator();
	}
}
