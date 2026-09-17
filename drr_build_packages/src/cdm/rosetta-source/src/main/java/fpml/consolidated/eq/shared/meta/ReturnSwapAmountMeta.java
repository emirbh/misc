package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.LegAmount;
import fpml.consolidated.eq.shared.ReturnSwapAmount;
import fpml.consolidated.eq.shared.validation.ReturnSwapAmountTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.ReturnSwapAmountValidator;
import fpml.consolidated.eq.shared.validation.datarule.LegAmountChoice0;
import fpml.consolidated.eq.shared.validation.datarule.LegAmountChoice1;
import fpml.consolidated.eq.shared.validation.exists.ReturnSwapAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnSwapAmount.class)
public class ReturnSwapAmountMeta implements RosettaMetaData<ReturnSwapAmount> {

	@Override
	public List<Validator<? super ReturnSwapAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegAmount>create(LegAmountChoice0.class),
			factory.<LegAmount>create(LegAmountChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnSwapAmount> validator(ValidatorFactory factory) {
		return factory.<ReturnSwapAmount>create(ReturnSwapAmountValidator.class);
	}

	@Override
	public Validator<? super ReturnSwapAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnSwapAmount>create(ReturnSwapAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapAmount> validator() {
		return new ReturnSwapAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnSwapAmount> typeFormatValidator() {
		return new ReturnSwapAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapAmount, Set<String>> onlyExistsValidator() {
		return new ReturnSwapAmountOnlyExistsValidator();
	}
}
