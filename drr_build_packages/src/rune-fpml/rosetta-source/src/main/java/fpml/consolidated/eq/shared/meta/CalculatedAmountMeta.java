package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.CalculatedAmount;
import fpml.consolidated.eq.shared.validation.CalculatedAmountTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.CalculatedAmountValidator;
import fpml.consolidated.eq.shared.validation.exists.CalculatedAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CalculatedAmount.class)
public class CalculatedAmountMeta implements RosettaMetaData<CalculatedAmount> {

	@Override
	public List<Validator<? super CalculatedAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CalculatedAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CalculatedAmount> validator(ValidatorFactory factory) {
		return factory.<CalculatedAmount>create(CalculatedAmountValidator.class);
	}

	@Override
	public Validator<? super CalculatedAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CalculatedAmount>create(CalculatedAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CalculatedAmount> validator() {
		return new CalculatedAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CalculatedAmount> typeFormatValidator() {
		return new CalculatedAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CalculatedAmount, Set<String>> onlyExistsValidator() {
		return new CalculatedAmountOnlyExistsValidator();
	}
}
