package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.RequestRetransmission;
import fpml.consolidated.msg.validation.RequestRetransmissionTypeFormatValidator;
import fpml.consolidated.msg.validation.RequestRetransmissionValidator;
import fpml.consolidated.msg.validation.datarule.RequestRetransmissionChoice;
import fpml.consolidated.msg.validation.exists.RequestRetransmissionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestRetransmission.class)
public class RequestRetransmissionMeta implements RosettaMetaData<RequestRetransmission> {

	@Override
	public List<Validator<? super RequestRetransmission>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<RequestRetransmission>create(RequestRetransmissionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super RequestRetransmission, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestRetransmission> validator(ValidatorFactory factory) {
		return factory.<RequestRetransmission>create(RequestRetransmissionValidator.class);
	}

	@Override
	public Validator<? super RequestRetransmission> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestRetransmission>create(RequestRetransmissionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestRetransmission> validator() {
		return new RequestRetransmissionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestRetransmission> typeFormatValidator() {
		return new RequestRetransmissionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestRetransmission, Set<String>> onlyExistsValidator() {
		return new RequestRetransmissionOnlyExistsValidator();
	}
}
