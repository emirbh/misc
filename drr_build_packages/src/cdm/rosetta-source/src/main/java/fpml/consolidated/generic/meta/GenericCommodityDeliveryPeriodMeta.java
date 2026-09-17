package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.GenericCommodityDeliveryPeriod;
import fpml.consolidated.generic.validation.GenericCommodityDeliveryPeriodTypeFormatValidator;
import fpml.consolidated.generic.validation.GenericCommodityDeliveryPeriodValidator;
import fpml.consolidated.generic.validation.exists.GenericCommodityDeliveryPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericCommodityDeliveryPeriod.class)
public class GenericCommodityDeliveryPeriodMeta implements RosettaMetaData<GenericCommodityDeliveryPeriod> {

	@Override
	public List<Validator<? super GenericCommodityDeliveryPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericCommodityDeliveryPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> validator(ValidatorFactory factory) {
		return factory.<GenericCommodityDeliveryPeriod>create(GenericCommodityDeliveryPeriodValidator.class);
	}

	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericCommodityDeliveryPeriod>create(GenericCommodityDeliveryPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> validator() {
		return new GenericCommodityDeliveryPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericCommodityDeliveryPeriod> typeFormatValidator() {
		return new GenericCommodityDeliveryPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericCommodityDeliveryPeriod, Set<String>> onlyExistsValidator() {
		return new GenericCommodityDeliveryPeriodOnlyExistsValidator();
	}
}
