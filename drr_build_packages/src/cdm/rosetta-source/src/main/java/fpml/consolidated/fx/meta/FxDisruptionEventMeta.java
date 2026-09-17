package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.FxDisruptionEvent;
import fpml.consolidated.fx.validation.FxDisruptionEventTypeFormatValidator;
import fpml.consolidated.fx.validation.FxDisruptionEventValidator;
import fpml.consolidated.fx.validation.exists.FxDisruptionEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxDisruptionEvent.class)
public class FxDisruptionEventMeta implements RosettaMetaData<FxDisruptionEvent> {

	@Override
	public List<Validator<? super FxDisruptionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxDisruptionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxDisruptionEvent> validator(ValidatorFactory factory) {
		return factory.<FxDisruptionEvent>create(FxDisruptionEventValidator.class);
	}

	@Override
	public Validator<? super FxDisruptionEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxDisruptionEvent>create(FxDisruptionEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionEvent> validator() {
		return new FxDisruptionEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxDisruptionEvent> typeFormatValidator() {
		return new FxDisruptionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxDisruptionEvent, Set<String>> onlyExistsValidator() {
		return new FxDisruptionEventOnlyExistsValidator();
	}
}
