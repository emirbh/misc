package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.UnderlyingAsset;
import fpml.consolidated.asset.validation.UnderlyingAssetTypeFormatValidator;
import fpml.consolidated.asset.validation.UnderlyingAssetValidator;
import fpml.consolidated.asset.validation.exists.UnderlyingAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnderlyingAsset.class)
public class UnderlyingAssetMeta implements RosettaMetaData<UnderlyingAsset> {

	@Override
	public List<Validator<? super UnderlyingAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyingAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnderlyingAsset> validator(ValidatorFactory factory) {
		return factory.<UnderlyingAsset>create(UnderlyingAssetValidator.class);
	}

	@Override
	public Validator<? super UnderlyingAsset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnderlyingAsset>create(UnderlyingAssetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAsset> validator() {
		return new UnderlyingAssetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyingAsset> typeFormatValidator() {
		return new UnderlyingAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyingAsset, Set<String>> onlyExistsValidator() {
		return new UnderlyingAssetOnlyExistsValidator();
	}
}
