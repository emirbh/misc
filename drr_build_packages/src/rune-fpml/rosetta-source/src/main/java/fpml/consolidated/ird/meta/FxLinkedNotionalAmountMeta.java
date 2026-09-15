package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FxLinkedNotionalAmount;
import fpml.consolidated.ird.validation.FxLinkedNotionalAmountTypeFormatValidator;
import fpml.consolidated.ird.validation.FxLinkedNotionalAmountValidator;
import fpml.consolidated.ird.validation.exists.FxLinkedNotionalAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxLinkedNotionalAmount.class)
public class FxLinkedNotionalAmountMeta implements RosettaMetaData<FxLinkedNotionalAmount> {

	@Override
	public List<Validator<? super FxLinkedNotionalAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxLinkedNotionalAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxLinkedNotionalAmount> validator(ValidatorFactory factory) {
		return factory.<FxLinkedNotionalAmount>create(FxLinkedNotionalAmountValidator.class);
	}

	@Override
	public Validator<? super FxLinkedNotionalAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxLinkedNotionalAmount>create(FxLinkedNotionalAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxLinkedNotionalAmount> validator() {
		return new FxLinkedNotionalAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxLinkedNotionalAmount> typeFormatValidator() {
		return new FxLinkedNotionalAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxLinkedNotionalAmount, Set<String>> onlyExistsValidator() {
		return new FxLinkedNotionalAmountOnlyExistsValidator();
	}
}
