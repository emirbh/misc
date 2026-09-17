package fpml.consolidated.variance.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.variance.swaps.VarianceOptionTransactionSupplement;
import fpml.consolidated.variance.swaps.validation.VarianceOptionTransactionSupplementTypeFormatValidator;
import fpml.consolidated.variance.swaps.validation.VarianceOptionTransactionSupplementValidator;
import fpml.consolidated.variance.swaps.validation.datarule.VarianceOptionTransactionSupplementChoice;
import fpml.consolidated.variance.swaps.validation.exists.VarianceOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VarianceOptionTransactionSupplement.class)
public class VarianceOptionTransactionSupplementMeta implements RosettaMetaData<VarianceOptionTransactionSupplement> {

	@Override
	public List<Validator<? super VarianceOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<VarianceOptionTransactionSupplement>create(VarianceOptionTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super VarianceOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VarianceOptionTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<VarianceOptionTransactionSupplement>create(VarianceOptionTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super VarianceOptionTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VarianceOptionTransactionSupplement>create(VarianceOptionTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VarianceOptionTransactionSupplement> validator() {
		return new VarianceOptionTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VarianceOptionTransactionSupplement> typeFormatValidator() {
		return new VarianceOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new VarianceOptionTransactionSupplementOnlyExistsValidator();
	}
}
