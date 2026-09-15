package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditChangeEvent;
import fpml.consolidated.business.events.validation.CreditChangeEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditChangeEventValidator;
import fpml.consolidated.business.events.validation.datarule.CreditChangeEventChoice;
import fpml.consolidated.business.events.validation.exists.CreditChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditChangeEvent.class)
public class CreditChangeEventMeta implements RosettaMetaData<CreditChangeEvent> {

	@Override
	public List<Validator<? super CreditChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditChangeEvent>create(CreditChangeEventChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditChangeEvent> validator(ValidatorFactory factory) {
		return factory.<CreditChangeEvent>create(CreditChangeEventValidator.class);
	}

	@Override
	public Validator<? super CreditChangeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditChangeEvent>create(CreditChangeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditChangeEvent> validator() {
		return new CreditChangeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditChangeEvent> typeFormatValidator() {
		return new CreditChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditChangeEvent, Set<String>> onlyExistsValidator() {
		return new CreditChangeEventOnlyExistsValidator();
	}
}
