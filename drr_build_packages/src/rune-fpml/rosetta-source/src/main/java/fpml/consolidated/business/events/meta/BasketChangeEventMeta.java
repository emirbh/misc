package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BasketChangeEvent;
import fpml.consolidated.business.events.validation.BasketChangeEventTypeFormatValidator;
import fpml.consolidated.business.events.validation.BasketChangeEventValidator;
import fpml.consolidated.business.events.validation.exists.BasketChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasketChangeEvent.class)
public class BasketChangeEventMeta implements RosettaMetaData<BasketChangeEvent> {

	@Override
	public List<Validator<? super BasketChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketChangeEvent> validator(ValidatorFactory factory) {
		return factory.<BasketChangeEvent>create(BasketChangeEventValidator.class);
	}

	@Override
	public Validator<? super BasketChangeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketChangeEvent>create(BasketChangeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketChangeEvent> validator() {
		return new BasketChangeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketChangeEvent> typeFormatValidator() {
		return new BasketChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketChangeEvent, Set<String>> onlyExistsValidator() {
		return new BasketChangeEventOnlyExistsValidator();
	}
}
