package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.TradeChangeAdviceRetracted;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceRetractedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.TradeChangeAdviceRetractedValidator;
import fpml.consolidated.confirmation.processes.validation.exists.TradeChangeAdviceRetractedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TradeChangeAdviceRetracted.class)
public class TradeChangeAdviceRetractedMeta implements RosettaMetaData<TradeChangeAdviceRetracted> {

	@Override
	public List<Validator<? super TradeChangeAdviceRetracted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeChangeAdviceRetracted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeChangeAdviceRetracted> validator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceRetracted>create(TradeChangeAdviceRetractedValidator.class);
	}

	@Override
	public Validator<? super TradeChangeAdviceRetracted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeChangeAdviceRetracted>create(TradeChangeAdviceRetractedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceRetracted> validator() {
		return new TradeChangeAdviceRetractedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeChangeAdviceRetracted> typeFormatValidator() {
		return new TradeChangeAdviceRetractedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeChangeAdviceRetracted, Set<String>> onlyExistsValidator() {
		return new TradeChangeAdviceRetractedOnlyExistsValidator();
	}
}
