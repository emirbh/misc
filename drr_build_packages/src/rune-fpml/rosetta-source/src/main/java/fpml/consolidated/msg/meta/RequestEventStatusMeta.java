package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.RequestEventStatus;
import fpml.consolidated.msg.validation.RequestEventStatusTypeFormatValidator;
import fpml.consolidated.msg.validation.RequestEventStatusValidator;
import fpml.consolidated.msg.validation.exists.RequestEventStatusOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestEventStatus.class)
public class RequestEventStatusMeta implements RosettaMetaData<RequestEventStatus> {

	@Override
	public List<Validator<? super RequestEventStatus>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestEventStatus, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestEventStatus> validator(ValidatorFactory factory) {
		return factory.<RequestEventStatus>create(RequestEventStatusValidator.class);
	}

	@Override
	public Validator<? super RequestEventStatus> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestEventStatus>create(RequestEventStatusTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestEventStatus> validator() {
		return new RequestEventStatusValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestEventStatus> typeFormatValidator() {
		return new RequestEventStatusTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestEventStatus, Set<String>> onlyExistsValidator() {
		return new RequestEventStatusOnlyExistsValidator();
	}
}
