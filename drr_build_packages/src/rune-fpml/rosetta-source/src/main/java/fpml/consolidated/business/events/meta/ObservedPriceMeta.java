package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ObservedPrice;
import fpml.consolidated.business.events.validation.ObservedPriceTypeFormatValidator;
import fpml.consolidated.business.events.validation.ObservedPriceValidator;
import fpml.consolidated.business.events.validation.exists.ObservedPriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObservedPrice.class)
public class ObservedPriceMeta implements RosettaMetaData<ObservedPrice> {

	@Override
	public List<Validator<? super ObservedPrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservedPrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservedPrice> validator(ValidatorFactory factory) {
		return factory.<ObservedPrice>create(ObservedPriceValidator.class);
	}

	@Override
	public Validator<? super ObservedPrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObservedPrice>create(ObservedPriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObservedPrice> validator() {
		return new ObservedPriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObservedPrice> typeFormatValidator() {
		return new ObservedPriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservedPrice, Set<String>> onlyExistsValidator() {
		return new ObservedPriceOnlyExistsValidator();
	}
}
