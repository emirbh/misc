package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetType;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingAssetTypeTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingAssetTypeValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlyingAssetTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlyingAssetType.class)
public class AnnaDsbUnderlyingAssetTypeMeta implements RosettaMetaData<AnnaDsbUnderlyingAssetType> {

	@Override
	public List<Validator<? super AnnaDsbUnderlyingAssetType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlyingAssetType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetType> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingAssetType>create(AnnaDsbUnderlyingAssetTypeValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlyingAssetType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingAssetType>create(AnnaDsbUnderlyingAssetTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetType> validator() {
		return new AnnaDsbUnderlyingAssetTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetType> typeFormatValidator() {
		return new AnnaDsbUnderlyingAssetTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlyingAssetType, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlyingAssetTypeOnlyExistsValidator();
	}
}
