package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityDigital;
import fpml.consolidated.com.validation.CommodityDigitalTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityDigitalValidator;
import fpml.consolidated.com.validation.exists.CommodityDigitalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityDigital.class)
public class CommodityDigitalMeta implements RosettaMetaData<CommodityDigital> {

	@Override
	public List<Validator<? super CommodityDigital>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityDigital, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityDigital> validator(ValidatorFactory factory) {
		return factory.<CommodityDigital>create(CommodityDigitalValidator.class);
	}

	@Override
	public Validator<? super CommodityDigital> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityDigital>create(CommodityDigitalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigital> validator() {
		return new CommodityDigitalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityDigital> typeFormatValidator() {
		return new CommodityDigitalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityDigital, Set<String>> onlyExistsValidator() {
		return new CommodityDigitalOnlyExistsValidator();
	}
}
