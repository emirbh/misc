package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.SettlementPeriodsFixedPrice;
import fpml.consolidated.com.validation.SettlementPeriodsFixedPriceTypeFormatValidator;
import fpml.consolidated.com.validation.SettlementPeriodsFixedPriceValidator;
import fpml.consolidated.com.validation.exists.SettlementPeriodsFixedPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriodsFixedPrice.class)
public class SettlementPeriodsFixedPriceMeta implements RosettaMetaData<SettlementPeriodsFixedPrice> {

	@Override
	public List<Validator<? super SettlementPeriodsFixedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodsFixedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriodsFixedPrice> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsFixedPrice>create(SettlementPeriodsFixedPriceValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriodsFixedPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsFixedPrice>create(SettlementPeriodsFixedPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsFixedPrice> validator() {
		return new SettlementPeriodsFixedPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsFixedPrice> typeFormatValidator() {
		return new SettlementPeriodsFixedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodsFixedPrice, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsFixedPriceOnlyExistsValidator();
	}
}
