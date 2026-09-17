package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyReturnAmount;
import cdm.legaldocumentation.csa.validation.LegacyReturnAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyReturnAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.LegacyReturnAmountOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=LegacyReturnAmount.class)
public class LegacyReturnAmountMeta implements RosettaMetaData<LegacyReturnAmount> {

	@Override
	public List<Validator<? super LegacyReturnAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegacyReturnAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyReturnAmount> validator(ValidatorFactory factory) {
		return factory.<LegacyReturnAmount>create(LegacyReturnAmountValidator.class);
	}

	@Override
	public Validator<? super LegacyReturnAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyReturnAmount>create(LegacyReturnAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyReturnAmount> validator() {
		return new LegacyReturnAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyReturnAmount> typeFormatValidator() {
		return new LegacyReturnAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyReturnAmount, Set<String>> onlyExistsValidator() {
		return new LegacyReturnAmountOnlyExistsValidator();
	}
}
