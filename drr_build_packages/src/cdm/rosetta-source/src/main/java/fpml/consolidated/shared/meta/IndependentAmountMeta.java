package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IndependentAmount;
import fpml.consolidated.shared.validation.IndependentAmountTypeFormatValidator;
import fpml.consolidated.shared.validation.IndependentAmountValidator;
import fpml.consolidated.shared.validation.exists.IndependentAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IndependentAmount.class)
public class IndependentAmountMeta implements RosettaMetaData<IndependentAmount> {

	@Override
	public List<Validator<? super IndependentAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndependentAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndependentAmount> validator(ValidatorFactory factory) {
		return factory.<IndependentAmount>create(IndependentAmountValidator.class);
	}

	@Override
	public Validator<? super IndependentAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IndependentAmount>create(IndependentAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IndependentAmount> validator() {
		return new IndependentAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IndependentAmount> typeFormatValidator() {
		return new IndependentAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndependentAmount, Set<String>> onlyExistsValidator() {
		return new IndependentAmountOnlyExistsValidator();
	}
}
