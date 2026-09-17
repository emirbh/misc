package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AssociationToAssetIdentifier;
import fpml.consolidated.loan.validation.AssociationToAssetIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.AssociationToAssetIdentifierValidator;
import fpml.consolidated.loan.validation.exists.AssociationToAssetIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AssociationToAssetIdentifier.class)
public class AssociationToAssetIdentifierMeta implements RosettaMetaData<AssociationToAssetIdentifier> {

	@Override
	public List<Validator<? super AssociationToAssetIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AssociationToAssetIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssociationToAssetIdentifier> validator(ValidatorFactory factory) {
		return factory.<AssociationToAssetIdentifier>create(AssociationToAssetIdentifierValidator.class);
	}

	@Override
	public Validator<? super AssociationToAssetIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AssociationToAssetIdentifier>create(AssociationToAssetIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AssociationToAssetIdentifier> validator() {
		return new AssociationToAssetIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AssociationToAssetIdentifier> typeFormatValidator() {
		return new AssociationToAssetIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssociationToAssetIdentifier, Set<String>> onlyExistsValidator() {
		return new AssociationToAssetIdentifierOnlyExistsValidator();
	}
}
