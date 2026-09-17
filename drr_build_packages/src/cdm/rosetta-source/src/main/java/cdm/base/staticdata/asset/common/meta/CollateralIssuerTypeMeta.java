package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.validation.CollateralIssuerTypeTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.CollateralIssuerTypeValidator;
import cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeQuasiGovernmentSubType;
import cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeRegionalGovernmentSubType;
import cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeSpecialPurposeVehicleSubType;
import cdm.base.staticdata.asset.common.validation.datarule.CollateralIssuerTypeSupraNationalSubType;
import cdm.base.staticdata.asset.common.validation.exists.CollateralIssuerTypeOnlyExistsValidator;
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
@RosettaMeta(model=CollateralIssuerType.class)
public class CollateralIssuerTypeMeta implements RosettaMetaData<CollateralIssuerType> {

	@Override
	public List<Validator<? super CollateralIssuerType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralIssuerType>create(CollateralIssuerTypeSupraNationalSubType.class),
			factory.<CollateralIssuerType>create(CollateralIssuerTypeQuasiGovernmentSubType.class),
			factory.<CollateralIssuerType>create(CollateralIssuerTypeRegionalGovernmentSubType.class),
			factory.<CollateralIssuerType>create(CollateralIssuerTypeSpecialPurposeVehicleSubType.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralIssuerType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralIssuerType> validator(ValidatorFactory factory) {
		return factory.<CollateralIssuerType>create(CollateralIssuerTypeValidator.class);
	}

	@Override
	public Validator<? super CollateralIssuerType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralIssuerType>create(CollateralIssuerTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralIssuerType> validator() {
		return new CollateralIssuerTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralIssuerType> typeFormatValidator() {
		return new CollateralIssuerTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralIssuerType, Set<String>> onlyExistsValidator() {
		return new CollateralIssuerTypeOnlyExistsValidator();
	}
}
