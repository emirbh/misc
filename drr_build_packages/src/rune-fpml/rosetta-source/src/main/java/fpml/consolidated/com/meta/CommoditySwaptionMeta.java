package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySwaption;
import fpml.consolidated.com.validation.CommoditySwaptionTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySwaptionValidator;
import fpml.consolidated.com.validation.exists.CommoditySwaptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySwaption.class)
public class CommoditySwaptionMeta implements RosettaMetaData<CommoditySwaption> {

	@Override
	public List<Validator<? super CommoditySwaption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySwaption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySwaption> validator(ValidatorFactory factory) {
		return factory.<CommoditySwaption>create(CommoditySwaptionValidator.class);
	}

	@Override
	public Validator<? super CommoditySwaption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySwaption>create(CommoditySwaptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwaption> validator() {
		return new CommoditySwaptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySwaption> typeFormatValidator() {
		return new CommoditySwaptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySwaption, Set<String>> onlyExistsValidator() {
		return new CommoditySwaptionOnlyExistsValidator();
	}
}
