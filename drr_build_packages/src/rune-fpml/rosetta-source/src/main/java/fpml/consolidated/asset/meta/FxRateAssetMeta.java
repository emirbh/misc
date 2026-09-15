package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FxRateAsset;
import fpml.consolidated.asset.validation.FxRateAssetTypeFormatValidator;
import fpml.consolidated.asset.validation.FxRateAssetValidator;
import fpml.consolidated.asset.validation.exists.FxRateAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRateAsset.class)
public class FxRateAssetMeta implements RosettaMetaData<FxRateAsset> {

	@Override
	public List<Validator<? super FxRateAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRateAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRateAsset> validator(ValidatorFactory factory) {
		return factory.<FxRateAsset>create(FxRateAssetValidator.class);
	}

	@Override
	public Validator<? super FxRateAsset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRateAsset>create(FxRateAssetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRateAsset> validator() {
		return new FxRateAssetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRateAsset> typeFormatValidator() {
		return new FxRateAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRateAsset, Set<String>> onlyExistsValidator() {
		return new FxRateAssetOnlyExistsValidator();
	}
}
