package drr.base.trade.price.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.validation.PriceFormatTypeFormatValidator;
import drr.base.trade.price.validation.PriceFormatValidator;
import drr.base.trade.price.validation.datarule.PriceFormatOneOf0;
import drr.base.trade.price.validation.exists.PriceFormatOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=PriceFormat.class)
public class PriceFormatMeta implements RosettaMetaData<PriceFormat> {

	@Override
	public List<Validator<? super PriceFormat>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PriceFormat>create(PriceFormatOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super PriceFormat, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceFormat> validator(ValidatorFactory factory) {
		return factory.<PriceFormat>create(PriceFormatValidator.class);
	}

	@Override
	public Validator<? super PriceFormat> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceFormat>create(PriceFormatTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceFormat> validator() {
		return new PriceFormatValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceFormat> typeFormatValidator() {
		return new PriceFormatTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceFormat, Set<String>> onlyExistsValidator() {
		return new PriceFormatOnlyExistsValidator();
	}
}
