package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.PeriodicPayment;
import fpml.consolidated.cd.validation.PeriodicPaymentTypeFormatValidator;
import fpml.consolidated.cd.validation.PeriodicPaymentValidator;
import fpml.consolidated.cd.validation.datarule.PeriodicPaymentChoice;
import fpml.consolidated.cd.validation.exists.PeriodicPaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PeriodicPayment.class)
public class PeriodicPaymentMeta implements RosettaMetaData<PeriodicPayment> {

	@Override
	public List<Validator<? super PeriodicPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PeriodicPayment>create(PeriodicPaymentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PeriodicPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PeriodicPayment> validator(ValidatorFactory factory) {
		return factory.<PeriodicPayment>create(PeriodicPaymentValidator.class);
	}

	@Override
	public Validator<? super PeriodicPayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PeriodicPayment>create(PeriodicPaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PeriodicPayment> validator() {
		return new PeriodicPaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PeriodicPayment> typeFormatValidator() {
		return new PeriodicPaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PeriodicPayment, Set<String>> onlyExistsValidator() {
		return new PeriodicPaymentOnlyExistsValidator();
	}
}
