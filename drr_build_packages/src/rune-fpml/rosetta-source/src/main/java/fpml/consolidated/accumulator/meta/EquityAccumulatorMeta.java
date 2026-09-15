package fpml.consolidated.accumulator.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.accumulator.EquityAccumulator;
import fpml.consolidated.accumulator.validation.EquityAccumulatorTypeFormatValidator;
import fpml.consolidated.accumulator.validation.EquityAccumulatorValidator;
import fpml.consolidated.accumulator.validation.exists.EquityAccumulatorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquityAccumulator.class)
public class EquityAccumulatorMeta implements RosettaMetaData<EquityAccumulator> {

	@Override
	public List<Validator<? super EquityAccumulator>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityAccumulator, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityAccumulator> validator(ValidatorFactory factory) {
		return factory.<EquityAccumulator>create(EquityAccumulatorValidator.class);
	}

	@Override
	public Validator<? super EquityAccumulator> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityAccumulator>create(EquityAccumulatorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityAccumulator> validator() {
		return new EquityAccumulatorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityAccumulator> typeFormatValidator() {
		return new EquityAccumulatorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityAccumulator, Set<String>> onlyExistsValidator() {
		return new EquityAccumulatorOnlyExistsValidator();
	}
}
