package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.Asset;
import fpml.consolidated.asset.validation.AssetTypeFormatValidator;
import fpml.consolidated.asset.validation.AssetValidator;
import fpml.consolidated.asset.validation.exists.AssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Asset.class)
public class AssetMeta implements RosettaMetaData<Asset> {

	@Override
	public List<Validator<? super Asset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Asset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Asset> validator(ValidatorFactory factory) {
		return factory.<Asset>create(AssetValidator.class);
	}

	@Override
	public Validator<? super Asset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Asset>create(AssetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Asset> validator() {
		return new AssetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Asset> typeFormatValidator() {
		return new AssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Asset, Set<String>> onlyExistsValidator() {
		return new AssetOnlyExistsValidator();
	}
}
