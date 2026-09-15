package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDeliveryPeriods;
import fpml.consolidated.com.GasDeliveryPeriods;
import fpml.consolidated.com.validation.GasDeliveryPeriodsTypeFormatValidator;
import fpml.consolidated.com.validation.GasDeliveryPeriodsValidator;
import fpml.consolidated.com.validation.datarule.CommodityDeliveryPeriodsChoice;
import fpml.consolidated.com.validation.exists.GasDeliveryPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GasDeliveryPeriods.class)
public class GasDeliveryPeriodsMeta implements RosettaMetaData<GasDeliveryPeriods> {

	@Override
	public List<Validator<? super GasDeliveryPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityDeliveryPeriods>create(CommodityDeliveryPeriodsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasDeliveryPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GasDeliveryPeriods> validator(ValidatorFactory factory) {
		return factory.<GasDeliveryPeriods>create(GasDeliveryPeriodsValidator.class);
	}

	@Override
	public Validator<? super GasDeliveryPeriods> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GasDeliveryPeriods>create(GasDeliveryPeriodsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GasDeliveryPeriods> validator() {
		return new GasDeliveryPeriodsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GasDeliveryPeriods> typeFormatValidator() {
		return new GasDeliveryPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasDeliveryPeriods, Set<String>> onlyExistsValidator() {
		return new GasDeliveryPeriodsOnlyExistsValidator();
	}
}
