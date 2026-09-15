package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.AdditionalFixedPayments;
import fpml.consolidated.cd.validation.AdditionalFixedPaymentsTypeFormatValidator;
import fpml.consolidated.cd.validation.AdditionalFixedPaymentsValidator;
import fpml.consolidated.cd.validation.exists.AdditionalFixedPaymentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AdditionalFixedPayments.class)
public class AdditionalFixedPaymentsMeta implements RosettaMetaData<AdditionalFixedPayments> {

	@Override
	public List<Validator<? super AdditionalFixedPayments>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalFixedPayments, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalFixedPayments> validator(ValidatorFactory factory) {
		return factory.<AdditionalFixedPayments>create(AdditionalFixedPaymentsValidator.class);
	}

	@Override
	public Validator<? super AdditionalFixedPayments> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AdditionalFixedPayments>create(AdditionalFixedPaymentsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalFixedPayments> validator() {
		return new AdditionalFixedPaymentsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AdditionalFixedPayments> typeFormatValidator() {
		return new AdditionalFixedPaymentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalFixedPayments, Set<String>> onlyExistsValidator() {
		return new AdditionalFixedPaymentsOnlyExistsValidator();
	}
}
