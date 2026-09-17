package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.MarketDisruptionEvent;
import fpml.consolidated.com.validation.MarketDisruptionEventTypeFormatValidator;
import fpml.consolidated.com.validation.MarketDisruptionEventValidator;
import fpml.consolidated.com.validation.exists.MarketDisruptionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MarketDisruptionEvent.class)
public class MarketDisruptionEventMeta implements RosettaMetaData<MarketDisruptionEvent> {

	@Override
	public List<Validator<? super MarketDisruptionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarketDisruptionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarketDisruptionEvent> validator(ValidatorFactory factory) {
		return factory.<MarketDisruptionEvent>create(MarketDisruptionEventValidator.class);
	}

	@Override
	public Validator<? super MarketDisruptionEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarketDisruptionEvent>create(MarketDisruptionEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarketDisruptionEvent> validator() {
		return new MarketDisruptionEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MarketDisruptionEvent> typeFormatValidator() {
		return new MarketDisruptionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarketDisruptionEvent, Set<String>> onlyExistsValidator() {
		return new MarketDisruptionEventOnlyExistsValidator();
	}
}
