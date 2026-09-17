package fpml.consolidated.dividend.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.dividend.swaps.DividendSwapTransactionSupplement;
import fpml.consolidated.dividend.swaps.validation.DividendSwapTransactionSupplementTypeFormatValidator;
import fpml.consolidated.dividend.swaps.validation.DividendSwapTransactionSupplementValidator;
import fpml.consolidated.dividend.swaps.validation.datarule.DividendSwapTransactionSupplementChoice;
import fpml.consolidated.dividend.swaps.validation.exists.DividendSwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendSwapTransactionSupplement.class)
public class DividendSwapTransactionSupplementMeta implements RosettaMetaData<DividendSwapTransactionSupplement> {

	@Override
	public List<Validator<? super DividendSwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DividendSwapTransactionSupplement>create(DividendSwapTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendSwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendSwapTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<DividendSwapTransactionSupplement>create(DividendSwapTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super DividendSwapTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendSwapTransactionSupplement>create(DividendSwapTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendSwapTransactionSupplement> validator() {
		return new DividendSwapTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendSwapTransactionSupplement> typeFormatValidator() {
		return new DividendSwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendSwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new DividendSwapTransactionSupplementOnlyExistsValidator();
	}
}
