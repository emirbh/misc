package drr.regulation.common.trade.price.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.validation.BarrierPriceTypeFormatValidator;
import drr.regulation.common.trade.price.validation.BarrierPriceValidator;
import drr.regulation.common.trade.price.validation.exists.BarrierPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=BarrierPrice.class)
public class BarrierPriceMeta implements RosettaMetaData<BarrierPrice> {

	@Override
	public List<Validator<? super BarrierPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BarrierPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BarrierPrice> validator(ValidatorFactory factory) {
		return factory.<BarrierPrice>create(BarrierPriceValidator.class);
	}

	@Override
	public Validator<? super BarrierPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BarrierPrice>create(BarrierPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BarrierPrice> validator() {
		return new BarrierPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BarrierPrice> typeFormatValidator() {
		return new BarrierPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BarrierPrice, Set<String>> onlyExistsValidator() {
		return new BarrierPriceOnlyExistsValidator();
	}
}
