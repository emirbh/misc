package fpml.consolidated.variance.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.variance.swaps.VarianceSwapTransactionSupplement;
import fpml.consolidated.variance.swaps.validation.VarianceSwapTransactionSupplementTypeFormatValidator;
import fpml.consolidated.variance.swaps.validation.VarianceSwapTransactionSupplementValidator;
import fpml.consolidated.variance.swaps.validation.datarule.VarianceSwapTransactionSupplementChoice;
import fpml.consolidated.variance.swaps.validation.exists.VarianceSwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VarianceSwapTransactionSupplement.class)
public class VarianceSwapTransactionSupplementMeta implements RosettaMetaData<VarianceSwapTransactionSupplement> {

	@Override
	public List<Validator<? super VarianceSwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<VarianceSwapTransactionSupplement>create(VarianceSwapTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceSwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VarianceSwapTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<VarianceSwapTransactionSupplement>create(VarianceSwapTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super VarianceSwapTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VarianceSwapTransactionSupplement>create(VarianceSwapTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VarianceSwapTransactionSupplement> validator() {
		return new VarianceSwapTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VarianceSwapTransactionSupplement> typeFormatValidator() {
		return new VarianceSwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceSwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VarianceSwapTransactionSupplementOnlyExistsValidator();
	}
}
