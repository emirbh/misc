package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.validation.OriginatingEventTypeFormatValidator;
import fpml.consolidated.shared.validation.OriginatingEventValidator;
import fpml.consolidated.shared.validation.exists.OriginatingEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OriginatingEvent.class)
public class OriginatingEventMeta implements RosettaMetaData<OriginatingEvent> {

	@Override
	public List<Validator<? super OriginatingEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OriginatingEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OriginatingEvent> validator(ValidatorFactory factory) {
		return factory.<OriginatingEvent>create(OriginatingEventValidator.class);
	}

	@Override
	public Validator<? super OriginatingEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OriginatingEvent>create(OriginatingEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OriginatingEvent> validator() {
		return new OriginatingEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OriginatingEvent> typeFormatValidator() {
		return new OriginatingEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OriginatingEvent, Set<String>> onlyExistsValidator() {
		return new OriginatingEventOnlyExistsValidator();
	}
}
