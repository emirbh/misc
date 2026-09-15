package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.PayoutLeg;
import drr.base.trade.validation.PayoutLegTypeFormatValidator;
import drr.base.trade.validation.PayoutLegValidator;
import drr.base.trade.validation.datarule.PayoutLegOneOf0;
import drr.base.trade.validation.exists.PayoutLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=PayoutLeg.class)
public class PayoutLegMeta implements RosettaMetaData<PayoutLeg> {

	@Override
	public List<Validator<? super PayoutLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutLeg>create(PayoutLegOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super PayoutLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PayoutLeg> validator(ValidatorFactory factory) {
		return factory.<PayoutLeg>create(PayoutLegValidator.class);
	}

	@Override
	public Validator<? super PayoutLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PayoutLeg>create(PayoutLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PayoutLeg> validator() {
		return new PayoutLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PayoutLeg> typeFormatValidator() {
		return new PayoutLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PayoutLeg, Set<String>> onlyExistsValidator() {
		return new PayoutLegOnlyExistsValidator();
	}
}
