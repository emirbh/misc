package fpml.consolidated.bond.option.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.bond.option.MakeWholeAmount;
import fpml.consolidated.bond.option.validation.MakeWholeAmountTypeFormatValidator;
import fpml.consolidated.bond.option.validation.MakeWholeAmountValidator;
import fpml.consolidated.bond.option.validation.exists.MakeWholeAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MakeWholeAmount.class)
public class MakeWholeAmountMeta implements RosettaMetaData<MakeWholeAmount> {

	@Override
	public List<Validator<? super MakeWholeAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MakeWholeAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MakeWholeAmount> validator(ValidatorFactory factory) {
		return factory.<MakeWholeAmount>create(MakeWholeAmountValidator.class);
	}

	@Override
	public Validator<? super MakeWholeAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MakeWholeAmount>create(MakeWholeAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MakeWholeAmount> validator() {
		return new MakeWholeAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MakeWholeAmount> typeFormatValidator() {
		return new MakeWholeAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MakeWholeAmount, Set<String>> onlyExistsValidator() {
		return new MakeWholeAmountOnlyExistsValidator();
	}
}
