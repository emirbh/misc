package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityBasketOption;
import fpml.consolidated.com.validation.CommodityBasketOptionTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityBasketOptionValidator;
import fpml.consolidated.com.validation.datarule.CommodityBasketOptionChoice0;
import fpml.consolidated.com.validation.datarule.CommodityBasketOptionChoice1;
import fpml.consolidated.com.validation.datarule.CommodityBasketOptionChoice2;
import fpml.consolidated.com.validation.datarule.CommodityBasketOptionChoice3;
import fpml.consolidated.com.validation.exists.CommodityBasketOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBasketOption.class)
public class CommodityBasketOptionMeta implements RosettaMetaData<CommodityBasketOption> {

	@Override
	public List<Validator<? super CommodityBasketOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityBasketOption>create(CommodityBasketOptionChoice0.class),
			factory.<CommodityBasketOption>create(CommodityBasketOptionChoice1.class),
			factory.<CommodityBasketOption>create(CommodityBasketOptionChoice2.class),
			factory.<CommodityBasketOption>create(CommodityBasketOptionChoice3.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityBasketOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBasketOption> validator(ValidatorFactory factory) {
		return factory.<CommodityBasketOption>create(CommodityBasketOptionValidator.class);
	}

	@Override
	public Validator<? super CommodityBasketOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBasketOption>create(CommodityBasketOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketOption> validator() {
		return new CommodityBasketOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBasketOption> typeFormatValidator() {
		return new CommodityBasketOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBasketOption, Set<String>> onlyExistsValidator() {
		return new CommodityBasketOptionOnlyExistsValidator();
	}
}
