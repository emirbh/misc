package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CancellationEvent;
import fpml.consolidated.ird.validation.CancellationEventTypeFormatValidator;
import fpml.consolidated.ird.validation.CancellationEventValidator;
import fpml.consolidated.ird.validation.exists.CancellationEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CancellationEvent.class)
public class CancellationEventMeta implements RosettaMetaData<CancellationEvent> {

	@Override
	public List<Validator<? super CancellationEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CancellationEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CancellationEvent> validator(ValidatorFactory factory) {
		return factory.<CancellationEvent>create(CancellationEventValidator.class);
	}

	@Override
	public Validator<? super CancellationEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CancellationEvent>create(CancellationEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CancellationEvent> validator() {
		return new CancellationEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CancellationEvent> typeFormatValidator() {
		return new CancellationEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CancellationEvent, Set<String>> onlyExistsValidator() {
		return new CancellationEventOnlyExistsValidator();
	}
}
