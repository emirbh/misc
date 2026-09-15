package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.AssetMeasureType;
import fpml.consolidated.asset.validation.AssetMeasureTypeTypeFormatValidator;
import fpml.consolidated.asset.validation.AssetMeasureTypeValidator;
import fpml.consolidated.asset.validation.exists.AssetMeasureTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AssetMeasureType.class)
public class AssetMeasureTypeMeta implements RosettaMetaData<AssetMeasureType> {

	@Override
	public List<Validator<? super AssetMeasureType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetMeasureType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetMeasureType> validator(ValidatorFactory factory) {
		return factory.<AssetMeasureType>create(AssetMeasureTypeValidator.class);
	}

	@Override
	public Validator<? super AssetMeasureType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetMeasureType>create(AssetMeasureTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetMeasureType> validator() {
		return new AssetMeasureTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetMeasureType> typeFormatValidator() {
		return new AssetMeasureTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetMeasureType, Set<String>> onlyExistsValidator() {
		return new AssetMeasureTypeOnlyExistsValidator();
	}
}
