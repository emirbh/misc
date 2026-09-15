package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.FeaturePayment;
import fpml.consolidated.option.shared.validation.FeaturePaymentTypeFormatValidator;
import fpml.consolidated.option.shared.validation.FeaturePaymentValidator;
import fpml.consolidated.option.shared.validation.datarule.FeaturePaymentChoice;
import fpml.consolidated.option.shared.validation.exists.FeaturePaymentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FeaturePayment.class)
public class FeaturePaymentMeta implements RosettaMetaData<FeaturePayment> {

	@Override
	public List<Validator<? super FeaturePayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FeaturePayment>create(FeaturePaymentChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FeaturePayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FeaturePayment> validator(ValidatorFactory factory) {
		return factory.<FeaturePayment>create(FeaturePaymentValidator.class);
	}

	@Override
	public Validator<? super FeaturePayment> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FeaturePayment>create(FeaturePaymentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FeaturePayment> validator() {
		return new FeaturePaymentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FeaturePayment> typeFormatValidator() {
		return new FeaturePaymentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FeaturePayment, Set<String>> onlyExistsValidator() {
		return new FeaturePaymentOnlyExistsValidator();
	}
}
