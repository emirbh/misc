package cdm.product.asset.meta;

import cdm.product.asset.ReferencePool;
import cdm.product.asset.validation.ReferencePoolTypeFormatValidator;
import cdm.product.asset.validation.ReferencePoolValidator;
import cdm.product.asset.validation.datarule.ReferencePoolFpML_cd_44_basketPercentage;
import cdm.product.asset.validation.datarule.ReferencePoolFpML_cd_44_openUnits;
import cdm.product.asset.validation.exists.ReferencePoolOnlyExistsValidator;
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
@RosettaMeta(model=ReferencePool.class)
public class ReferencePoolMeta implements RosettaMetaData<ReferencePool> {

	@Override
	public List<Validator<? super ReferencePool>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ReferencePool>create(ReferencePoolFpML_cd_44_openUnits.class),
			factory.<ReferencePool>create(ReferencePoolFpML_cd_44_basketPercentage.class)
		);
	}
	
	@Override
	public List<Function<? super ReferencePool, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferencePool> validator(ValidatorFactory factory) {
		return factory.<ReferencePool>create(ReferencePoolValidator.class);
	}

	@Override
	public Validator<? super ReferencePool> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferencePool>create(ReferencePoolTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePool> validator() {
		return new ReferencePoolValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePool> typeFormatValidator() {
		return new ReferencePoolTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePool, Set<String>> onlyExistsValidator() {
		return new ReferencePoolOnlyExistsValidator();
	}
}
