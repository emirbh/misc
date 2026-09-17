package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendTransferEvent;
import fpml.consolidated.sec.lending.validation.SecLendTransferEventTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendTransferEventValidator;
import fpml.consolidated.sec.lending.validation.exists.SecLendTransferEventOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendTransferEvent.class)
public class SecLendTransferEventMeta implements RosettaMetaData<SecLendTransferEvent> {

	@Override
	public List<Validator<? super SecLendTransferEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecLendTransferEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendTransferEvent> validator(ValidatorFactory factory) {
		return factory.<SecLendTransferEvent>create(SecLendTransferEventValidator.class);
	}

	@Override
	public Validator<? super SecLendTransferEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendTransferEvent>create(SecLendTransferEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendTransferEvent> validator() {
		return new SecLendTransferEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendTransferEvent> typeFormatValidator() {
		return new SecLendTransferEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendTransferEvent, Set<String>> onlyExistsValidator() {
		return new SecLendTransferEventOnlyExistsValidator();
	}
}
