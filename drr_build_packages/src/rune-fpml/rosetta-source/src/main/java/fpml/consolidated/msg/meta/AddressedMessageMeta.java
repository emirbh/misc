package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.AddressedMessage;
import fpml.consolidated.msg.validation.AddressedMessageTypeFormatValidator;
import fpml.consolidated.msg.validation.AddressedMessageValidator;
import fpml.consolidated.msg.validation.exists.AddressedMessageOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AddressedMessage.class)
public class AddressedMessageMeta implements RosettaMetaData<AddressedMessage> {

	@Override
	public List<Validator<? super AddressedMessage>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AddressedMessage, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AddressedMessage> validator(ValidatorFactory factory) {
		return factory.<AddressedMessage>create(AddressedMessageValidator.class);
	}

	@Override
	public Validator<? super AddressedMessage> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AddressedMessage>create(AddressedMessageTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AddressedMessage> validator() {
		return new AddressedMessageValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AddressedMessage> typeFormatValidator() {
		return new AddressedMessageTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AddressedMessage, Set<String>> onlyExistsValidator() {
		return new AddressedMessageOnlyExistsValidator();
	}
}
