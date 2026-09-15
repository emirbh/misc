package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityMetalBrandManager;
import fpml.consolidated.com.validation.CommodityMetalBrandManagerTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityMetalBrandManagerValidator;
import fpml.consolidated.com.validation.exists.CommodityMetalBrandManagerOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityMetalBrandManager.class)
public class CommodityMetalBrandManagerMeta implements RosettaMetaData<CommodityMetalBrandManager> {

	@Override
	public List<Validator<? super CommodityMetalBrandManager>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityMetalBrandManager, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityMetalBrandManager> validator(ValidatorFactory factory) {
		return factory.<CommodityMetalBrandManager>create(CommodityMetalBrandManagerValidator.class);
	}

	@Override
	public Validator<? super CommodityMetalBrandManager> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityMetalBrandManager>create(CommodityMetalBrandManagerTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalBrandManager> validator() {
		return new CommodityMetalBrandManagerValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityMetalBrandManager> typeFormatValidator() {
		return new CommodityMetalBrandManagerTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityMetalBrandManager, Set<String>> onlyExistsValidator() {
		return new CommodityMetalBrandManagerOnlyExistsValidator();
	}
}
