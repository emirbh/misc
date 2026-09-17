package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.validation.AbstractLcEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLcEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLcEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLcEvent.class)
public class AbstractLcEventMeta implements RosettaMetaData<AbstractLcEvent> {

	@Override
	public List<Validator<? super AbstractLcEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLcEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLcEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLcEvent>create(AbstractLcEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLcEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLcEvent>create(AbstractLcEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLcEvent> validator() {
		return new AbstractLcEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLcEvent> typeFormatValidator() {
		return new AbstractLcEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLcEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLcEventOnlyExistsValidator();
	}
}
