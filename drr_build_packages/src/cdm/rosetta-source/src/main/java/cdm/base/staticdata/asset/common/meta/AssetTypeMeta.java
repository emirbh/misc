package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.AssetType;
import cdm.base.staticdata.asset.common.validation.AssetTypeTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.AssetTypeValidator;
import cdm.base.staticdata.asset.common.validation.datarule.AssetTypeBondSubType;
import cdm.base.staticdata.asset.common.validation.datarule.AssetTypeEquitySubType;
import cdm.base.staticdata.asset.common.validation.datarule.AssetTypeFundSubType;
import cdm.base.staticdata.asset.common.validation.datarule.AssetTypeOtherAssetSubType;
import cdm.base.staticdata.asset.common.validation.datarule.AssetTypeSecuritySubType;
import cdm.base.staticdata.asset.common.validation.exists.AssetTypeOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=AssetType.class)
public class AssetTypeMeta implements RosettaMetaData<AssetType> {

	@Override
	public List<Validator<? super AssetType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetType>create(AssetTypeSecuritySubType.class),
			factory.<AssetType>create(AssetTypeBondSubType.class),
			factory.<AssetType>create(AssetTypeEquitySubType.class),
			factory.<AssetType>create(AssetTypeFundSubType.class),
			factory.<AssetType>create(AssetTypeOtherAssetSubType.class)
		);
	}
	
	@Override
	public List<Function<? super AssetType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetType> validator(ValidatorFactory factory) {
		return factory.<AssetType>create(AssetTypeValidator.class);
	}

	@Override
	public Validator<? super AssetType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetType>create(AssetTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetType> validator() {
		return new AssetTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetType> typeFormatValidator() {
		return new AssetTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetType, Set<String>> onlyExistsValidator() {
		return new AssetTypeOnlyExistsValidator();
	}
}
