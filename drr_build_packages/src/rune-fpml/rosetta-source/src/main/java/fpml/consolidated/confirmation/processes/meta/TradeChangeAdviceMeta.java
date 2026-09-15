package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeChangeAdvice;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceValidator;
import fpml.consolidated.confirmation.processes.validation.exists.TradeChangeAdviceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeAdvice.class)
public class TradeChangeAdviceMeta implements RosettaMetaData<TradeChangeAdvice> {

	@Override
	public List<Validator<? super TradeChangeAdvice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdvice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeAdvice> validator(ValidatorFactory factory) {
		return factory.<TradeChangeAdvice>create(TradeChangeAdviceValidator.class);
	}

	@Override
	public Validator<? super TradeChangeAdvice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeAdvice>create(TradeChangeAdviceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdvice> validator() {
		return new TradeChangeAdviceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdvice> typeFormatValidator() {
		return new TradeChangeAdviceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdvice, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceOnlyExistsValidator();
	}
}
