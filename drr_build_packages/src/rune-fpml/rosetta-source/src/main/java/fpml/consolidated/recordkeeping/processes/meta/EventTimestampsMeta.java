package fpml.consolidated.recordkeeping.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.recordkeeping.processes.EventTimestamps;
import fpml.consolidated.recordkeeping.processes.validation.EventTimestampsTypeFormatValidator;
import fpml.consolidated.recordkeeping.processes.validation.EventTimestampsValidator;
import fpml.consolidated.recordkeeping.processes.validation.exists.EventTimestampsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventTimestamps.class)
public class EventTimestampsMeta implements RosettaMetaData<EventTimestamps> {

	@Override
	public List<Validator<? super EventTimestamps>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventTimestamps, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventTimestamps> validator(ValidatorFactory factory) {
		return factory.<EventTimestamps>create(EventTimestampsValidator.class);
	}

	@Override
	public Validator<? super EventTimestamps> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventTimestamps>create(EventTimestampsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventTimestamps> validator() {
		return new EventTimestampsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventTimestamps> typeFormatValidator() {
		return new EventTimestampsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventTimestamps, Set<String>> onlyExistsValidator() {
		return new EventTimestampsOnlyExistsValidator();
	}
}
