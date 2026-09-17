package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.validation.ProductIdentifierTypeFormatValidator;
import cdm.base.staticdata.asset.common.validation.ProductIdentifierValidator;
import cdm.base.staticdata.asset.common.validation.exists.ProductIdentifierOnlyExistsValidator;
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
@RosettaMeta(model=ProductIdentifier.class)
public class ProductIdentifierMeta implements RosettaMetaData<ProductIdentifier> {

	@Override
	public List<Validator<? super ProductIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ProductIdentifier> validator(ValidatorFactory factory) {
		return factory.<ProductIdentifier>create(ProductIdentifierValidator.class);
	}

	@Override
	public Validator<? super ProductIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ProductIdentifier>create(ProductIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ProductIdentifier> validator() {
		return new ProductIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ProductIdentifier> typeFormatValidator() {
		return new ProductIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductIdentifier, Set<String>> onlyExistsValidator() {
		return new ProductIdentifierOnlyExistsValidator();
	}
}
