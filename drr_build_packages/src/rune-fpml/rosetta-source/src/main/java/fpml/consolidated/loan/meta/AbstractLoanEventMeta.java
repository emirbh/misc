package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLoanEvent;
import fpml.consolidated.loan.validation.AbstractLoanEventTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLoanEventValidator;
import fpml.consolidated.loan.validation.exists.AbstractLoanEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLoanEvent.class)
public class AbstractLoanEventMeta implements RosettaMetaData<AbstractLoanEvent> {

	@Override
	public List<Validator<? super AbstractLoanEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLoanEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLoanEvent> validator(ValidatorFactory factory) {
		return factory.<AbstractLoanEvent>create(AbstractLoanEventValidator.class);
	}

	@Override
	public Validator<? super AbstractLoanEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLoanEvent>create(AbstractLoanEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanEvent> validator() {
		return new AbstractLoanEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLoanEvent> typeFormatValidator() {
		return new AbstractLoanEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLoanEvent, Set<String>> onlyExistsValidator() {
		return new AbstractLoanEventOnlyExistsValidator();
	}
}
