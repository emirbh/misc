package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AccruingPikPayment;
import fpml.consolidated.loan.validation.AccruingPikPaymentTypeFormatValidator;
import fpml.consolidated.loan.validation.AccruingPikPaymentValidator;
import fpml.consolidated.loan.validation.exists.AccruingPikPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccruingPikPayment.class)
public class AccruingPikPaymentMeta implements RosettaMetaData<AccruingPikPayment> {

	@Override
	public List<Validator<? super AccruingPikPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccruingPikPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccruingPikPayment> validator(ValidatorFactory factory) {
		return factory.<AccruingPikPayment>create(AccruingPikPaymentValidator.class);
	}

	@Override
	public Validator<? super AccruingPikPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccruingPikPayment>create(AccruingPikPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccruingPikPayment> validator() {
		return new AccruingPikPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccruingPikPayment> typeFormatValidator() {
		return new AccruingPikPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccruingPikPayment, Set<String>> onlyExistsValidator() {
		return new AccruingPikPaymentOnlyExistsValidator();
	}
}
