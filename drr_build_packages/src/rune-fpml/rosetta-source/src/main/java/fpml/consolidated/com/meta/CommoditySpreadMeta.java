package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySpread;
import fpml.consolidated.com.validation.CommoditySpreadTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySpreadValidator;
import fpml.consolidated.com.validation.exists.CommoditySpreadOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySpread.class)
public class CommoditySpreadMeta implements RosettaMetaData<CommoditySpread> {

	@Override
	public List<Validator<? super CommoditySpread>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommoditySpread, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySpread> validator(ValidatorFactory factory) {
		return factory.<CommoditySpread>create(CommoditySpreadValidator.class);
	}

	@Override
	public Validator<? super CommoditySpread> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySpread>create(CommoditySpreadTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySpread> validator() {
		return new CommoditySpreadValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySpread> typeFormatValidator() {
		return new CommoditySpreadTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySpread, Set<String>> onlyExistsValidator() {
		return new CommoditySpreadOnlyExistsValidator();
	}
}
