package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFxType;
import fpml.consolidated.com.validation.CommodityFxTypeTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityFxTypeValidator;
import fpml.consolidated.com.validation.exists.CommodityFxTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityFxType.class)
public class CommodityFxTypeMeta implements RosettaMetaData<CommodityFxType> {

	@Override
	public List<Validator<? super CommodityFxType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityFxType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityFxType> validator(ValidatorFactory factory) {
		return factory.<CommodityFxType>create(CommodityFxTypeValidator.class);
	}

	@Override
	public Validator<? super CommodityFxType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityFxType>create(CommodityFxTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFxType> validator() {
		return new CommodityFxTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFxType> typeFormatValidator() {
		return new CommodityFxTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFxType, Set<String>> onlyExistsValidator() {
		return new CommodityFxTypeOnlyExistsValidator();
	}
}
