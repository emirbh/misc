package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeChangeAdviceException;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceExceptionTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceExceptionValidator;
import fpml.consolidated.confirmation.processes.validation.exists.TradeChangeAdviceExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeAdviceException.class)
public class TradeChangeAdviceExceptionMeta implements RosettaMetaData<TradeChangeAdviceException> {

	@Override
	public List<Validator<? super TradeChangeAdviceException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeAdviceException> validator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceException>create(TradeChangeAdviceExceptionValidator.class);
	}

	@Override
	public Validator<? super TradeChangeAdviceException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceException>create(TradeChangeAdviceExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceException> validator() {
		return new TradeChangeAdviceExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceException> typeFormatValidator() {
		return new TradeChangeAdviceExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceException, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceExceptionOnlyExistsValidator();
	}
}
