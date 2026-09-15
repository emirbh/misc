package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CorporateActionEvent;
import fpml.consolidated.business.events.validation.CorporateActionEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.CorporateActionEventValidator;
import fpml.consolidated.business.events.validation.exists.CorporateActionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorporateActionEvent.class)
public class CorporateActionEventMeta implements RosettaMetaData<CorporateActionEvent> {

	@Override
	public List<Validator<? super CorporateActionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorporateActionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorporateActionEvent> validator(ValidatorFactory factory) {
		return factory.<CorporateActionEvent>create(CorporateActionEventValidator.class);
	}

	@Override
	public Validator<? super CorporateActionEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorporateActionEvent>create(CorporateActionEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorporateActionEvent> validator() {
		return new CorporateActionEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorporateActionEvent> typeFormatValidator() {
		return new CorporateActionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorporateActionEvent, Set<String>> onlyExistsValidator() {
		return new CorporateActionEventOnlyExistsValidator();
	}
}
