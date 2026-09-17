package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.AssetFlowBase;
import cdm.product.common.settlement.validation.AssetFlowBaseTypeFormatValidator;
import cdm.product.common.settlement.validation.AssetFlowBaseValidator;
import cdm.product.common.settlement.validation.datarule.AssetFlowBaseQuantityUnitExists;
import cdm.product.common.settlement.validation.exists.AssetFlowBaseOnlyExistsValidator;
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
@RosettaMeta(model=AssetFlowBase.class)
public class AssetFlowBaseMeta implements RosettaMetaData<AssetFlowBase> {

	@Override
	public List<Validator<? super AssetFlowBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AssetFlowBase>create(AssetFlowBaseQuantityUnitExists.class)
		);
	}
	
	@Override
	public List<Function<? super AssetFlowBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetFlowBase> validator(ValidatorFactory factory) {
		return factory.<AssetFlowBase>create(AssetFlowBaseValidator.class);
	}

	@Override
	public Validator<? super AssetFlowBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetFlowBase>create(AssetFlowBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetFlowBase> validator() {
		return new AssetFlowBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetFlowBase> typeFormatValidator() {
		return new AssetFlowBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetFlowBase, Set<String>> onlyExistsValidator() {
		return new AssetFlowBaseOnlyExistsValidator();
	}
}
