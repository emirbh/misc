package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityNotionalAmountReference;
import fpml.consolidated.com.validation.CommodityNotionalAmountReferenceTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityNotionalAmountReferenceValidator;
import fpml.consolidated.com.validation.exists.CommodityNotionalAmountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityNotionalAmountReference.class)
public class CommodityNotionalAmountReferenceMeta implements RosettaMetaData<CommodityNotionalAmountReference> {

	@Override
	public List<Validator<? super CommodityNotionalAmountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalAmountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityNotionalAmountReference> validator(ValidatorFactory factory) {
		return factory.<CommodityNotionalAmountReference>create(CommodityNotionalAmountReferenceValidator.class);
	}

	@Override
	public Validator<? super CommodityNotionalAmountReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityNotionalAmountReference>create(CommodityNotionalAmountReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalAmountReference> validator() {
		return new CommodityNotionalAmountReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalAmountReference> typeFormatValidator() {
		return new CommodityNotionalAmountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalAmountReference, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalAmountReferenceOnlyExistsValidator();
	}
}
