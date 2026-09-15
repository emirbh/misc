package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractFacilityRateChangeEvent;
import fpml.consolidated.loan.validation.AbstractFacilityRateChangeEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractFacilityRateChangeEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractFacilityRateChangeEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractFacilityRateChangeEvent.class)
public class AbstractFacilityRateChangeEventMeta implements RosettaMetaData<AbstractFacilityRateChangeEvent> {

	@Override
	public List<Validator<? super AbstractFacilityRateChangeEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractFacilityRateChangeEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractFacilityRateChangeEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractFacilityRateChangeEvent>create(AbstractFacilityRateChangeEventValidator.class);
	}

	@Override
	public Validator<? super AbstractFacilityRateChangeEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractFacilityRateChangeEvent>create(AbstractFacilityRateChangeEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityRateChangeEvent> validator() {
		return new AbstractFacilityRateChangeEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractFacilityRateChangeEvent> typeFormatValidator() {
		return new AbstractFacilityRateChangeEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractFacilityRateChangeEvent, Set<String>> onlyExistsValidator() {
		return new AbstractFacilityRateChangeEventOnlyExistsValidator();
	}
}
