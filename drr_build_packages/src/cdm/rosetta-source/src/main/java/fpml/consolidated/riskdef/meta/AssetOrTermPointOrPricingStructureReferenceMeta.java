package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.AssetOrTermPointOrPricingStructureReference;
import fpml.consolidated.riskdef.validation.AssetOrTermPointOrPricingStructureReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.AssetOrTermPointOrPricingStructureReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.AssetOrTermPointOrPricingStructureReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AssetOrTermPointOrPricingStructureReference.class)
public class AssetOrTermPointOrPricingStructureReferenceMeta implements RosettaMetaData<AssetOrTermPointOrPricingStructureReference> {

	@Override
	public List<Validator<? super AssetOrTermPointOrPricingStructureReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssetOrTermPointOrPricingStructureReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> validator(ValidatorFactory factory) {
		return factory.<AssetOrTermPointOrPricingStructureReference>create(AssetOrTermPointOrPricingStructureReferenceValidator.class);
	}

	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssetOrTermPointOrPricingStructureReference>create(AssetOrTermPointOrPricingStructureReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> validator() {
		return new AssetOrTermPointOrPricingStructureReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssetOrTermPointOrPricingStructureReference> typeFormatValidator() {
		return new AssetOrTermPointOrPricingStructureReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetOrTermPointOrPricingStructureReference, Set<String>> onlyExistsValidator() {
		return new AssetOrTermPointOrPricingStructureReferenceOnlyExistsValidator();
	}
}
