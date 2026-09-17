package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.ird.validation.CollateralizedCashPriceMethodTypeFormatValidator;
import fpml.consolidated.ird.validation.CollateralizedCashPriceMethodValidator;
import fpml.consolidated.ird.validation.exists.CollateralizedCashPriceMethodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralizedCashPriceMethod.class)
public class CollateralizedCashPriceMethodMeta implements RosettaMetaData<CollateralizedCashPriceMethod> {

	@Override
	public List<Validator<? super CollateralizedCashPriceMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralizedCashPriceMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralizedCashPriceMethod> validator(ValidatorFactory factory) {
		return factory.<CollateralizedCashPriceMethod>create(CollateralizedCashPriceMethodValidator.class);
	}

	@Override
	public Validator<? super CollateralizedCashPriceMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralizedCashPriceMethod>create(CollateralizedCashPriceMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizedCashPriceMethod> validator() {
		return new CollateralizedCashPriceMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralizedCashPriceMethod> typeFormatValidator() {
		return new CollateralizedCashPriceMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralizedCashPriceMethod, Set<String>> onlyExistsValidator() {
		return new CollateralizedCashPriceMethodOnlyExistsValidator();
	}
}
