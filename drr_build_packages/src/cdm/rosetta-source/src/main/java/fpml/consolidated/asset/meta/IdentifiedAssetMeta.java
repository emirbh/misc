package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.IdentifiedAsset;
import fpml.consolidated.asset.validation.IdentifiedAssetTypeFormatValidator;
import fpml.consolidated.asset.validation.IdentifiedAssetValidator;
import fpml.consolidated.asset.validation.exists.IdentifiedAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IdentifiedAsset.class)
public class IdentifiedAssetMeta implements RosettaMetaData<IdentifiedAsset> {

	@Override
	public List<Validator<? super IdentifiedAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IdentifiedAsset> validator(ValidatorFactory factory) {
		return factory.<IdentifiedAsset>create(IdentifiedAssetValidator.class);
	}

	@Override
	public Validator<? super IdentifiedAsset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IdentifiedAsset>create(IdentifiedAssetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedAsset> validator() {
		return new IdentifiedAssetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedAsset> typeFormatValidator() {
		return new IdentifiedAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedAsset, Set<String>> onlyExistsValidator() {
		return new IdentifiedAssetOnlyExistsValidator();
	}
}
