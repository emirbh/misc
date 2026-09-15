package fpml.consolidated.dividend.swaps.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.dividend.swaps.FixedPaymentLeg;
import fpml.consolidated.dividend.swaps.validation.FixedPaymentLegTypeFormatValidator;
import fpml.consolidated.dividend.swaps.validation.FixedPaymentLegValidator;
import fpml.consolidated.dividend.swaps.validation.exists.FixedPaymentLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FixedPaymentLeg.class)
public class FixedPaymentLegMeta implements RosettaMetaData<FixedPaymentLeg> {

	@Override
	public List<Validator<? super FixedPaymentLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedPaymentLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedPaymentLeg> validator(ValidatorFactory factory) {
		return factory.<FixedPaymentLeg>create(FixedPaymentLegValidator.class);
	}

	@Override
	public Validator<? super FixedPaymentLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FixedPaymentLeg>create(FixedPaymentLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FixedPaymentLeg> validator() {
		return new FixedPaymentLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FixedPaymentLeg> typeFormatValidator() {
		return new FixedPaymentLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedPaymentLeg, Set<String>> onlyExistsValidator() {
		return new FixedPaymentLegOnlyExistsValidator();
	}
}
