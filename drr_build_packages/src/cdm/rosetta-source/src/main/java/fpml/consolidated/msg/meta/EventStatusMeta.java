package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.EventStatus;
import fpml.consolidated.msg.validation.EventStatusTypeFormatValidator;
import fpml.consolidated.msg.validation.EventStatusValidator;
import fpml.consolidated.msg.validation.exists.EventStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventStatus.class)
public class EventStatusMeta implements RosettaMetaData<EventStatus> {

	@Override
	public List<Validator<? super EventStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventStatus> validator(ValidatorFactory factory) {
		return factory.<EventStatus>create(EventStatusValidator.class);
	}

	@Override
	public Validator<? super EventStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventStatus>create(EventStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventStatus> validator() {
		return new EventStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventStatus> typeFormatValidator() {
		return new EventStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventStatus, Set<String>> onlyExistsValidator() {
		return new EventStatusOnlyExistsValidator();
	}
}
