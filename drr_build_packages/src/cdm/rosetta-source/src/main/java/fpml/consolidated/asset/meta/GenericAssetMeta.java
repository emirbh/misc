package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.GenericAsset;
import fpml.consolidated.asset.validation.GenericAssetTypeFormatValidator;
import fpml.consolidated.asset.validation.GenericAssetValidator;
import fpml.consolidated.asset.validation.exists.GenericAssetOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=GenericAsset.class)
public class GenericAssetMeta implements RosettaMetaData<GenericAsset> {

	@Override
	public List<Validator<? super GenericAsset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericAsset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GenericAsset> validator(ValidatorFactory factory) {
		return factory.<GenericAsset>create(GenericAssetValidator.class);
	}

	@Override
	public Validator<? super GenericAsset> typeFormatValidator(ValidatorFactory factory) {
		return factory.<GenericAsset>create(GenericAssetTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super GenericAsset> validator() {
		return new GenericAssetValidator();
	}

	@Deprecated
	@Override
	public Validator<? super GenericAsset> typeFormatValidator() {
		return new GenericAssetTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericAsset, Set<String>> onlyExistsValidator() {
		return new GenericAssetOnlyExistsValidator();
	}
}
