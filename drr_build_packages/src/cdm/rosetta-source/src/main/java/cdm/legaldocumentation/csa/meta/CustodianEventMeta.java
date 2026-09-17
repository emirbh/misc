package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CustodianEvent;
import cdm.legaldocumentation.csa.validation.CustodianEventTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CustodianEventValidator;
import cdm.legaldocumentation.csa.validation.exists.CustodianEventOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CustodianEvent.class)
public class CustodianEventMeta implements RosettaMetaData<CustodianEvent> {

	@Override
	public List<Validator<? super CustodianEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianEvent> validator(ValidatorFactory factory) {
		return factory.<CustodianEvent>create(CustodianEventValidator.class);
	}

	@Override
	public Validator<? super CustodianEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CustodianEvent>create(CustodianEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CustodianEvent> validator() {
		return new CustodianEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CustodianEvent> typeFormatValidator() {
		return new CustodianEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianEvent, Set<String>> onlyExistsValidator() {
		return new CustodianEventOnlyExistsValidator();
	}
}
