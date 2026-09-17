package fpml.consolidated.variance.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.variance.swaps.VarianceSwap;
import fpml.consolidated.variance.swaps.validation.VarianceSwapTypeFormatValidator;
import fpml.consolidated.variance.swaps.validation.VarianceSwapValidator;
import fpml.consolidated.variance.swaps.validation.exists.VarianceSwapOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VarianceSwap.class)
public class VarianceSwapMeta implements RosettaMetaData<VarianceSwap> {

	@Override
	public List<Validator<? super VarianceSwap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VarianceSwap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VarianceSwap> validator(ValidatorFactory factory) {
		return factory.<VarianceSwap>create(VarianceSwapValidator.class);
	}

	@Override
	public Validator<? super VarianceSwap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VarianceSwap>create(VarianceSwapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VarianceSwap> validator() {
		return new VarianceSwapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VarianceSwap> typeFormatValidator() {
		return new VarianceSwapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceSwap, Set<String>> onlyExistsValidator() {
		return new VarianceSwapOnlyExistsValidator();
	}
}
