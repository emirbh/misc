package fpml.consolidated.fpmlreturn.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.fpmlreturn.swaps.validation.EquitySwapTransactionSupplementTypeFormatValidator;
import fpml.consolidated.fpmlreturn.swaps.validation.EquitySwapTransactionSupplementValidator;
import fpml.consolidated.fpmlreturn.swaps.validation.datarule.EquitySwapTransactionSupplementChoice0;
import fpml.consolidated.fpmlreturn.swaps.validation.datarule.EquitySwapTransactionSupplementChoice1;
import fpml.consolidated.fpmlreturn.swaps.validation.exists.EquitySwapTransactionSupplementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EquitySwapTransactionSupplement.class)
public class EquitySwapTransactionSupplementMeta implements RosettaMetaData<EquitySwapTransactionSupplement> {

	@Override
	public List<Validator<? super EquitySwapTransactionSupplement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<EquitySwapTransactionSupplement>create(EquitySwapTransactionSupplementChoice0.class),
			factory.<EquitySwapTransactionSupplement>create(EquitySwapTransactionSupplementChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super EquitySwapTransactionSupplement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquitySwapTransactionSupplement> validator(ValidatorFactory factory) {
		return factory.<EquitySwapTransactionSupplement>create(EquitySwapTransactionSupplementValidator.class);
	}

	@Override
	public Validator<? super EquitySwapTransactionSupplement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquitySwapTransactionSupplement>create(EquitySwapTransactionSupplementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquitySwapTransactionSupplement> validator() {
		return new EquitySwapTransactionSupplementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquitySwapTransactionSupplement> typeFormatValidator() {
		return new EquitySwapTransactionSupplementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquitySwapTransactionSupplement, Set<String>> onlyExistsValidator() {
		return new EquitySwapTransactionSupplementOnlyExistsValidator();
	}
}
