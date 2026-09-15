package fpml.consolidated.correlation.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.correlation.swaps.CorrelationAmount;
import fpml.consolidated.correlation.swaps.validation.CorrelationAmountTypeFormatValidator;
import fpml.consolidated.correlation.swaps.validation.CorrelationAmountValidator;
import fpml.consolidated.correlation.swaps.validation.exists.CorrelationAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CorrelationAmount.class)
public class CorrelationAmountMeta implements RosettaMetaData<CorrelationAmount> {

	@Override
	public List<Validator<? super CorrelationAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CorrelationAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CorrelationAmount> validator(ValidatorFactory factory) {
		return factory.<CorrelationAmount>create(CorrelationAmountValidator.class);
	}

	@Override
	public Validator<? super CorrelationAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CorrelationAmount>create(CorrelationAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationAmount> validator() {
		return new CorrelationAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CorrelationAmount> typeFormatValidator() {
		return new CorrelationAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CorrelationAmount, Set<String>> onlyExistsValidator() {
		return new CorrelationAmountOnlyExistsValidator();
	}
}
