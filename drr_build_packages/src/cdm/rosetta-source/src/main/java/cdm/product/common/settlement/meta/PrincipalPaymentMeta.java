package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.PrincipalPayment;
import cdm.product.common.settlement.validation.PrincipalPaymentTypeFormatValidator;
import cdm.product.common.settlement.validation.PrincipalPaymentValidator;
import cdm.product.common.settlement.validation.datarule.PrincipalPaymentDiscountFactor;
import cdm.product.common.settlement.validation.datarule.PrincipalPaymentPrincipalAmount;
import cdm.product.common.settlement.validation.exists.PrincipalPaymentOnlyExistsValidator;
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
@RosettaMeta(model=PrincipalPayment.class)
public class PrincipalPaymentMeta implements RosettaMetaData<PrincipalPayment> {

	@Override
	public List<Validator<? super PrincipalPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PrincipalPayment>create(PrincipalPaymentPrincipalAmount.class),
			factory.<PrincipalPayment>create(PrincipalPaymentDiscountFactor.class)
		);
	}
	
	@Override
	public List<Function<? super PrincipalPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalPayment> validator(ValidatorFactory factory) {
		return factory.<PrincipalPayment>create(PrincipalPaymentValidator.class);
	}

	@Override
	public Validator<? super PrincipalPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrincipalPayment>create(PrincipalPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalPayment> validator() {
		return new PrincipalPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrincipalPayment> typeFormatValidator() {
		return new PrincipalPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalPayment, Set<String>> onlyExistsValidator() {
		return new PrincipalPaymentOnlyExistsValidator();
	}
}
