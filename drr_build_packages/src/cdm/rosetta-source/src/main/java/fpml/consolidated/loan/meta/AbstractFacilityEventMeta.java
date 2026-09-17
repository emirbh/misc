package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.validation.AbstractFacilityEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFacilityEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractFacilityEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFacilityEvent.class)
public class AbstractFacilityEventMeta implements RosettaMetaData<AbstractFacilityEvent> {

	@Override
	public List<Validator<? super AbstractFacilityEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFacilityEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractFacilityEvent>create(AbstractFacilityEventValidator.class);
	}

	@Override
	public Validator<? super AbstractFacilityEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFacilityEvent>create(AbstractFacilityEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityEvent> validator() {
		return new AbstractFacilityEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityEvent> typeFormatValidator() {
		return new AbstractFacilityEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityEvent, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityEventOnlyExistsValidator();
	}
}
