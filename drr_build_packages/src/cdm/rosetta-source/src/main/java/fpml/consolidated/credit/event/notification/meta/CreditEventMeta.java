package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.CreditEvent;
import fpml.consolidated.credit.event.notification.validation.CreditEventTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.CreditEventValidator;
import fpml.consolidated.credit.event.notification.validation.exists.CreditEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEvent.class)
public class CreditEventMeta implements RosettaMetaData<CreditEvent> {

	@Override
	public List<Validator<? super CreditEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEvent> validator(ValidatorFactory factory) {
		return factory.<CreditEvent>create(CreditEventValidator.class);
	}

	@Override
	public Validator<? super CreditEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEvent>create(CreditEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEvent> validator() {
		return new CreditEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEvent> typeFormatValidator() {
		return new CreditEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEvent, Set<String>> onlyExistsValidator() {
		return new CreditEventOnlyExistsValidator();
	}
}
