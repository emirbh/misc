package fpml.consolidated.dividend.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.dividend.swaps.DividendSwapOptionTransactionSupplement;
import fpml.consolidated.dividend.swaps.validation.DividendSwapOptionTransactionSupplementTypeFormatValidator;
import fpml.consolidated.dividend.swaps.validation.DividendSwapOptionTransactionSupplementValidator;
import fpml.consolidated.dividend.swaps.validation.datarule.DividendSwapOptionTransactionSupplementChoice;
import fpml.consolidated.dividend.swaps.validation.exists.DividendSwapOptionTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DividendSwapOptionTransactionSupplement.class)
public class DividendSwapOptionTransactionSupplementMeta implements RosettaMetaData<DividendSwapOptionTransactionSupplement> {

	@Override
	public List<Validator<? super DividendSwapOptionTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<DividendSwapOptionTransactionSupplement>create(DividendSwapOptionTransactionSupplementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super DividendSwapOptionTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<DividendSwapOptionTransactionSupplement>create(DividendSwapOptionTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DividendSwapOptionTransactionSupplement>create(DividendSwapOptionTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> validator() {
		return new DividendSwapOptionTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DividendSwapOptionTransactionSupplement> typeFormatValidator() {
		return new DividendSwapOptionTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendSwapOptionTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new DividendSwapOptionTransactionSupplementOnlyExistsValidator();
	}
}
