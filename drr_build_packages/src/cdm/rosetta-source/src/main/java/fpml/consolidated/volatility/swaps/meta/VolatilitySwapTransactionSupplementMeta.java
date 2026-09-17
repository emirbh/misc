package fpml.consolidated.volatility.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.volatility.swaps.VolatilitySwapTransactionSupplement;
import fpml.consolidated.volatility.swaps.validation.VolatilitySwapTransactionSupplementTypeFormatValidator;
import fpml.consolidated.volatility.swaps.validation.VolatilitySwapTransactionSupplementValidator;
import fpml.consolidated.volatility.swaps.validation.datarule.VolatilitySwapTransactionSupplementChoice;
import fpml.consolidated.volatility.swaps.validation.exists.VolatilitySwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VolatilitySwapTransactionSupplement.class)
public class VolatilitySwapTransactionSupplementMeta implements RosettaMetaData<VolatilitySwapTransactionSupplement> {

	@Override
	public List<Validator<? super VolatilitySwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<VolatilitySwapTransactionSupplement>create(VolatilitySwapTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VolatilitySwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<VolatilitySwapTransactionSupplement>create(VolatilitySwapTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VolatilitySwapTransactionSupplement>create(VolatilitySwapTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> validator() {
		return new VolatilitySwapTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VolatilitySwapTransactionSupplement> typeFormatValidator() {
		return new VolatilitySwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VolatilitySwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VolatilitySwapTransactionSupplementOnlyExistsValidator();
	}
}
