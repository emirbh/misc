package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.LegAmount;
import fpml.consolidated.eq.shared.validation.LegAmountTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.LegAmountValidator;
import fpml.consolidated.eq.shared.validation.datarule.LegAmountChoice0;
import fpml.consolidated.eq.shared.validation.datarule.LegAmountChoice1;
import fpml.consolidated.eq.shared.validation.exists.LegAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=LegAmount.class)
public class LegAmountMeta implements RosettaMetaData<LegAmount> {

	@Override
	public List<Validator<? super LegAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegAmount>create(LegAmountChoice0.class),
			factory.<LegAmount>create(LegAmountChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super LegAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegAmount> validator(ValidatorFactory factory) {
		return factory.<LegAmount>create(LegAmountValidator.class);
	}

	@Override
	public Validator<? super LegAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegAmount>create(LegAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegAmount> validator() {
		return new LegAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegAmount> typeFormatValidator() {
		return new LegAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegAmount, Set<String>> onlyExistsValidator() {
		return new LegAmountOnlyExistsValidator();
	}
}
