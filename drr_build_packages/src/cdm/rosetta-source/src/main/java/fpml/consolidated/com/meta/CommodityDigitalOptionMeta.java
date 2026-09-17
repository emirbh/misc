package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDigitalOption;
import fpml.consolidated.com.validation.CommodityDigitalOptionTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDigitalOptionValidator;
import fpml.consolidated.com.validation.datarule.CommodityDigitalOptionChoice0;
import fpml.consolidated.com.validation.datarule.CommodityDigitalOptionChoice1;
import fpml.consolidated.com.validation.exists.CommodityDigitalOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDigitalOption.class)
public class CommodityDigitalOptionMeta implements RosettaMetaData<CommodityDigitalOption> {

	@Override
	public List<Validator<? super CommodityDigitalOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityDigitalOption>create(CommodityDigitalOptionChoice0.class),
			factory.<CommodityDigitalOption>create(CommodityDigitalOptionChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityDigitalOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDigitalOption> validator(ValidatorFactory factory) {
		return factory.<CommodityDigitalOption>create(CommodityDigitalOptionValidator.class);
	}

	@Override
	public Validator<? super CommodityDigitalOption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDigitalOption>create(CommodityDigitalOptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigitalOption> validator() {
		return new CommodityDigitalOptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigitalOption> typeFormatValidator() {
		return new CommodityDigitalOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigitalOption, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalOptionOnlyExistsValidator();
	}
}
