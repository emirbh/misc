package fpml.consolidated.eq.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.eq.shared.AdditionalPaymentAmount;
import fpml.consolidated.eq.shared.validation.AdditionalPaymentAmountTypeFormatValidator;
import fpml.consolidated.eq.shared.validation.AdditionalPaymentAmountValidator;
import fpml.consolidated.eq.shared.validation.exists.AdditionalPaymentAmountOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdditionalPaymentAmount.class)
public class AdditionalPaymentAmountMeta implements RosettaMetaData<AdditionalPaymentAmount> {

	@Override
	public List<Validator<? super AdditionalPaymentAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalPaymentAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalPaymentAmount> validator(ValidatorFactory factory) {
		return factory.<AdditionalPaymentAmount>create(AdditionalPaymentAmountValidator.class);
	}

	@Override
	public Validator<? super AdditionalPaymentAmount> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalPaymentAmount>create(AdditionalPaymentAmountTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalPaymentAmount> validator() {
		return new AdditionalPaymentAmountValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalPaymentAmount> typeFormatValidator() {
		return new AdditionalPaymentAmountTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalPaymentAmount, Set<String>> onlyExistsValidator() {
		return new AdditionalPaymentAmountOnlyExistsValidator();
	}
}
