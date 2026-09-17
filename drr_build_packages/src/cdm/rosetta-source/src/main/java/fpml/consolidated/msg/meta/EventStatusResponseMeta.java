package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.EventStatusResponse;
import fpml.consolidated.msg.validation.EventStatusResponseTypeFormatValidator;
import fpml.consolidated.msg.validation.EventStatusResponseValidator;
import fpml.consolidated.msg.validation.exists.EventStatusResponseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EventStatusResponse.class)
public class EventStatusResponseMeta implements RosettaMetaData<EventStatusResponse> {

	@Override
	public List<Validator<? super EventStatusResponse>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EventStatusResponse, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EventStatusResponse> validator(ValidatorFactory factory) {
		return factory.<EventStatusResponse>create(EventStatusResponseValidator.class);
	}

	@Override
	public Validator<? super EventStatusResponse> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EventStatusResponse>create(EventStatusResponseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusResponse> validator() {
		return new EventStatusResponseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EventStatusResponse> typeFormatValidator() {
		return new EventStatusResponseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventStatusResponse, Set<String>> onlyExistsValidator() {
		return new EventStatusResponseOnlyExistsValidator();
	}
}
