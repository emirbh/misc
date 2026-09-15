package drr.standards.iosco.upi.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingAssetClassTypeFormatValidator;
import drr.standards.iosco.upi.validation.AnnaDsbUnderlyingAssetClassValidator;
import drr.standards.iosco.upi.validation.exists.AnnaDsbUnderlyingAssetClassOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=AnnaDsbUnderlyingAssetClass.class)
public class AnnaDsbUnderlyingAssetClassMeta implements RosettaMetaData<AnnaDsbUnderlyingAssetClass> {

	@Override
	public List<Validator<? super AnnaDsbUnderlyingAssetClass>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AnnaDsbUnderlyingAssetClass, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetClass> validator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingAssetClass>create(AnnaDsbUnderlyingAssetClassValidator.class);
	}

	@Override
	public Validator<? super AnnaDsbUnderlyingAssetClass> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AnnaDsbUnderlyingAssetClass>create(AnnaDsbUnderlyingAssetClassTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetClass> validator() {
		return new AnnaDsbUnderlyingAssetClassValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AnnaDsbUnderlyingAssetClass> typeFormatValidator() {
		return new AnnaDsbUnderlyingAssetClassTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AnnaDsbUnderlyingAssetClass, Set<String>> onlyExistsValidator() {
		return new AnnaDsbUnderlyingAssetClassOnlyExistsValidator();
	}
}
