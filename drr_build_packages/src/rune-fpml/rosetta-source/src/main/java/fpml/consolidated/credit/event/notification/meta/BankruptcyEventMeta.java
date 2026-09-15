package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.BankruptcyEvent;
import fpml.consolidated.credit.event.notification.validation.BankruptcyEventTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.BankruptcyEventValidator;
import fpml.consolidated.credit.event.notification.validation.exists.BankruptcyEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BankruptcyEvent.class)
public class BankruptcyEventMeta implements RosettaMetaData<BankruptcyEvent> {

	@Override
	public List<Validator<? super BankruptcyEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BankruptcyEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BankruptcyEvent> validator(ValidatorFactory factory) {
		return factory.<BankruptcyEvent>create(BankruptcyEventValidator.class);
	}

	@Override
	public Validator<? super BankruptcyEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BankruptcyEvent>create(BankruptcyEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BankruptcyEvent> validator() {
		return new BankruptcyEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BankruptcyEvent> typeFormatValidator() {
		return new BankruptcyEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BankruptcyEvent, Set<String>> onlyExistsValidator() {
		return new BankruptcyEventOnlyExistsValidator();
	}
}
