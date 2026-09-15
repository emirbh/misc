package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestTradeReferenceInformationUpdate;
import fpml.consolidated.confirmation.processes.validation.RequestTradeReferenceInformationUpdateTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestTradeReferenceInformationUpdateValidator;
import fpml.consolidated.confirmation.processes.validation.exists.RequestTradeReferenceInformationUpdateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestTradeReferenceInformationUpdate.class)
public class RequestTradeReferenceInformationUpdateMeta implements RosettaMetaData<RequestTradeReferenceInformationUpdate> {

	@Override
	public List<Validator<? super RequestTradeReferenceInformationUpdate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestTradeReferenceInformationUpdate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdate> validator(ValidatorFactory factory) {
		return factory.<RequestTradeReferenceInformationUpdate>create(RequestTradeReferenceInformationUpdateValidator.class);
	}

	@Override
	public Validator<? super RequestTradeReferenceInformationUpdate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestTradeReferenceInformationUpdate>create(RequestTradeReferenceInformationUpdateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdate> validator() {
		return new RequestTradeReferenceInformationUpdateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdate> typeFormatValidator() {
		return new RequestTradeReferenceInformationUpdateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestTradeReferenceInformationUpdate, Set<String>> onlyExistsValidator() {
		return new RequestTradeReferenceInformationUpdateOnlyExistsValidator();
	}
}
