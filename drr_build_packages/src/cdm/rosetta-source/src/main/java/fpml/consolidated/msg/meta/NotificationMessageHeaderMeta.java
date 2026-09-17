package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.validation.NotificationMessageHeaderTypeFormatValidator;
import fpml.consolidated.msg.validation.NotificationMessageHeaderValidator;
import fpml.consolidated.msg.validation.exists.NotificationMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=NotificationMessageHeader.class)
public class NotificationMessageHeaderMeta implements RosettaMetaData<NotificationMessageHeader> {

	@Override
	public List<Validator<? super NotificationMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotificationMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotificationMessageHeader> validator(ValidatorFactory factory) {
		return factory.<NotificationMessageHeader>create(NotificationMessageHeaderValidator.class);
	}

	@Override
	public Validator<? super NotificationMessageHeader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotificationMessageHeader>create(NotificationMessageHeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotificationMessageHeader> validator() {
		return new NotificationMessageHeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotificationMessageHeader> typeFormatValidator() {
		return new NotificationMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotificationMessageHeader, Set<String>> onlyExistsValidator() {
		return new NotificationMessageHeaderOnlyExistsValidator();
	}
}
