package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.MessageAddress;
import fpml.consolidated.msg.validation.MessageAddressTypeFormatValidator;
import fpml.consolidated.msg.validation.MessageAddressValidator;
import fpml.consolidated.msg.validation.exists.MessageAddressOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MessageAddress.class)
public class MessageAddressMeta implements RosettaMetaData<MessageAddress> {

	@Override
	public List<Validator<? super MessageAddress>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MessageAddress, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MessageAddress> validator(ValidatorFactory factory) {
		return factory.<MessageAddress>create(MessageAddressValidator.class);
	}

	@Override
	public Validator<? super MessageAddress> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MessageAddress>create(MessageAddressTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MessageAddress> validator() {
		return new MessageAddressValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MessageAddress> typeFormatValidator() {
		return new MessageAddressTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MessageAddress, Set<String>> onlyExistsValidator() {
		return new MessageAddressOnlyExistsValidator();
	}
}
