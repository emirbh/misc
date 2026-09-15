package drr.base.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import drr.base.trade.validation.PayoutLegWithAuxiliaryTypeFormatValidator;
import drr.base.trade.validation.PayoutLegWithAuxiliaryValidator;
import drr.base.trade.validation.datarule.PayoutLegOneOf0;
import drr.base.trade.validation.datarule.PayoutLegWithAuxiliaryFixedOrCommodityPayout;
import drr.base.trade.validation.exists.PayoutLegWithAuxiliaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=PayoutLegWithAuxiliary.class)
public class PayoutLegWithAuxiliaryMeta implements RosettaMetaData<PayoutLegWithAuxiliary> {

	@Override
	public List<Validator<? super PayoutLegWithAuxiliary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PayoutLeg>create(PayoutLegOneOf0.class),
			factory.<PayoutLegWithAuxiliary>create(PayoutLegWithAuxiliaryFixedOrCommodityPayout.class)
		);
	}
	
	@Override
	public List<Function<? super PayoutLegWithAuxiliary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PayoutLegWithAuxiliary> validator(ValidatorFactory factory) {
		return factory.<PayoutLegWithAuxiliary>create(PayoutLegWithAuxiliaryValidator.class);
	}

	@Override
	public Validator<? super PayoutLegWithAuxiliary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PayoutLegWithAuxiliary>create(PayoutLegWithAuxiliaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PayoutLegWithAuxiliary> validator() {
		return new PayoutLegWithAuxiliaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PayoutLegWithAuxiliary> typeFormatValidator() {
		return new PayoutLegWithAuxiliaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PayoutLegWithAuxiliary, Set<String>> onlyExistsValidator() {
		return new PayoutLegWithAuxiliaryOnlyExistsValidator();
	}
}
