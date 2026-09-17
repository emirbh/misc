package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.InterestAmount;
import cdm.legaldocumentation.csa.validation.InterestAmountTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.InterestAmountValidator;
import cdm.legaldocumentation.csa.validation.exists.InterestAmountOnlyExistsValidator;
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
@RosettaMeta(model=InterestAmount.class)
public class InterestAmountMeta implements RosettaMetaData<InterestAmount> {

	@Override
	public List<Validator<? super InterestAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAmount> validator(ValidatorFactory factory) {
		return factory.<InterestAmount>create(InterestAmountValidator.class);
	}

	@Override
	public Validator<? super InterestAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InterestAmount>create(InterestAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InterestAmount> validator() {
		return new InterestAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InterestAmount> typeFormatValidator() {
		return new InterestAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAmount, Set<String>> onlyExistsValidator() {
		return new InterestAmountOnlyExistsValidator();
	}
}
