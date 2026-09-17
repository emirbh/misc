package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.RequestTradeReferenceInformationUpdateRetracted;
import fpml.consolidated.confirmation.processes.validation.RequestTradeReferenceInformationUpdateRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.RequestTradeReferenceInformationUpdateRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.RequestTradeReferenceInformationUpdateRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RequestTradeReferenceInformationUpdateRetracted.class)
public class RequestTradeReferenceInformationUpdateRetractedMeta implements RosettaMetaData<RequestTradeReferenceInformationUpdateRetracted> {

	@Override
	public List<Validator<? super RequestTradeReferenceInformationUpdateRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RequestTradeReferenceInformationUpdateRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdateRetracted> validator(ValidatorFactory factory) {
		return factory.<RequestTradeReferenceInformationUpdateRetracted>create(RequestTradeReferenceInformationUpdateRetractedValidator.class);
	}

	@Override
	public Validator<? super RequestTradeReferenceInformationUpdateRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RequestTradeReferenceInformationUpdateRetracted>create(RequestTradeReferenceInformationUpdateRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdateRetracted> validator() {
		return new RequestTradeReferenceInformationUpdateRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RequestTradeReferenceInformationUpdateRetracted> typeFormatValidator() {
		return new RequestTradeReferenceInformationUpdateRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RequestTradeReferenceInformationUpdateRetracted, Set<String>> onlyExistsValidator() {
		return new RequestTradeReferenceInformationUpdateRetractedOnlyExistsValidator();
	}
}
